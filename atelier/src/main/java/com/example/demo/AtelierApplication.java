package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DetailProduit;
import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.CategorieProduit;
import com.example.demo.entities.Client;
import com.example.demo.entities.Fournisseur;
import com.example.demo.entities.Produit;
import com.example.demo.entities.Profession;
import com.example.demo.entities.Rayon;
import com.example.demo.entities.Stock;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.IDetailsProduit;
import com.example.demo.service.IFournisseur;
import com.example.demo.service.IProduit;
import com.example.demo.service.IRayon;
import com.example.demo.service.IStock;
import com.example.demo.service.Iclient;
import com.example.demo.service.ProduitService;
import com.example.demo.service.StockService;
import com.example.demo.service.detailProduitService;

//import junit.framework.JUnit4TestAdapter;
@EnableAspectJAutoProxy
@SpringBootApplication
public class AtelierApplication {

	
	//@Autowired
	//ProduitService produitService;
	//ProduitRepository produitrepository;
	//@Autowired
	//RepositoryRestConfiguration restConfiguration;
	//IDetailsProduit DetailProduit;
	//@Autowired
	//Iclient ClientService;
	//private Date dates;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AtelierApplication.class, args);}
		

		public void run(String... args) throws Exception {
			
		}
	
/*@Bean(name="entityManagerFactory")

public LocalSessionFactoryBean sessionFactory() {
LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
return sessionFactory;
}*/
}
	//@Override
	//@Transactional
	//public void run(String... args) throws Exception {
 
		//Iterable<Produit> searchResults = produitService.getProduitByCode
			//	("300:Alimentaire,400:Electromenager,500:Quaincaillerie");
		//searchResults.forEach(produit -> System.out.println(produit.getIdProduit()));	
		
	//}

	//@Override
	//public void run(String... args) throws Exception {
		//restConfiguration.exposeIdsFor(Produit.class);
		
		
		
	
	//@Override
	//public void run(String... args) throws Exception {
	//ProduitService.add(new Produit(12,"1234","lait","ss"));

	//@Override
	//public void run(String... args) throws Exception {
		//List<Client> clients = ClientService.findAll();

	
		
	//System.err.println("/////////////////////////");

	
	
//@Override
	//public void run(String... args) throws Exception {
	//fournisseurService.add(new Fournisseur(1l,"222","6FF"));
	//fournisseurService.add(new Fournisseur(2l,"333","6mm"));
	//fournisseurService.add(new Fournisseur(3l,"444","6KK"));
	//fournisseurService.add(new Fournisseur(4l,"555","6gg"));
	//fournisseurService.delete(1l);
	
	
	 
     //int expected = clients.size();
	
	//dates = new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01");

    //ClientService.add(new Client(1L, "sara", "ayari", dates,"ichraf@esprit.tn","non",CategorieClient.Preium,Profession.Docteur));
    //ClientService.add(new Client(456, "zeineb", "ayari", "octobre","zeineb@esprit.tn","non" ,CategorieClient.Ordinaire,Profession.Commercial));
    //ClientService.add(new Client(789, "sara", "ayari", "novembre","sara@esprit.tn","non" ,CategorieClient.Preium,Profession.Docteur));
	  //@Override
	//public void run(String... args) throws Exception {

		 // detailProduitService.add(new DetailProduit(111212,2021-11-02,2021-11-03,CategorieProduit.Alimentaire));
		  //detailProduitService.add(121212,2021-11-02,2021-11-03,CategorieProduit.Electromenagerm);
		  //detailProduitService.add(55555,2021-11-02,2021-11-03,CategorieProduit.Quincaillerie);
		  //List<DetailProduit> DetailProduit = detailProduitService.findAll(111212);

	// List<Rayon> clients = RayonService.findAll(55);
	 

	//System.err.println("/////////////////////////");
	


