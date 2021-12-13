package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Rayon;

public interface IRayon {

	Rayon add(Rayon rayon);
	void delete(Rayon rayon);
	Rayon update(Rayon rayon);
	Rayon findById(long id);
	List<Rayon> findAll();
//	List<Rayon> SortByLibelle(String libelle_rayon, Sort sort);
    //List<Rayon> findByNombre(String Categorie);
	Boolean findByNombre(String Categorie);

	List<Rayon> findAllOrderByCategorieAsc();
}
