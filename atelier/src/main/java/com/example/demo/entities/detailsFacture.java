package com.example.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class detailsFacture implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public long IddetailFacture;
	public Integer qte;
	public Float prixTotal;
	public Integer pourcentageRemise;
	public Integer montantRemise;
	@ManyToOne
	Facture facture;
	@ManyToOne
	Produit produit;
	

}
