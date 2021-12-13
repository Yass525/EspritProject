package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Produit;
import com.example.demo.service.ProduitService;
//@CrossOrigin("*")
//@RepositoryRestResource
@Repository


public interface ProduitRepository extends JpaRepository<Produit, Long> {

	@Query("select p from Produit p where p.libelle like %?1 or p.prix_unitaire like %?1 ")
	List<Produit> findAllByLibelle(String Libelle);




	@Query("select p from Produit p where p.prix_unitaire > '200' ")
		List<Produit> findByPrixGreaterThan(String prixLimit);



//	@Query("select p from Produit p where p.prix_unitaire like ?1%")
//	List<Produit> findByAndSort(String prix_unitaire);


//	@CrossOrigin("*")
//	@Query("select p from Produit p where p.libelle like :x ")
//
//	public Page<Produit> chercher(@Param("x")String motCle, Pageable pageable);




//@Query("Select id_produit FROM Produit WHERE code = ?1")
//public Iterable<Produit> findByCode(String code);

//@Query(value = "SELECT * FROM produit WHERE prix_unitaire = :prix_unitaire", nativeQuery = true)
//public Iterable<Produit> findByCostNative(@Param("cout") String prix_unitaire);

//public Iterable<Produit> findByCostLessThan(String prix_unitaire);
	
	//@RestResource(path="/byLibelle")
	//List <Produit> findByLibelleContains(@Param("lib")String Libelle);
	//@RestResource(path="/pagination")
	//Page<Produit> findByLibelleContains(@Param("lib")String Libelle ,Pageable pageable);
	
	   // @Query("Select * from Produit p Stock s where p.stock_id_stock=s.id_stock ")
	   //public Produit findProduitByStock();
	
	   // @Query("select t from Produit t where t.produit.id=?#{principal.id}")
	    //List<Produit> findAll();
	 
	  /* @CrossOrigin("*")
	   public List<Produit>findAll(String Keyword);*/
	     /* @Query ("Select p from Produit where Produit.libelle Like %?1% ")
			public List<Produit>findAll(String Keyword);*/
	
	}

