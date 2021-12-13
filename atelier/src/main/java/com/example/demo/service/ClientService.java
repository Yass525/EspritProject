package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;
import com.example.demo.entities.Profession;
import com.example.demo.repository.ClientRepository;

@Service


public class ClientService implements Iclient{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }


    @Override
    public Client findById(Long id) {
        return clientRepository.getById(id);
    }
}