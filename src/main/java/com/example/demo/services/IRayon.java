package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Rayon;



public interface IRayon {
	List<Rayon> retrieveAllRayon();

    Rayon  addRayon(Rayon R);

	void deleteRayon(Long id);

	Rayon updateRayon(Rayon r);

	Rayon retrieveRayon(Long id);

}
