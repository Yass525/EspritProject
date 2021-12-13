package com.example.demo.service;

import java.awt.print.Pageable;
import java.util.List;

import com.example.demo.entities.Produit;
import com.example.demo.entities.Rayon;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;


public interface IProduit {

	Produit add(Produit produit);
	Produit update(Produit produit , Long id);
	void delete(long id);
	//List<Produit> findAll(String Keyword);
	List<Produit> findAll();
	Produit findById(Long id);
	//Iterable<Produit> getProduitByCode(String code);
	String affectProduitToStock(Long idProduct, Long stockId);

	String affectProduitToRayon(Long idProduct, Long rayonId);
	List<Produit> findAllByLibelle(String libelle);

    List<Produit> findByPrixGreaterThan(String prix);


    // Produit findProduitByRayon();
	//String affecterProduitToStock(Long idProduit, Long idStock);
	
	
	

	
	  
	    
	
}
