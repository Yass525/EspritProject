package com.example.demo.paging.userPaging;

import com.example.demo.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientPaged")
public class ClientPageEndPoint {

    private final ClientPageService clientPageService;

    public ClientPageEndPoint(ClientPageService clientPageService) {
        this.clientPageService = clientPageService;
    }

    @GetMapping
    public ResponseEntity<Page<Client>> getClients(ClientPage employeePage,
                                                   ClientSearchCriteria employeeSearchCriteria){
        return new ResponseEntity<>(clientPageService.getClients(employeePage, employeeSearchCriteria),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> addEmployee(@RequestBody Client employee){
        return new ResponseEntity<>(clientPageService.addEmployee(employee), HttpStatus.OK);
    }
}
