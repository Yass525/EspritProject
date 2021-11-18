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


import com.example.demo.entity.Facture;

import com.example.demo.services.IFacture;
@RestController
public class FactureRestController {
	@Autowired
	IFacture factureService;
	
	
	//http://localhost:8081/SpringMVC/servlet/getAllFactures
	@GetMapping("/getAllFactures")
	@ResponseBody
	public List<Facture> getAllFactures(){
		List<Facture>listFactures=factureService.retrieveAllFactures();
		return listFactures;
	}
	// http://localhost:8081/SpringMVC/servlet/add-facture

		@PostMapping("/add-facture")

		@ResponseBody

		public Facture addFacture(@RequestBody Facture F)

		{

		    Facture facture = factureService.addFacture(F);

		    return facture;

		}
		// http://localhost:8081/SpringMVC/servlet/retrieve-facture/1

		@GetMapping("/retrieve-facture/{facture-id}")

		@ResponseBody

		public Facture retrieveFacture(@PathVariable("facture-id") Long IdFacture ) {

		return factureService.retrieveFacture(IdFacture);
		}
		// http://localhost:8089/SpringMVC/servlet/remove-facture/{facture-id}

		@DeleteMapping("/remove-facture/{facture-id}")

		@ResponseBody

		public void removeFacture(@PathVariable("facture-id") Long IdFacture ) {

			factureService.deleteFacture(IdFacture);

		}
		
	

}
