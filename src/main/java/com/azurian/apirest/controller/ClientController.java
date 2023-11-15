package com.azurian.apirest.controller;

import com.azurian.apirest.model.dto.ClientDto;
import com.azurian.apirest.model.entity.Client;
import com.azurian.apirest.model.payload.MessageResponse;
import com.azurian.apirest.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private IClientService ClientService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/clients")
    public ResponseEntity<MessageResponse<ClientDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "clientId") String sortBy) {

        Page<Client> clients = ClientService.findAll(page, size, sortBy);
        return MessageResponse.handleResponse("Clients", HttpStatus.OK, clients);
    }

    @PostMapping("/client/create")
    public ResponseEntity<?> create(@RequestBody ClientDto clientDto) {
        Client clientSave = null;
        try {
            clientSave =  ClientService.save(clientDto);
            clientDto = modelMapper.map(clientSave, ClientDto.class);
            return MessageResponse.handleResponse("Client created successfully", HttpStatus.CREATED, clientDto);
        }
        catch (DataAccessException exDt) {
            return MessageResponse.handleResponse(exDt.getMessage(), HttpStatus.BAD_REQUEST, clientDto);
        }
    }

    @PutMapping("/client/update/{id}")
    public ResponseEntity<?> update(@RequestBody ClientDto clientDto,@PathVariable Integer id) {
        Client clientUpdate = null;
        try {
            if(ClientService.existById(id)) {
                clientDto.setClientId(Long.valueOf(id));
                clientUpdate =  ClientService.save(clientDto);
                clientDto = modelMapper.map(clientUpdate, ClientDto.class);
                return MessageResponse.handleResponse("Client updated successfully", HttpStatus.CREATED, clientDto);
            } else {
                return MessageResponse.handleResponse("Client not found", HttpStatus.NOT_FOUND, null);
            }
        }
        catch (DataAccessException exDt) {
            return MessageResponse.handleResponse(exDt.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Client clientDelete = ClientService.findById(id);
            ClientService.delete(clientDelete);
            return MessageResponse.handleResponse("", HttpStatus.NO_CONTENT, null);
        }
        catch (DataAccessException exDt){
            return MessageResponse.handleResponse(exDt.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
            Client client =  ClientService.findById(id);
            if(client == null) {
                return MessageResponse.handleResponse("Client not found", HttpStatus.NOT_FOUND, null);
            }
            ClientDto clientDto = modelMapper.map(client, ClientDto.class);
            return MessageResponse.handleResponse("", HttpStatus.OK, clientDto);
    }
}
