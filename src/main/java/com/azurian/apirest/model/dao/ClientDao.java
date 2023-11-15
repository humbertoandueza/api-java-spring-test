package com.azurian.apirest.model.dao;

import com.azurian.apirest.model.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientDao extends CrudRepository<Client,Integer>, PagingAndSortingRepository<Client,Integer> {

}
