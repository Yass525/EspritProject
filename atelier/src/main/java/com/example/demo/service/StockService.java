package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Stock;
import com.example.demo.repository.StockRepository;

@Service
public class StockService implements IStock {

	@Autowired
	StockRepository stockRepository;
	
	@Override
	public Stock add(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public void delete(long id) {
		stockRepository.deleteAll();
	}

	@Override
	public Stock update(Stock stock) {
		
		  return stockRepository.save(stock);
	}

	@Override
	public Stock findById(Long id) {
		return stockRepository.getById(id);
	}

	@Override
	public List<Stock> findAll() {
		return stockRepository.findAll();
	}

}
