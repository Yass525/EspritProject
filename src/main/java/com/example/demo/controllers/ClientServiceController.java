package com.example.demo.controllers;

import static org.mockito.Mockito.doThrow;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Filter;

import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RandomString;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.response.ResponseHandler;
import com.example.demo.services.IClient;

import javax.servlet.http.HttpServletRequest;

@RestController

public class ClientServiceController {
	@Autowired
	IClient clientServices;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	Client client;

	@GetMapping("/")
	public String home() {

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
	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<Object> addClient(@RequestBody Client c,HttpServletRequest request) {

		Client client1 = clientRepository.findByEmailAddress(c.geteMail());
		if (client1 == null) {
			c.setPassword(passwordEncoder.encode(c.getPassword()));
			c.setEnabled(true);
			c.setRole("ROLE_USER");
			Client client = clientServices.addClient(c);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, client);

		} else {
			//throw new IllegalArgumentException("Mail alreasy exists");
			return ResponseHandler.generateResponse("Mail already exists", HttpStatus.MULTI_STATUS, "Mail already exists");
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
	@CrossOrigin(origins = "*")
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<Object> updateClient(@RequestBody Map<String,String> map,HttpServletRequest request)
	{
		System.out.println("hana fel update");
		System.out.println("nom :" + map.get("nom"));
		final  String authorizationHeader = request.getHeader("Authorization");

		String jwt = authorizationHeader.substring(7);
		Object email = jwtUtil.extractUsername(jwt);

		client = clientRepository.findByEmailAddress(String.valueOf(email));
		if (((map.get("eMail") != null) && (clientRepository.findByEmailAddress(map.get("eMail")) != null))) {
			return ResponseHandler.generateResponse("Mail already exists", HttpStatus.NOT_ACCEPTABLE,"mail exist");

		}
			try{
			if (!(map.get("nom").equals(""))){
				client.setNom(map.get("nom"));
			}
			if (!(map.get("prenom").equals(""))){
				client.setPrenom(map.get("prenom"));
			}
			if (!(map.get("dateNaissance").equals(""))){
				Date dates = new SimpleDateFormat("yyyy-MM-dd").parse(map.get("dateNaissance"));
				client.setDateNaissance(dates);
			}
			if (!(map.get("eMail").equals(""))){
				client.seteMail(map.get("eMail"));
			}
				clientServices.updateClient(client);
			return ResponseHandler.generateResponse("Successfully updated", HttpStatus.OK,client);

		}catch(Exception e){
			return ResponseHandler.generateResponse("Not updated", HttpStatus.NOT_ACCEPTABLE,e);

		}


	}

	@GetMapping("/ListClients")
	public ResponseEntity<Map<String, Object>> getAllClients(

			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size,
			@RequestParam(defaultValue = "IdClient")  String sortBy
	) {

		try {
			List<Client> clients = new ArrayList<Client>();
			//Pageable paging = (Pageable) PageRequest.of(page, size);

			Page<Client> pageClient;

				pageClient = clientRepository.findAll(
						PageRequest.of(
							page,
								size,
								Sort.Direction.ASC, sortBy

						)
				);

			clients = pageClient.getContent();
			System.out.println("s");
			Map<String, Object> response = new HashMap<>();
			response.put("clients", clients);
			response.put("currentPage", pageClient.getNumber());
			response.put("totalItems", pageClient.getTotalElements());
			response.put("totalPages", pageClient.getTotalPages());
			System.out.println("ss");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/profile")
	@ResponseBody
	public Client userProfile(HttpServletRequest request) {

		final  String authorizationHeader = request.getHeader("Authorization");

		String jwt = authorizationHeader.substring(7);
		Object email = jwtUtil.extractUsername(jwt);

		client = clientRepository.findByEmailAddress(String.valueOf(email));

		System.out.println(client);
		return client;


	}


	@DeleteMapping("/userProfile/{id}")
	@ResponseBody
	public Client userProfile(@PathVariable("id") Long id) {
		return clientServices.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

	}


}
