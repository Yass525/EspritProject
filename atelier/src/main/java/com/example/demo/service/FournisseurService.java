package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Fournisseur;
import com.example.demo.entities.Produit;
import com.example.demo.repository.FournisseurRepository;
import com.example.demo.repository.ProduitRepository;

@Service
public class FournisseurService implements IFournisseur {

	@Autowired
	
	private FournisseurRepository fournisseurRepository;
	
	@Override
	public Fournisseur add(Fournisseur fournisseur){
		return fournisseurRepository.save(fournisseur);
		
	}
	@Override
	public Fournisseur update(Fournisseur fournisseur, Long id){
		
		return fournisseurRepository.save(fournisseur);
	}
	@Override
	public void delete(long id){
		fournisseurRepository.deleteById(id);	
	}
	
	 @Override
	    public Fournisseur findById(Long id) {
	        return fournisseurRepository.getById(id);
	    }
	@Override
	
	public List<Fournisseur> findAll(){
		
		return fournisseurRepository.findAll();
	}

}
