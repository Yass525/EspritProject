package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.DetailProduit;


public interface IDetailsProduit {


	DetailProduit add(DetailProduit detailProduit);
	void delete(long id);
	DetailProduit update(DetailProduit detailProduit,long id);
	DetailProduit findById(Long id);
	List<DetailProduit>findAll();
}
