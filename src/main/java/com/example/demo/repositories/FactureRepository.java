package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Facture;
@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
	@Query (value="SELECT * FROM facture WHERE client_id_client=(select id_client FROM client WHERE id_client=?)",nativeQuery=true)
	public List<Facture>fetchByIdWithClientWithInvoiceLine( Long id);
	//@Query("select i from Facture i join fetch i.client c join fetch i.lines l  where i.id=?1")
	
	//public Facture fetchByIdWithClientWithInvoiceLine(Long id);
   // @Query (value="SELECT C.nom,COUNT(f.montant_facture) FROM facture F, client C WHERE F.client_id_client ="
	//	+ " (C.ID_CLIENT AND C.CATEGORY_CLIENT=?1 AND DATE_FACTURE BETWEEN ?2 AND ?3)",nativeQuery=true)   

}
