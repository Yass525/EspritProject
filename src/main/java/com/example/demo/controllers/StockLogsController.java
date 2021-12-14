package com.example.demo.controllers;

import com.example.demo.entity.Stock;
import com.example.demo.entity.StockLogs;
import com.example.demo.repositories.StockLogsRepository;
import com.example.demo.repositories.StockRepository;
import com.example.demo.services.StockLogsService;
import com.example.demo.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StockLogsController {
    @Autowired
    StockService stockService;
    @Autowired
    StockLogsService stockLogsService;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockLogsRepository stockLogsRepository;



    @GetMapping("/stocklogs/all")
    @ResponseBody
    public List<StockLogs> getStock() {
        List<StockLogs> logs = stockLogsService.retrieveAllStockLogs();
        return logs;
    }


    @GetMapping("/stocklogs/get/{id}")
    @ResponseBody
    public List<StockLogs> getStockById(@PathVariable("id") Long Id) {
        List<StockLogs> logs = stockLogsService.getStockLogsById(Id);
        return logs;
    }

    //type = ["ADMINISTRATOR","INVOICE"]
    @GetMapping("/stocklogs/bytype/{type}")
    @ResponseBody
    public List<StockLogs> getStockById(@PathVariable("type") String type) {
        List<StockLogs> logs = stockLogsRepository.GetByType(type);
        return logs;
    }
    @GetMapping("/stocklogs/count")
    @ResponseBody
    public long getLogSz() {
        List<StockLogs> logs = stockLogsService.retrieveAllStockLogs();
        return logs.size();
    }

}
