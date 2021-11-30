package com.example.demo.repositories;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Client;
import com.example.demo.utils.ClientFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Facture;
@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
	
	@Query(value = "SELECT * FROM FACTURE WHERE CLIENT_ID_CLIENT = ?1", nativeQuery = true)
	public List <Facture> findInvoiceByClientId(Long id);
	
//	@Query(value = "SELECT new com.example.demo.utils.ClientFacture(F.ID_FACTURE, C.ID_CLIENT,C.CATEGORY_CLIENT) FROM FACTURE F INNER JOIN CLIENT C WHERE F.CLIENT_ID_CLIENT = C.ID_CLIENT"
//			+ " GROUP BY C.CATEGORY_CLIENT", nativeQuery = true)
	@Query(value = "SELECT C.ID_CLIENT,C.CATEGORY_CLIENT FROM CLIENT C GROUP BY C.CATEGORY_CLIENT", nativeQuery = true)
	public List<Client>  findInvoiceGroupedByCategorie();
}
