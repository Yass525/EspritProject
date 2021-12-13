package com.example.demo.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Client implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long IdClient;
	private String Nom;
	private String Prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance ;
	private String eMail;
	private String Password;
	@Enumerated(EnumType.STRING)
	private CategoryClient categoryClient;
	@Enumerated(EnumType.STRING)
	private Profession profession;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture>Facture ;
	
	
	
	
	
	

}
