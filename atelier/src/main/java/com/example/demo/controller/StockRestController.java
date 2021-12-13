package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Stock;

import com.example.demo.service.IStock;


@RestController

public class StockRestController {
	
	@Autowired
	
	IStock StockService; //couplage faible
	//http://localhost:8088/SpringMVC/servlet/add_produit
	@GetMapping("/allStock") //methode get

	@ResponseBody
	public Stock add(@RequestBody Stock p){
		Stock stock =StockService.add(p);
		return stock;}
    
	@PostMapping("/getStock")
	@ResponseBody
	public List<Stock> findAll(){
		
	    List<Stock>listStock= StockService.findAll();
	    return listStock;
	
		
	}
    @DeleteMapping("/remove-stock/{stock-id}")

	@ResponseBody

	public void delete(@PathVariable("Stock-id") Long id) {

    	StockService.delete(id);

	}
	@PutMapping("/modify-Stock/{id}")

	@ResponseBody

	public Stock update( @PathVariable("id")Long id,@RequestBody Stock u) {
		Stock p= StockService.update(u);
		
	return p;

	}

	}