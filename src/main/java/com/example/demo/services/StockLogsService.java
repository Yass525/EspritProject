package com.example.demo.services;

import com.example.demo.entity.Stock;
import com.example.demo.entity.StockLogs;
import com.example.demo.repositories.StockLogsRepository;
import com.example.demo.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockLogsService implements IStockLogs {
	@Autowired 
	private StockLogsRepository stockLogsRepository;

	@Override
	public List<StockLogs> retrieveAllStockLogs() {
		List<StockLogs> logs = (List<StockLogs>) stockLogsRepository.findAll();
		return logs;
	}

	@Override
	public List<StockLogs> getStockLogsById(Long id) {
		List<StockLogs> logs = stockLogsRepository.findLogs(id);
		return logs;
	}

	@Override
	public void deleteStockLog(Long id) {
		stockLogsRepository.delete(id);
	}

	@Override
	public StockLogs updateStockLogs(StockLogs arg) {
		return stockLogsRepository.save(arg);
	}

	@Override
	public void addStockLog(StockLogs arg,String type , Long id){
		arg.setType(type);
		arg.setId_requester(id);
		stockLogsRepository.save(arg);
	}
}
