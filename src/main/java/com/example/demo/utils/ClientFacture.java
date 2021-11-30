package com.example.demo.utils;

import com.example.demo.entity.CategoryClient;
import com.example.demo.entity.Profession;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Value;

@Value
public class ClientFacture {

     long id_facture;
     long id_client;
     long FactureCount;
     @Enumerated(EnumType.STRING)
     CategoryClient CATEGORIE_CLIENT;

}

