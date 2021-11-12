package com.example.demo.entity;

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
	private String CodeRayon;
	
	private String LibelleRayon;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> Produit ;

	public long getIdRayon() {
		return IdRayon;
	}

	public void setIdRayon(long idRayon) {
		IdRayon = idRayon;
	}

	public String getCodeRayon() {
		return CodeRayon;
	}

	public void setCodeRayon(String codeRayon) {
		CodeRayon = codeRayon;
	}

	public String getLibelleRayon() {
		return LibelleRayon;
	}

	public void setLibelleRayon(String libelleRayon) {
		LibelleRayon = libelleRayon;
	}

	public Set<Produit> getProduit() {
		return Produit;
	}

	public void setProduit(Set<Produit> produit) {
		Produit = produit;
	}
	public Rayon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Rayon(long idRayon, String codeRayon, String libelleRayon) {
		super();
		IdRayon = idRayon;
		CodeRayon = codeRayon;
		LibelleRayon = libelleRayon;
	}
	

}
