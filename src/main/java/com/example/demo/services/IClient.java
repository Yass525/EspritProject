package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Client;

public interface IClient {
	List<Client> retrieveAllClients();

    Client  addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client l);

	Client retrieveClient(Long id);

}
