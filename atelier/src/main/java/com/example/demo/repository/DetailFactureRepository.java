package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.detailsFacture;
@Repository
public interface DetailFactureRepository extends JpaRepository<detailsFacture,Long>  {

}
