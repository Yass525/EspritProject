package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DetailsFacture;
@Repository
public interface DetailFactureRepository extends JpaRepository<DetailsFacture, Long> {

}
