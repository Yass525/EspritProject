package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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
	public long getIdDetailsFacture() {
		return IdDetailsFacture;
	}
	public void setIdDetailsFacture(long idDetailsFacture) {
		IdDetailsFacture = idDetailsFacture;
	}
	public Integer getQte() {
		return Qte;
	}
	public void setQte(Integer qte) {
		Qte = qte;
	}
	public float getPrixTotal() {
		return PrixTotal;
	}
	public void setPrixTotal(float prixTotal) {
		PrixTotal = prixTotal;
	}
	public Integer getPourcentageRemise() {
		return PourcentageRemise;
	}
	public void setPourcentageRemise(Integer pourcentageRemise) {
		PourcentageRemise = pourcentageRemise;
	}
	public Integer getMontantRemise() {
		return MontantRemise;
	}
	public void setMontantRemise(Integer montantRemise) {
		MontantRemise = montantRemise;
	}
	public DetailsFacture(long idDetailsFacture, Integer qte, float prixTotal, Integer pourcentageRemise,
			Integer montantRemise) {
		super();
		IdDetailsFacture = idDetailsFacture;
		Qte = qte;
		PrixTotal = prixTotal;
		PourcentageRemise = pourcentageRemise;
		MontantRemise = montantRemise;
	}
	public DetailsFacture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
