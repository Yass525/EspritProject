package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.service.ClientService;
import com.example.demo.service.Iclient;

@RestController
public class ClientRestController {
	@Autowired
	Iclient clientService; //couplage faible
	@GetMapping("/getAllclient") //methode get
	@ResponseBody
	public List<Client> findAll(){
		
    List<Client>listclients= clientService.findAll();
    return listclients;

	}
	@PostMapping("/add_client")
	@ResponseBody
	public Client add(@RequestBody Client c){
		Client client =clientService.add(c);
		return client;
		
	}
	
	//http://localhost:numport/contextpath(springMVC)/path/ordre(get,post,put)
	//migration du format java au json serialisation 
	
	//localhost:8089/SpringMvc)/servlet/getAllclient
	
	@DeleteMapping("/remove-client/{client-id}")

	@ResponseBody

	public void delete(@PathVariable("client-id") Long id) {

	clientService.delete(id);

	}
	@PutMapping("/modify-client/{id}")

	@ResponseBody

	public Client update( @PathVariable("id")Long id,@RequestBody Client u) {
		Client client = clientService.update(u);
		return client;
	

	}
	
	

}
