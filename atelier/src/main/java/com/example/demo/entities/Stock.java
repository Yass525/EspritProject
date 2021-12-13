package com.example.demo.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Stock implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public long IdStock;
	public int QteStock;
	public int QteMin;
	public String LibelleStock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> Produit ;
	
	

}

