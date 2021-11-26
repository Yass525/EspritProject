package com.example.demo.entity;


import org.springframework.lang.NonNull;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity

public class Rayon implements Serialisable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long IdRayon;
	@NonNull
	private String CodeRayon;
	
	private String LibelleRayon;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> Produit ;

}