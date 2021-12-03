package com.example.demo.entity;


import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Client implements Serialisable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String eMail;
    private String password;
    @Enumerated(EnumType.STRING)
    private CategoryClient categoryClient;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    private String role;
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	@Ignore
    private Set<Facture> Facture;

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<com.example.demo.entity.Facture> getFacture() {
		return Facture;
	}

	public void setFacture(Set<com.example.demo.entity.Facture> facture) {
		Facture = facture;
	}

	public Client(long idClient, String nom, String prenom, Date dateNaissance, String eMail, String password,
				  CategoryClient categoryClient, Profession profession, String role, boolean enabled, Set<com.example.demo.entity.Facture> facture) {
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.eMail = eMail;
		this.password = password;
		this.categoryClient = categoryClient;
		this.profession = profession;
		this.role = role;
		this.enabled = enabled;
		//Facture = facture;
	}

	@Override
	public String toString() {
		return "Client{" +
				"IdClient=" + idClient +
				", Nom='" + nom + '\'' +
				", Prenom='" + prenom + '\'' +
				", dateNaissance=" + dateNaissance +
				", eMail='" + eMail + '\'' +
				", Password='" + password + '\'' +
				", categoryClient=" + categoryClient +
				", profession=" + profession +
				", role='" + role + '\'' +
				", enabled=" + enabled
				//+ ", Facture=" + Facture
				+
				'}'
				;
	}

	public Client() {
		super();
	}

	public Client(String nom, String password, String role) {
		this.nom = nom;
		this.password = password;
		this.role = role;
	}
}
