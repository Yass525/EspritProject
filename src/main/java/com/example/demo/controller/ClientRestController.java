package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;
import com.example.demo.services.IClient;

@RestController
public class ClientRestController {
	@Autowired
	IClient clientService;
	//http://localhost:8081/SpringMVC/servlet/getAllclient
	@GetMapping("/getAllclient")
	//format json
	@ResponseBody
	public List<Client> getAllClient(){
		List<Client>listClients=clientService.retrieveAllClients();
		return listClients;
		
	}
	// http://localhost:8081/SpringMVC/client/add-client

	@PostMapping("/add-client")

	@ResponseBody

	public Client addClient(@RequestBody Client c)

	{

	Client client = clientService.addClient(c);

	return client;

	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-client/1

	@GetMapping("/retrieve-client/{client-id}")

	@ResponseBody

	public Client retrieveClient(@PathVariable("client-id") Long clientId) {

	return clientService.retrieveClient(clientId);
	}
	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}

	@DeleteMapping("/remove-client/{client-id}")

	@ResponseBody

	public void removeClient(@PathVariable("client-id") Long clientId) {

	clientService.deleteClient(clientId);

	}
	

}
