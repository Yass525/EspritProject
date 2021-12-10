package com.example.demo.services;

import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.entity.Produit;
import com.example.demo.repositories.ProduitRpository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Fournisseur;
import com.example.demo.repositories.FournisseurRepository;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class FournisseurServiceImpl implements IFournisseur {

	private final FournisseurRepository fournisseurRepository;
	private final ProduitRpository produitRpository;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		return fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		return fournisseurRepository.findById(id).orElse(null);
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		fournisseurRepository.save(f);
		return f;
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);
	}

	@Override
	public Boolean checkIfExist(Long id) {
		if (fournisseurRepository.existsById(id)){
			return TRUE;
		} else return FALSE;
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		fournisseurRepository.save(f);
		return f;
	}

	@Override
	public Fournisseur findFournisseurBylibelle(String s) {
		return fournisseurRepository.findByLibelleFournisseur(s);
	}

	@Override
	public void deleteAllFournisseurs() {
		fournisseurRepository.deleteAll();
	}

	@Override
	public Map<String, Set<Fournisseur>> getFournisseursParProduits() {
		Map<String, Set<Fournisseur>> produitDetails = new HashMap<>();
		for (Produit produit: produitRpository.findAll()) {
			produitDetails.put(produit.getLibelle(),produit.getFournisseur());
		}
		return produitDetails;
	}

	@Override
	public Map<String, Long> getNbrProduitsParFournisseurs() {
		List<Produit> produits = produitRpository.findAll();
		List<String> fournisseurs = new ArrayList<>();
		for (Produit produit : produits) {
			for (Fournisseur f: produit.getFournisseur()) {
				fournisseurs.add(f.getLibelleFournisseur());
			}
		}
		return fournisseurs.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
	}

	@Override
	public Set<Fournisseur> addProduitFournit(Long idP, Long idF) {
		Produit produit = produitRpository.findById(idP).orElse(null);
		Fournisseur fournisseur = fournisseurRepository.findById(idF).orElse(null);
		assert produit != null;
		produit.getFournisseur().add(fournisseur);
		produitRpository.save(produit);
		return produit.getFournisseur();
	}

	@Override
	public Page<Fournisseur> getFournisseursPagedAndSorted(int offset, int pageSize, String field) {
		return fournisseurRepository.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
	}

	@Override
	public Page<Fournisseur> getFournisseursPaged(Pageable pageable) {
		return fournisseurRepository.findAll(pageable);
	}
}
