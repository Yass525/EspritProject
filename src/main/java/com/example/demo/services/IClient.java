package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Client;

public interface IClient {
	List<Client> retrieveAllClients();

    Client  addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);

	Optional<Client> findById(Long id);
	
	
}
