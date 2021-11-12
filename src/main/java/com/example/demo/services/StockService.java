package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;
import com.example.demo.repositories.StockRepository;
@Service
public class StockService implements IStock {
	@Autowired 
	private StockRepository stockRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		stockRepository.save(s);
		return s;
	}

	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(id);
		
	}

	@Override
	public Stock updateStock(Stock t) {
		// TODO Auto-generated method stub
		return stockRepository.save(t);
	}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		Stock stock=stockRepository.findById(id).orElse(null);
		return stock;
	}

}
