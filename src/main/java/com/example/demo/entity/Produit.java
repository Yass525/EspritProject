package com.example.demo.entity;

import lombok.*;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit implements Serialisable {
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
