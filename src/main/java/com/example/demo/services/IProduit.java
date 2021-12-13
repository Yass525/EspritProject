package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Produit;

public interface IProduit {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p);

	void deleteProduit(Long id);

	Produit updateProduit(Produit u);

	Produit retrieveProduit(Long id);
	String affectProduitToStock(Long idProduit,Long idStock);

}
