package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.DetailsFacture;
//	import com.example.demo.entity.Facture;
import com.example.demo.entity.Fournisseur;
import com.example.demo.services.IDetailFacture;
import com.example.demo.services.IFournisseur;
//import com.example.demo.entity.Rayon;
//import com.example.demo.services.IFacture;

//import com.example.demo.entity.Client;
//import com.example.demo.entity.Produit;
//import com.example.demo.entity.Stock;
//import com.example.demo.services.IRayon;
//import com.example.demo.services.IClient;
//import com.example.demo.services.IProduit;
//import com.example.demo.services.IStock;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	@Autowired
	//IFournisseur fournisseurService;
	//IFacture factureService;
	//IProduit produitService;
	//IClient clientService;
	//IStock stockService;
	//IRayon rayonService;
	IDetailFacture detailfactureService;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		detailfactureService.addDetailsFacture(new DetailsFacture (1L,245,67F,5,15));
		
		
		//System.out.println("***************************");
		
		detailfactureService.retrieveAllDetailsFacture().forEach(r->{
			System.out.println(r.toString());
	});
		System.out.println("***************************");
		DetailsFacture det = detailfactureService.retrieveDetailsFacture(1L); 
		System.out.println(det.getIdDetailsFacture());
		System.out.println("***************************");
		//clientService.addClient(new Client(1L,"Besbes","12345tg","Mohamed","Ordinaire","31/08/2000","mohmes@gmd.com","Ingenieur"));
          
	}}
