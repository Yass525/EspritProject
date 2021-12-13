package com.example.demo.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Facture implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public long IdFacture;
	public Float MontantRemise;
	public Float MontantFacture;
	@Temporal(TemporalType.DATE)
	public Date DateFacture;
	public boolean Active;
	@ManyToOne
	Client client;
	@ManyToOne
	detailsFacture DetailsFacture;
	

	
	
	

}

