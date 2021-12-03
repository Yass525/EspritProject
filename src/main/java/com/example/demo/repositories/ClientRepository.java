package com.example.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;

import java.awt.print.Pageable;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

	@Query(value = "SELECT * FROM CLIENT WHERE  E_MAIL = ?1", nativeQuery = true)
	public Client findByEmailAddress(String email);

	@Query(value = "SELECT * FROM CLIENT WHERE  NOM = ?1", nativeQuery = true)
	public Client findByNom(String Nom);

	//Page<Client> findAllByEnabledIsTrue(Pageable pageable);
}
