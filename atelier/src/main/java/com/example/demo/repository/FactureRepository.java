package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
