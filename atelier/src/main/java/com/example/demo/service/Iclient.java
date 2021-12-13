package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Client;

public interface Iclient {
    Client add(Client client);
    Client update(Client client);
   void delete(long id);
    List<Client> findAll();
    Client findById(Long id);
}
