package com.example.demo.repositories;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Stock;

import java.util.List;

@Repository
public interface StockRepository  extends JpaRepository<Stock,Long>{

    @Query(value = "SELECT * FROM stock WHERE libelle_stock LIKE %?1%", nativeQuery = true)
    public List<Stock> findStocksByName(String email);

    @Query(value = "SELECT * FROM stock WHERE qte_stock < qte_min", nativeQuery = true)
    public List<Stock> findLowStocks();

    @Query(value = "SELECT * FROM stock WHERE qte_stock = 0", nativeQuery = true)
    public List<Stock> findEmptyStocks();

}
