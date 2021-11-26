package com.example.demo.services;

import java.util.List;


import com.example.demo.entity.Stock;

public interface IStock  {
	List<Stock> retrieveAllStocks ();
	 Stock  addStock(Stock s);

		void deleteStock(Long id);

		Stock updateStock(Stock t);

		Stock retrieveStock(Long id);

		List<Stock> findStockByLabel(String s);

		List<Stock> findEmptyStocks();


		List<Stock> findLowStocks();



}
