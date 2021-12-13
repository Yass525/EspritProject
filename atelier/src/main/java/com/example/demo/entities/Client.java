package com.example.demo.entities;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Client implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public long IdClient;
	public String Nom;
	public String Prenom;
	@Temporal(TemporalType.DATE)
	public Date dateNaissance ;
	public String eMail;
	public String Password;
	@Enumerated(EnumType.STRING)
	public CategorieClient CategorieClient;
	@Enumerated(EnumType.STRING)
	public Profession profession;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture>Facture ;

}
