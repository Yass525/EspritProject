package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Facture;
import com.example.demo.repositories.FactureRepository;

@Service
public class FactureServiceImpl implements IFacture {
	@Autowired
	private FactureRepository factureRepository;

	@Override
	public List<Facture> retrieveAllFactures() {
		// TODO Auto-generated method stub
		List<Facture> facture=factureRepository.findAll();
		return facture;
	}

	@Override
	public Facture addProduit(Facture F) {
		// TODO Auto-generated method stub
		factureRepository.save(F);
		return F;
	}

	@Override
	public void deleteFacture(Long id) {
		// TODO Auto-generated method stub
		factureRepository.deleteById(id);
		
	}

	@Override
	public Facture updateFacture(Facture f) {
		// TODO Auto-generated method stub
		factureRepository.save(f);
		return f;
	}

	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
	Facture facture=factureRepository.findById(id).orElse(null);
		return facture;
	}

}
