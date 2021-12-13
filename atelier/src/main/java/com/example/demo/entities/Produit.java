package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor


public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idProduit;
	private String code;
	private String libelle;
	public Produit(long idProduit) {
		super();
		this.idProduit = idProduit;
	}
	private String prix_unitaire;
	@Enumerated(EnumType.STRING)
	public CategorieProduit categorieProduit;
	
	@ManyToOne
	@JoinColumn(name="id_rayon")
    private Rayon rayon;
	@ManyToOne
	Stock stock;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> Fournisseur;
	@OneToOne
	private DetailProduit Detailproduit;
	@OneToMany(cascade = CascadeType.ALL , mappedBy="produit")
	private Set<detailsFacture> detailsFacture;
	
	
}

