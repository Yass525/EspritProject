package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idProduit;
	private String code;
	private String libelle;
	private Float prix_unitaire;
	@ManyToOne
	Rayon rayon;
	@ManyToOne
	Stock stock;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> Fournisseur;
	@OneToOne
	private DetailsProduit detailsproduit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<DetailsFacture> DetailsFacture ;


	
}
