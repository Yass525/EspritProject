package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fournisseur;

import java.util.Map;
import java.util.Set;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {

    @Query("SELECT f FROM Fournisseur f WHERE f.libelleFournisseur= ?1")
    Fournisseur findByLibelleFournisseur(String s);

    @Query("SELECT p.Fournisseur FROM Produit p WHERE p.idProduit = ?1")
    Set<Fournisseur> getFournisseursDuProduit(Long idP);


}
