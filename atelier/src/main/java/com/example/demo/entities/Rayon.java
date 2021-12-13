package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Rayon implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
 private long IdRayon;
	@NonNull
	private String CodeRayon;
	@NonNull
	private String LibelleRayon;
	@Enumerated(EnumType.STRING)
	public CategorieRayon CategorieRayon;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	//private List<Produit> Produit ;

	List<Produit> produits = new ArrayList<>();

	public Rayon(long idRayon, String codeRayon, String libelleRayon) {
		super();
		IdRayon = idRayon;
		CodeRayon = codeRayon;
		LibelleRayon = libelleRayon;
	}

	public Rayon() {
		super();
	}
	

}
