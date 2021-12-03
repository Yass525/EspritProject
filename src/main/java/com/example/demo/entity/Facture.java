package com.example.demo.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
public class Facture implements Serialisable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long IdFacture;
	private Float MontantRemise;
	private Float MontantFacture;
	@Temporal(TemporalType.DATE)
	private Date DateFacture;
	private boolean Active;
	@ManyToOne
	@JoinColumn(name = "client_id_client", insertable = false, updatable = false)
	@Ignore
	private Client client;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailsFacture> DetailsFacture;

	private long client_id_client ;

	public long getClient_id_client() {
		return client_id_client;
	}

	public void setClient_id_client(long client_id_client) {
		this.client_id_client = client_id_client;
	}

	private Client getClient() {
		return client;
	}
//	public String getClient() {
//		return client.getIdClient()+""+client_id_client;
//	}

	private void setClient(Client client) {
		this.client = client;
	}

	public long getIdFacture() {
		return IdFacture;
	}

	public void setIdFacture(long idFacture) {
		IdFacture = idFacture;
	}

	public Float getMontantRemise() {
		return MontantRemise;
	}

	public void setMontantRemise(Float montantRemise) {
		MontantRemise = montantRemise;
	}

	public Float getMontantFacture() {
		return MontantFacture;
	}

	public void setMontantFacture(Float montantFacture) {
		MontantFacture = montantFacture;
	}

	public Date getDateFacture() {
		return DateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		DateFacture = dateFacture;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public Facture(long idFacture, Float montantRemise, Float montantFacture, Date dateFacture, boolean active) {

		IdFacture = idFacture;
		MontantRemise = montantRemise;
		MontantFacture = montantFacture;
		DateFacture = dateFacture;


	}


	

}
