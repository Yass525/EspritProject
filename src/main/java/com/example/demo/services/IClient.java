package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;

public interface IClient {
	List<Client> retrieveAllClients();

    Client  addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client l);

	Client retrieveClient(Long id);
	public Facture findInvoiceById(Long id);
	List<Facture>fetchByIdWithClientWithInvoiceLine(Long id);

	void saveFacture(Facture facture);

}
