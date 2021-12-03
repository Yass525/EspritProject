package com.example.demo.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.CategoryClient;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Facture;
import com.example.demo.repositories.FactureRepository;
import com.example.demo.services.IFacture;
@RestController
public class FactureRestController {
	@Autowired
	IFacture factureService;
	
	@Autowired
	FactureRepository factureRepository;
	
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
		
		// http://localhost:8082/SpringMVC/servlet/findInvoiceByClientId/1
		@GetMapping("/findInvoiceByClientId/{id}")
		@ResponseBody
		public List<Facture> findInvoiceByClientId(@PathVariable("id") Long id ) {
			List<Facture>listFactures = factureRepository.findInvoiceByClientId(id);
			return listFactures;
		}
		
		 //localhost:8082/findInvoiceGroupedByCategorie
		 @GetMapping("/findInvoiceGroupedByCategorie")
		 @ResponseBody
		 	public <T> List<T> findInvoiceGroupedByCategorie( ) {
				List<T> listFactures = factureRepository.findInvoiceGroupedByCategorie();
				return listFactures;
			}

}