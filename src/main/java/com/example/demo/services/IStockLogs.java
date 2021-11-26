package com.example.demo.services;

import com.example.demo.entity.DetailsProduit;
import com.example.demo.entity.StockLogs;

import java.util.List;


public interface IStockLogs {
	List <StockLogs>  retrieveAllStockLogs();

	List <StockLogs> getStockLogsById(Long id);

	void deleteStockLog(Long id);

	StockLogs updateStockLogs(StockLogs arg);

	void addStockLog(StockLogs arg,String type , Long id);



}
