package com.example.demo.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.entity.Fournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFournisseur {
	List <Fournisseur>  retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur fou);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur FF);

	Fournisseur retrieveFournisseur(Long id);

	Fournisseur findFournisseurBylibelle(String s);

	void deleteAllFournisseurs();

	Boolean checkIfExist(Long id);

	Map<String, Set<Fournisseur>> getFournisseursParProduits();

	Map<String, Long> getNbrProduitsParFournisseurs();

	Set<Fournisseur> addProduitFournit(Long idP, Long idF);

	Page<Fournisseur> getFournisseursPagedAndSorted(int offset, int pageSize, String field);

	Page<Fournisseur> getFournisseursPaged(Pageable pageable);

}
