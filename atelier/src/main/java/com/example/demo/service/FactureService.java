package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Facture;
import com.example.demo.repository.FactureRepository;


@Service
public class FactureService implements IFacture {

	@Autowired
	
	public FactureRepository factureRepository;
	
	@Override
	
	public Facture add(Facture facture){
		
		return factureRepository.save(facture);
	}
		
	
@Override
public void delete(long id) {
    factureRepository.deleteById(id);
}
	
	  @Override
	  public Facture update(Facture facture, Long id) {
	        return null;
	    }
	  @Override
	    public List<Facture> findAll() {
	        return factureRepository.findAll();
	    }


	    @Override
	    public Facture findById(Long id) {
	        return factureRepository.getById(id);
	    }

}