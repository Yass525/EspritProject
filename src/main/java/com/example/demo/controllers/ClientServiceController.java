package com.example.demo.controllers;

import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.response.ResponseHandler;
import com.example.demo.services.IClient;

@RestController
public class ClientServiceController {
	@Autowired
	IClient clientServices;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/")
	public String homen() {

		return "home page";
	}

	@GetMapping("/admin")
    public String homeAdmin() {

        return "This is admin page";
    }
	@GetMapping("/user")
    public String homeUser() {

        return "This is user page";
    }


	// http://localhost:8082/SpringMVC/servlet/retrieve-all-clients
	@GetMapping("admin/retrieve-all-clients")
	@ResponseBody
	public List<Client> getClients() {
		List<Client> listClients = clientServices.retrieveAllClients();
		return listClients;
	}


	// http://localhost:8082/SpringMVC/servlet/add-client
	@PostMapping("/add-client")
	@ResponseBody
	public ResponseEntity<Object> addClient(@RequestBody Client c) {

		Client client1 = clientRepository.findByEmailAddress(c.geteMail());
		if (client1 == null) {
			c.setPassword(passwordEncoder.encode(c.getPassword()));

			Client client = clientServices.addClient(c);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, client);

		} else {

			//throw new IllegalArgumentException("Mail alreasy exists");
			return ResponseHandler.generateResponse("Mail already exists", HttpStatus.MULTI_STATUS, "ss");
		}
	}

	// http://localhost:8082/SpringMVC/servlet/retrieve-client/8
	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientServices.retrieveClient(clientId);

	}
	
	// http://localhost:8082/SpringMVC/servlet/remove-client/{client-id}

	@DeleteMapping("admin/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long id) {
		clientServices.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

		clientServices.deleteClient(id);
	}
	
	// http://localhost:8082/SpringMVC/servlet/update-client/{client-id}
	@PutMapping("/update-client/{client-id}")
	@ResponseBody
	public Client updateClient(@RequestBody Client c, @PathVariable("client-id") Long id)
	{
		clientServices.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid user ID"));
		c.setPassword(passwordEncoder.encode(c.getPassword()));
		Client client_updated = clientServices.updateClient(c);
		return client_updated;
	}

	
	
}
