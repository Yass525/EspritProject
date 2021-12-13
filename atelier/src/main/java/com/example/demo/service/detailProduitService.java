package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DetailProduit;

import com.example.demo.repository.DetailproduitRepository;


@Service
public class detailProduitService implements IDetailsProduit {
	 @Autowired
	    private DetailproduitRepository detailProduitRepository;

	    @Override
	    public DetailProduit add(DetailProduit  detailProduit) {
	        return detailProduitRepository.save(detailProduit);
	    }

	    

	    @Override
	    public void delete(long id) {
	    	detailProduitRepository.deleteById(id);
	    }

	    @Override
	    public List<DetailProduit > findAll() {
	        return detailProduitRepository.findAll();
	    }


	    @Override
	    public DetailProduit findById(Long id) {
	        return detailProduitRepository.getById(id);
	    }

		@Override
		public DetailProduit update(DetailProduit detailProduit, long id) {
			
			return null;
		}
	}

