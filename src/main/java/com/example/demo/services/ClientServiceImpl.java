package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.FactureRepository;

@Service
public class ClientServiceImpl implements IClient {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private FactureRepository  facturerepo;

	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		List<Client> clients = (List<Client>) clientRepository.findAll();
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		clientRepository.save(c);
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client l) {
		// TODO Auto-generated method stub
		return clientRepository.save(l);
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		Client client =clientRepository.findById(id).orElse(null);
		return client;
	}
	@Override
	
	public Facture findInvoiceById(Long id) {
		return facturerepo.findById(id).orElse(null);

}
	@Override
	
	public List <Facture> fetchByIdWithClientWithInvoiceLine(Long id) {
		List <Facture> facture=(List <Facture>)facturerepo.fetchByIdWithClientWithInvoiceLine(id);
		return facture ;
	}
	@Override
	
	public void saveFacture(Facture facture) {
		facturerepo.save(facture);
	}
}
