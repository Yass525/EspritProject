package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Stock;
import com.example.demo.services.IStock;

@RestController
public class StockRestController {
@Autowired
	
	IStock StockService; //couplage faible
@GetMapping("/allStock") //methode get

@ResponseBody
public Stock add(@RequestBody Stock s){
	Stock stock =StockService.addStock(s);
	return stock;}

@PostMapping("/getStock")
@ResponseBody
public List<Stock> findAll(){
	
    List<Stock>listStock= StockService.retrieveAllStocks();
    return listStock;

	
}
@DeleteMapping("/remove-stock/{stock-id}")

@ResponseBody

public void delete(@PathVariable("Stock-id") Long id) {

	StockService.deleteStock(id);;

}
@PutMapping("/modify-Stock/{id}")

@ResponseBody

public Stock update( @PathVariable("id")Long id,@RequestBody Stock u) {
	Stock p= StockService.updateStock(u);
	
return u;

}

	

}
