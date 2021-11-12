package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;

import com.example.demo.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements IClient {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		List<Client> clients = (List<Client>) clientRepository.findAll();
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		clientRepository.save(c);
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client l) {
		// TODO Auto-generated method stub
		return clientRepository.save(l);
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		Client client =clientRepository.findById(id).orElse(null);
		return client;
	}

}
