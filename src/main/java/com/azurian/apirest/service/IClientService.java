package com.azurian.apirest.service;

import com.azurian.apirest.model.dto.ClientDto;
import com.azurian.apirest.model.entity.Client;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IClientService {

    Page<Client> findAll(int page, int size, String sortBy);

    Client save(ClientDto client);

    Client findById(Integer id);

    void delete(Client client);

    boolean existById(Integer id);
}
