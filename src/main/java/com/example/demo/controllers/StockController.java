package com.example.demo.controllers;

import com.example.demo.entity.Client;
import com.example.demo.entity.Stock;

import com.example.demo.entity.StockLogs;
import com.example.demo.repositories.StockRepository;
import com.example.demo.services.StockLogsService;
import com.example.demo.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StockController {
    @Autowired
    StockService stockService;
    @Autowired
    StockLogsService stockLogsService;
    @Autowired
    private StockRepository stockRepository;




    @GetMapping("/stock/all")
    @ResponseBody
    public List<Stock> getStock() {
        List<Stock> allStock = stockService.retrieveAllStocks();
        return allStock;
    }


    @GetMapping("/stock/get/{id}")
    @ResponseBody
    public Stock getStockById(@PathVariable("id") Long Id) {
        Stock stock = stockService.retrieveStock(Id);
        return stock;
    }
    @GetMapping("/stock/delete/{id}")
    @ResponseBody
    public String deleteStockById(@PathVariable("id") Long Id) {
            return "Stock deleted ";
    }
    @GetMapping("/stock/update/{id}")
    @ResponseBody
    public Stock updateStockById(@RequestBody Stock c,@PathVariable("id") Long Id) {
        Stock s = stockService.retrieveStock(Id);
        StockLogs log = new StockLogs();
        log.setId_stock(Id);
        Date date = new Date();
        log.setDate(date);
        if(s.getQteStock() == c.getQteStock()) return s;
        if(s.getQteStock() > c.getQteStock()){
            log.setAction("WITHDRAW");
            log.setValue(s.getQteStock()-c.getQteStock());
        }else{
            log.setAction("DEPOSIT");
            log.setValue(c.getQteStock()-s.getQteStock());

        }
        stockLogsService.addStockLog(log,"ADMINISTRATOR",(long)1);



        s.setQteStock(c.getQteStock());
        Stock updated = stockService.updateStock(c);
        return updated;
    }
    @GetMapping("/stock/add")
    @ResponseBody
    public void addStockById(@RequestBody Stock c) {
        Stock s = new Stock();
        s.setIdStock(c.getIdStock());
        s.setQteStock(c.getQteStock());
        s.setLibelleStock(c.getLibelleStock());
        s.setQteMin(c.getQteMin());
        stockService.addStock(s);
        StockLogs log = new StockLogs();
        log.setId_stock(s.getIdStock());
        log.setAction("CREATE");
        Date date = new Date();
        log.setDate(date);
        stockLogsService.addStockLog(log,"ADMINISTRATOR",(long)1);
    }

    @GetMapping("/stock/find/{str}")
    @ResponseBody
    public List<Stock> findStockByLabel(@PathVariable("str") String s) {
        List<Stock> x = stockService.findStockByLabel(s);
    return x;
    }
    @GetMapping("/stock/low")
    @ResponseBody
    public List<Stock> findLow() {
        List<Stock> x = stockService.findLowStocks();
        return x;
    }
    @GetMapping("/stock/empty")
    @ResponseBody
    public List<Stock> findEmpty() {
        List<Stock> x = stockService.findEmptyStocks();
        return x;
    }
}
