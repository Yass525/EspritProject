package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;

public interface IFacture{

	Facture add(Facture facture);
	 Facture update(Facture facture, Long id);
	    void delete(long id);
	    List<Facture> findAll();
	    Facture findById(Long id);
}
