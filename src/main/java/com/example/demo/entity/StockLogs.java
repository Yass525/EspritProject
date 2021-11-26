package com.example.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class StockLogs implements Serialisable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private long id_stock;
	@Temporal(TemporalType.DATE)
	private Date date;

	private String action;
	private String type;
	private long id_requester;
	private int value;

	public long getId_stock() {
		return id_stock;
	}

	public void setId_stock(long id_stock) {
		this.id_stock = id_stock;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId_requester() {
		return id_requester;
	}

	public void setId_requester(long id_requester) {
		this.id_requester = id_requester;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
