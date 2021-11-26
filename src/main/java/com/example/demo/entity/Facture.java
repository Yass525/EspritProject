package com.example.demo.entity;



import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Facture implements Serialisable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long IdFacture;
	private Float MontantRemise;
	private Float MontantFacture;
	@Temporal(TemporalType.DATE)
	private Date DateFacture;
	private boolean Active;
	@ManyToOne
	Client client;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailsFacture> DetailsFacture ;
	public long getIdFacture() {
		return IdFacture;
	}
	public void setIdFacture(long idFacture) {
		IdFacture = idFacture;
	}
	public Float getMontantRemise() {
		return MontantRemise;
	}
	public void setMontantRemise(Float montantRemise) {
		MontantRemise = montantRemise;
	}
	public Float getMontantFacture() {
		return MontantFacture;
	}
	public void setMontantFacture(Float montantFacture) {
		MontantFacture = montantFacture;
	}
	public Date getDateFacture() {
		return DateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		DateFacture = dateFacture;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	
	public Facture(long idFacture, Float montantRemise, Float montantFacture, Date dateFacture, boolean active,
			Client client) {
		super();
		IdFacture = idFacture;
		MontantRemise = montantRemise;
		MontantFacture = montantFacture;
		DateFacture = dateFacture;
		Active = active;
		this.client = client;
	}
	
	
	

}
