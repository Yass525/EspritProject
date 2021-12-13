package com.example.demo.entity;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.example.demo.entity.DetailsFacture;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {
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
	
	
	
	
	
	
	//public Double getMontantFacture() {
		//Double total = 0.0;
		//for(DetailsFacture details : DetailsFacture) {
			//total+= details.calculatePrice();
	//	}
		//return total;
	//}
	
	

}
