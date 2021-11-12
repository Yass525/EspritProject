package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon,Long> {

}
