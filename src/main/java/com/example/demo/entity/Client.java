package com.example.demo.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Client implements Serialisable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdClient;
    private String Nom;
    private String Prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String eMail;
    private String Password;
    @Enumerated(EnumType.STRING)
    private CategoryClient categoryClient;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    private String role;
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Facture> Facture;

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

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
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
		IdClient = idClient;
		Nom = nom;
		Prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.eMail = eMail;
		Password = password;
		this.categoryClient = categoryClient;
		this.profession = profession;
		this.role = role;
		this.enabled = enabled;
		//Facture = facture;
	}

	@Override
	public String toString() {
		return "Client{" +
				"IdClient=" + IdClient +
				", Nom='" + Nom + '\'' +
				", Prenom='" + Prenom + '\'' +
				", dateNaissance=" + dateNaissance +
				", eMail='" + eMail + '\'' +
				", Password='" + Password + '\'' +
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
		Nom = nom;
		Password = password;
		this.role = role;
	}
}
