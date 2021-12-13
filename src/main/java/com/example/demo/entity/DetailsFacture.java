package com.example.demo.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class DetailsFacture {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private  long IdDetailsFacture;
	private Integer Qte;
	private float PrixTotal;
	private Integer PourcentageRemise;
	private Integer MontantRemise;
	
	
	@ManyToOne
	 Produit produit;
	@ManyToOne
	Facture facture;
	public Double calculatePrice() {
		return Qte.doubleValue() * produit.getPrix_unitaire();
	}


	
	
	
	

}
