package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stock implements Serialisable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public long IdStock;
	public int QteStock;
	public int QteMin;
	public String LibelleStock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> Produit ;
	public long getIdStock() {
		return IdStock;
	}
	public void setIdStock(long idStock) {
		IdStock = idStock;
	}
	public int getQteStock() {
		return QteStock;
	}
	public void setQteStock(int qteStock) {
		QteStock = qteStock;
	}
	public int getQteMin() {
		return QteMin;
	}
	public void setQteMin(int qteMin) {
		QteMin = qteMin;
	}
	public String getLibelleStock() {
		return LibelleStock;
	}
	public void setLibelleStock(String libelleStock) {
		LibelleStock = libelleStock;
	}
	public Stock(long idStock, int qteStock, int qteMin, String libelleStock) {
		super();
		IdStock = idStock;
		QteStock = qteStock;
		QteMin = qteMin;
		LibelleStock = libelleStock;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
