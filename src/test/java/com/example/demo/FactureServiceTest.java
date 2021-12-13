package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Facture;
import com.example.demo.entity.Stock;
import com.example.demo.services.IFacture;

@RunWith(SpringRunner.class)
@SpringBootTest


public class FactureServiceTest {
@Autowired
IFacture factureService;
public void testaddStock(){
	//n3ayet lelist
	
	//iStock.deleteStock(savedStock.getIdStock());
}
}
