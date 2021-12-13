package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Produit;
import com.example.demo.service.IRayon;
import com.example.demo.service.RayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Rayon;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface RayonRepository extends JpaRepository<Rayon, Long> {


    @Query(value = "SELECT COUNT(CategorieRayon) FROM Rayon ")

    Boolean findByNombre(String Categorie);

    @Query("FROM Rayon  ORDER BY CategorieRayon ASC")
    List<Rayon> findAllOrderByCategorieAsc();
//
//    @Query(value = "select r from Rayon r where r.CategorieRayon like %?1 ")default
//           List<Rayon> findByCategorie() {
//        return findByCategorie();
//    }

//    @Query(value = "select r from Rayon r where r.CategorieRayon like %?1 ")
//           List<Rayon> findByCategorie(String categorie) {
//
//    }


//    SELECT categorie_rayon,(select count(*) FROM Rayon R WHERE categorie_rayon = 'ALIMENTAIRE') from rayon R
//    @Query("select r from Rayon r where r.LibelleRayon like ?1%")
//    List<Rayon> SortByLibelle(String libelleRayon);

//   @Query(value = "SELECT categorie_rayon , (SELECT COUNT(*) FROM produit P WHERE P.id_produit = R.id_rayon) AS NB_PROD FROM rayon R")

}


