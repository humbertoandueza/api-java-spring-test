package com.azurian.apirest.service.impl;

import com.azurian.apirest.model.dao.ClientDao;
import com.azurian.apirest.model.dto.ClientDto;
import com.azurian.apirest.model.entity.Client;
import com.azurian.apirest.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientImplService implements IClientService {

    @Autowired
    private ClientDao clientDao;

    @Transactional(readOnly = true)
    @Override
    public Page<Client> findAll(int page, int size, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        return clientDao.findAll(pageRequest);
    }

    @Transactional
    @Override
    public Client save(ClientDto clientDto) {
        Client client = Client.builder()
                .clientId(clientDto.getClientId())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .email(clientDto.getEmail())
                .phone(clientDto.getPhone())
                .address(clientDto.getAddress())
                .build();

        return clientDao.save(client);
    }

    @Transactional(readOnly = true)
    @Override
    public Client findById(Integer id) {
        return clientDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }

    @Override
    public boolean existById(Integer id) {
        return clientDao.existsById(id);
    }

}
