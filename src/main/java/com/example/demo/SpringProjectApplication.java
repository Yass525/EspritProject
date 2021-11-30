package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.CategoryClient;
import com.example.demo.entity.Client;
import com.example.demo.entity.DetailsFacture;
//	import com.example.demo.entity.Facture;
import com.example.demo.entity.Fournisseur;
import com.example.demo.entity.Profession;
import com.example.demo.services.IClient;
import com.example.demo.services.IDetailFacture;
import com.example.demo.services.IFournisseur;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import com.example.demo.entity.Rayon;
//import com.example.demo.services.IFacture;

//import com.example.demo.entity.Client;
//import com.example.demo.entity.Produit;
//import com.example.demo.entity.Stock;
//import com.example.demo.services.IRayon;
//import com.example.demo.services.IClient;
//import com.example.demo.services.IProduit;
//import com.example.demo.services.IStock;
@EnableSwagger2
@SpringBootApplication

public class SpringProjectApplication implements CommandLineRunner {
    @Autowired
    //IFournisseur fournisseurService;
    //IFacture factureService;
    //IProduit produitService;
    IClient clientService;
    private Date dates;
    //IStock stockService;
    //IRayon rayonService;
    //IDetailFacture detailfactureService;


    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        //detailfactureService.addDetailsFacture(new DetailsFacture (1L,245,67F,5,15));
        dates = new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01");
        System.out.println(org.hibernate.Version.getVersionString());
        System.out.println("eeeeeeeeeeeeeee");
        //clientService.addClient(new Client (1L,"yass2","tr",dates,"asma@yahoo.fr","ghgjh",CategoryClient.Fidele,Profession.Cadre, null));

        //System.out.println("***************************");

        //detailfactureService.retrieveAllDetailsFacture().forEach(r->{
        //System.out.println(r.toString());
        //});
        //System.out.println("***************************");
        //DetailsFacture det = detailfactureService.retrieveDetailsFacture(1L);
        //System.out.println(det.getIdDetailsFacture());
        //System.out.println("***************************");

//		clientService.retrieveAllClients().forEach(r->{
        //System.out.println(r.toString());
        //});
		/*System.out.println("***************************");
		Client cl = clientService.retrieveClient(1L); 
		System.out.println(cl.getNom());
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateToString = df.format(cl.getDateNaissance());
		
		System.out.println(dateToString);
		System.out.println("***************************");  */
    }
}
