package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entities.Fournisseur;
import com.example.demo.service.IFournisseur;

@RestController

public class FournisseurRestController {
	
	@Autowired
	
	IFournisseur FournisseurService; //couplage faible
	//http://localhost:8088/SpringMVC/servlet/add_produit
	@GetMapping("/Fournisseur") //methode get

	@ResponseBody
	public Fournisseur add(@RequestBody Fournisseur p){
		Fournisseur fournisseur =FournisseurService.add(p);
		return fournisseur;
		}
    
	@PostMapping("/allFournisseur")
	@ResponseBody
	public List<Fournisseur> findAll(){
		
	    List<Fournisseur>listFournisseur= FournisseurService.findAll();
	    return listFournisseur;
	
		
	}
    @DeleteMapping("/remove-Fournisseur/{Fournisseur-id}")

	@ResponseBody

	public void delete(@PathVariable("Fournisseur-id") Long id) {

    	FournisseurService.delete(id);

	}
	@PutMapping("/modify-Fournisseur/{id}")

	@ResponseBody

	public Fournisseur update( @PathVariable("id")Long id,@RequestBody Fournisseur u) {
		Fournisseur p= FournisseurService.update(u,id);
		
	return p;

	
	
	

	}}