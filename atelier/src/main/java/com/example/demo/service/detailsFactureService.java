package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.detailsFacture;
import com.example.demo.repository.DetailFactureRepository;

@Service
public class detailsFactureService implements IDetailsFacture {

	 @Autowired
	    private DetailFactureRepository detailFactureRepository;

	    @Override
	    public detailsFacture add(detailsFacture  detailFacture) {
	        return detailFactureRepository.save(detailFacture);
	    }

	    @Override
	    public detailsFacture  update(detailsFacture  detailFacture, Long id) {
	        return null;
	    }

	    @Override
	    public void delete(long id) {
	        detailFactureRepository.deleteById(id);
	    }

	    @Override
	    public List<detailsFacture > findAll() {
	        return detailFactureRepository.findAll();
	    }


	    @Override
	    public detailsFacture  findById(Long id) {
	        return detailFactureRepository.getById(id);
	    }
	}

