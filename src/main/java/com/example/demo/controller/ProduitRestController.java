package com.example.demo.controller;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produit;
import com.example.demo.services.IProduit;



@RestController
public class ProduitRestController {
	@Autowired
	IProduit ProduitService; //couplage faible
	//http://localhost:8088/SpringMVC/servlet/add_produit
	@GetMapping("/getAllproduit") //methode get

	@ResponseBody
public List<Produit> findAll(){
		
	    List<Produit>listProduit= ProduitService.retrieveAllProduits();
	    return listProduit;
	}
    
	@PostMapping("/add_produit")
	@ResponseBody
	public Produit add(@RequestBody Produit p){
		Produit produit =ProduitService.addProduit(p);
		return produit;}
	
	
		
	
    @DeleteMapping("/remove-produit/{produit-id}")

	@ResponseBody

	public void delete(@PathVariable("produit-id") Long id) {

    	ProduitService.deleteProduit(id);

	}
	@PutMapping("/modify-produit/{id}")

	@ResponseBody

	public Produit update( @PathVariable("id")Long id,@RequestBody Produit u) {
		Produit p= ProduitService.updateProduit(u);
		
	return p;

	}
	
	@PostMapping("addtostock/{id_produit}/{id_stock}")
	@Transactional
	@ResponseBody
	public void affecter(@PathVariable("id_produit") Long idProduit, @PathVariable ("id_stock")Long idStock) {
		ProduitService.affectProduitToStock(idProduit,idStock);
	}
	//@PostMapping("/affecterFournisseurProduit/{idfournisseur}/{idproduit}")
		
	//@ResponseBody
	
	//public void affecterFournisseurToProduit (@PathVariable("id_fournisseur") Long id_fournisseur,@PathVariable("id_produit")Long id_produit){
		//FournisseurService.affecterFournisseurToProduit(id_fournisseur,id_produit);
	//}

	}


