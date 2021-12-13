package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.repositories.FactureRepository;
import com.example.demo.services.IClient;
import com.example.demo.services.IFacture;
import com.mysql.cj.protocol.Message;
@RestController
public class FactureRestController {
	@Autowired
	IFacture factureService;
	@Autowired
	IClient clientService;


	//http://localhost:8081/SpringMVC/servlet/getAllFactures
	@CrossOrigin("*")
	@GetMapping("/getAllFactures")
	@ResponseBody
	public List<Facture> getAllFactures(){
		List<Facture>listFactures=factureService.retrieveAllFactures();
		return listFactures;
	}
	// http://localhost:8081/SpringMVC/servlet/add-facture
	    @CrossOrigin("*")
		@PostMapping("/add-facture")

		@ResponseBody

		public Facture addFacture(@RequestBody Facture F )

		{

		    Facture facture = factureService.addFacture(F);

		    return facture;

		}
		// http://localhost:8081/SpringMVC/servlet/retrieve-facture/1
	    @CrossOrigin("*")
		@GetMapping("/retrieve-facture/{facture-id}")

		@ResponseBody

		public Facture retrieveFacture(@PathVariable("facture-id") Long IdFacture ) {

		return factureService.retrieveFacture(IdFacture);
		}
		// http://localhost:8081/SpringMVC/servlet/remove-facture/{facture-id}
	    @CrossOrigin("*")
		@DeleteMapping("/remove-facture/{facture-id}")

		@ResponseBody

		public void removeFacture(@PathVariable("facture-id") Long IdFacture ) {

			factureService.deleteFacture(IdFacture);

		}
		//http://localhost:8081/SpringMVC/servlet/updatefacture
	    @CrossOrigin("*")
		@PutMapping("/updatefacture")
		@ResponseBody
		public Facture updateFacture(@RequestBody Facture f){
			return factureService.updateFacture(f);
			
		}
		//http://localhost:8089/SpringMVC/servlet/rechercheclient/{client}
		//@GetMapping("/rechercheclient/{client}")
	//	@ResponseBody
		//public Facture getFactureByClient(@RequestBody Client client ){
		//	return  (Facture) factureRepository.getFactureByClient(client);
	//	}
	    
		@GetMapping("/recherche/{id}")
		public List<Facture>recherhe(@PathVariable(value="id") Long id,
				RedirectAttributes flash,Model model) {
			//Invoice invoice = clientService.findInvoiceById(id);
			List<Facture> invoice = clientService.fetchByIdWithClientWithInvoiceLine(id);
			
			if(invoice == null) {
				
				//model.put("facture","facture introuvable");
				model.addAttribute("error","lafactre");
			//	flash.addFlashAttribute("error", La facture n'existe pas);
				
				
			}
			
			return invoice;
		}
		@PostMapping("/ajout/{clientId}/{FactureId}")
		@Transactional
		@ResponseBody
		public String create(@PathVariable(value="clientId") Long IdClient, RedirectAttributes flash,@PathVariable(value="FactureId") Long IdFacture ) {
			Client client = clientService.retrieveClient(IdClient);
			if(client == null) {
				flash.addFlashAttribute("error", " client non existant");
				
			}
			Facture facture = factureService.retrieveFacture(IdFacture);
			facture.setClient(client);
		

			return "succes";
		}
		
		// @RequestMapping("/message")
		  //  public Message message(Int id) {
		    //    return new Message(id, "Ceci est un test");
		    //}
		
	

}
