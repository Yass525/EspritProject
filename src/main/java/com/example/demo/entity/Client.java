package com.example.demo.entity;


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

@Entity
public class Client implements Serialisable {
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
	public CategoryClient categoryClient;
	@Enumerated(EnumType.STRING)
	public Profession profession;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture>Facture ;
	public long getIdClient() {
		return IdClient;
	}
	public void setIdClient(long idClient) {
		IdClient = idClient;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public CategoryClient getCategoryClient() {
		return categoryClient;
	}
	public void setCategoryClient(CategoryClient categoryClient) {
		this.categoryClient = categoryClient;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(long idClient, String nom, String prenom, Date dateNaissance, String eMail, String password,
			CategoryClient categoryClient, Profession profession) {
		super();
		IdClient = idClient;
		Nom = nom;
		Prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.eMail = eMail;
		Password = password;
		this.categoryClient = categoryClient;
		this.profession = profession;
	}
	
	
	
	
	
	
	

}
