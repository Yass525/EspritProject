package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Client;
import com.example.demo.entities.Fournisseur;

public interface IFournisseur {

	Fournisseur add(Fournisseur fournisseur);
	Fournisseur update(Fournisseur fournisseur, Long id);
	Fournisseur findById(Long id);
	List<Fournisseur>findAll();
	void delete(long id);
	
}
