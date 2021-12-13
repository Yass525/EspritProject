package com.example.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.aspectj.lang.annotation.Around;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Stock;
import com.example.demo.services.IStock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTest {
	@Autowired
	IStock iStock;
@Test

public void testaddStock(){
	//n3ayet lelist
	List<Stock> stocks = iStock.retrieveAllStocks();
	//nchouf taille de la liste
	int expected= stocks.size();
	Stock s = new Stock();
	s.setLibelleStock("stock test");
	s.setQteStock(10);
	s.setQteMin(100);
	Stock savedStock= iStock.addStock(s);
	assertEquals(expected+1, iStock.retrieveAllStocks().size());
	assertNotNull(savedStock.getLibelleStock());
	//iStock.deleteStock(savedStock.getIdStock());
	
}


}
