package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.ToString;

@Entity
@ToString
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public long IdFournissuer;
	public String CodeFournisseur;
	public String LibelleFournisseur;
	public long getIdFournissuer() {
		return IdFournissuer;
	}
	public void setIdFournissuer(long idFournissuer) {
		IdFournissuer = idFournissuer;
	}
	public String getCodeFournisseur() {
		return CodeFournisseur;
	}
	public void setCodeFournisseur(String codeFournisseur) {
		CodeFournisseur = codeFournisseur;
	}
	public String getLibelleFournisseur() {
		return LibelleFournisseur;
	}
	public void setLibelleFournisseur(String libelleFournisseur) {
		LibelleFournisseur = libelleFournisseur;
	}
	public Fournisseur(long idFournissuer, String codeFournisseur, String libelleFournisseur) {
		super();
		IdFournissuer = idFournissuer;
		CodeFournisseur = codeFournisseur;
		LibelleFournisseur = libelleFournisseur;
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
