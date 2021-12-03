package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Produit;
import com.example.demo.entities.Rayon;
import net.bytebuddy.asm.Advice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface IRayon {

	Rayon add(Rayon rayon);
	void delete(Rayon rayon);
	Rayon update(Rayon rayon);
	Rayon findById(long id);
	List<Rayon> findAll();
//	List<Rayon> SortByLibelle(String libelle_rayon, Sort sort);
    List<Rayon>findByNombre(String Ctegorie);


	List<Rayon> findAllOrderByCategorieAsc();
}
