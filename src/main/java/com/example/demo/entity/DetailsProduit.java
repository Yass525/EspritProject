package com.example.demo.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.core.SerializableString;

@Entity
public class DetailsProduit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idDetailProduit;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModification;
	@Enumerated(EnumType.STRING)
	private Category categorieProduit;
	@OneToOne(mappedBy="detailsproduit")
	private Produit produit;
	public long getIdDetailProduit() {
		return idDetailProduit;
	}
	public void setIdDetailProduit(long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}
	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}
	public Category getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(Category categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

}
