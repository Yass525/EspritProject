package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Fournisseur;

public interface IFournisseur {
	List <Fournisseur>  retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur fou);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur FF);

	Fournisseur retrieveFournisseur(Long id);

}
