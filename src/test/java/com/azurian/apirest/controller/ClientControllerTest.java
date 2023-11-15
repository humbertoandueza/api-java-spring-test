package com.azurian.apirest.controller;

import com.azurian.apirest.model.dto.ClientDto;
import com.azurian.apirest.model.entity.Client;
import com.azurian.apirest.service.IClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClientService clientService;

    @Test
    void testFindAll() throws Exception {
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client(1L, "Humberto", "Andueza", "Barrio el cambio sector 2 de febrero callejon 1", "humberto@example.com", "1234567890"));
        clientList.add(new Client(2L, "Humberto", "Andueza", "Barrio el cambio sector 2 de febrero callejon 1", "humberto@example.com", "1234567890"));
        clientList.add(new Client(3L, "Humberto", "Andueza", "Barrio el cambio sector 2 de febrero callejon 1", "humberto@example.com", "1234567890"));

        Page<Client> mockedClientPage = new PageImpl<>(clientList, Pageable.unpaged(), clientList.size());
        when(clientService.findAll(anyInt(), anyInt(), anyString())).thenReturn(mockedClientPage);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/clients"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    void testCreate() throws Exception {
        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName("Humberto");
        clientDto.setLastName("Andueza");
        clientDto.setAddress("Barrio el cambio sector 2 de febrero callejon 1");
        clientDto.setEmail("humberto@example.com");
        clientDto.setPhone("1234567890");
        Client mockedClient = mock(Client.class);
        String clientDtoJson = new ObjectMapper().writeValueAsString(clientDto);

        when(clientService.save(any(ClientDto.class))).thenReturn(mockedClient);


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/client/create")
                        .content(clientDtoJson)
                        .contentType("application/json"))
                .andExpect(status().isCreated())
                .andReturn();

        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
    }

    @Test
    void testCreateBadRequest() throws Exception {
        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName("Humberto");
        clientDto.setLastName("Andueza");
        clientDto.setAddress("Barrio el cambio sector 2 de febrero callejon 1");
        clientDto.setEmail("humberto@example.com");
        clientDto.setPhone("1234567890");
        String clientDtoJson = new ObjectMapper().writeValueAsString(clientDto);

        when(clientService.save(any(ClientDto.class))).thenThrow(new DataAccessException("Error saving client") {});

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/client/create")
                        .content(clientDtoJson)
                        .contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
    }

    @Test
    void testUpdate() throws Exception {
        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName("Humberto");
        clientDto.setLastName("Andueza");
        clientDto.setAddress("Barrio el cambio sector 2 de febrero callejon 1");
        clientDto.setEmail("humberto@example.com");
        clientDto.setPhone("1234567890");
        Client mockedClient = mock(Client.class);
        when(clientService.existById(anyInt())).thenReturn(true);
        when(clientService.save(any(ClientDto.class))).thenReturn(mockedClient);

        String clientDtoJson = new ObjectMapper().writeValueAsString(clientDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/client/update/1")
                        .content(clientDtoJson)
                        .contentType("application/json"))
                .andExpect(status().isCreated())
                .andReturn();

        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
    }

    @Test
    void testUpdateClientNotFound() throws Exception {
        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName("Humberto");
        clientDto.setLastName("Andueza");
        clientDto.setAddress("Barrio el cambio sector 2 de febrero callejon 1");
        clientDto.setEmail("humberto@example.com");
        clientDto.setPhone("1234567890");
        String clientDtoJson = new ObjectMapper().writeValueAsString(clientDto);
        when(clientService.existById(anyInt())).thenReturn(false);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/client/update/1")
                        .content(clientDtoJson)
                        .contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
    }

    @Test
    void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/client/1"))
                .andExpect(status().isNoContent())
                .andReturn();

        assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());
    }

    @Test
    void testShowById() throws Exception {
        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName("Humberto");
        clientDto.setLastName("Andueza");
        clientDto.setAddress("Barrio el cambio sector 2 de febrero callejon 1");
        clientDto.setEmail("humberto@example.com");
        clientDto.setPhone("1234567890");
        Client mockedClient = mock(Client.class);
        when(clientService.findById(anyInt())).thenReturn(mockedClient);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/client/1"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    void testShowByIdClientNotFound() throws Exception {
        when(clientService.findById(anyInt())).thenReturn(null);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/client/1"))
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
    }
}
