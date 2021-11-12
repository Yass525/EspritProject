package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Fournisseur;
import com.example.demo.repositories.FournisseurRepository;
@Service
public class FournisseurServiceImpl implements IFournisseur {
	@Autowired
	private FournisseurRepository fournisseurRepository;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		// TODO Auto-generated method stub
		List<Fournisseur> fournisseur= fournisseurRepository.findAll();
		return fournisseur;
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur fou) {
		// TODO Auto-generated method stub
		fournisseurRepository.save(fou);
		return fou;
	}

	@Override
	public void deleteFournisseur(Long id) {
		// TODO Auto-generated method stub
		fournisseurRepository.deleteById(id);
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur FF) {
		// TODO Auto-generated method stub
		fournisseurRepository.save(FF);
		return FF;
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		// TODO Auto-generated method stub
		Fournisseur fournisseur=fournisseurRepository.findById(id).orElse(null);
		return fournisseur;
	}

}
