package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.DetailsFacture;

public interface IDetailFacture {
	List <DetailsFacture>  retrieveAllDetailsFacture();

	DetailsFacture addDetailsFacture(DetailsFacture df);

	void deleteDetailsFacture(Long id);

	DetailsFacture updateDetailsFacture(DetailsFacture DF);

	DetailsFacture retrieveDetailsFacture(Long id);

}
