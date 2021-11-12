package com.example.demo.entity;

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
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Float getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(Float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	
	public Produit(long idProduit, String code, String libelle, Float prix_unitaire) {
		super();
		this.idProduit = idProduit;
		this.code = code;
		this.libelle = libelle;
		this.prix_unitaire = prix_unitaire;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", code=" + code + ", libelle=" + libelle + ", prix_unitaire="
				+ prix_unitaire + "]";
	}
	
}
