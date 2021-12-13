package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Stock;

public interface IStock {

	Stock add(Stock stock);
	void delete(long id);
	Stock update(Stock stock);
	Stock findById(Long id);
	List<Stock>findAll();
	
}
