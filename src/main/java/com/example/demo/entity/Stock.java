package com.example.demo.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;

@Entity

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
