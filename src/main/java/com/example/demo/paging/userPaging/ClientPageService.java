package com.example.demo.paging.userPaging;

import com.example.demo.entity.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ClientPageService {

    private final ClientRepository clientRepository;
    private final ClientCriteriaRepo clientCriteriaRepo;

    public ClientPageService(ClientCriteriaRepo clientCriteriaRepo, ClientRepository clientRepository) {
        this.clientCriteriaRepo = clientCriteriaRepo;
        this.clientRepository = clientRepository;
    }

    public Page<Client> getClients(ClientPage employeePage,
                                   ClientSearchCriteria employeeSearchCriteria){
        return clientCriteriaRepo.findAllWithFilters(employeePage, employeeSearchCriteria);
    }

    public Client addEmployee(Client client){
        return clientRepository.save(client);
    }
}
