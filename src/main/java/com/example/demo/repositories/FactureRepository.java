package com.example.demo.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Facture;
@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
	
	@Query(value = "SELECT * FROM FACTURE WHERE CLIENT_ID_CLIENT = ?1", nativeQuery = true)
	public List <Facture> findInvoiceByClientId(Long id);
	
//	@Query(value = "SELECT F.ID_FACTURE AS FID, C.ID_CLIENT AS CID FROM FACTURE F INNER JOIN CLIENT C WHERE F.CLIENT_ID_CLIENT = C.ID_CLIENT"
//			+ " GROUP BY C.CATEGORY_CLIENT", nativeQuery = true)
//	public Map<String, Integer>  findInvoiceGroupedByCategorie();
}
