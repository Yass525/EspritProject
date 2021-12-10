package com.example.demo;

import com.example.demo.entity.Produit;
import com.example.demo.model.Mail;
import com.example.demo.services.IFileStorageService;
import com.example.demo.services.IMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.DetailsFacture;
//	import com.example.demo.entity.Facture;
import com.example.demo.entity.Fournisseur;
import com.example.demo.services.IDetailFacture;
import com.example.demo.services.IFournisseur;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.Arrays;
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
	IFournisseur fournisseurService;

	@Resource
	IFileStorageService storageService;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		storageService.deleteAll();
//		storageService.init();

	}
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:3000"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token",
				"Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
