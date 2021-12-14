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

    @Query(value = "SELECT * FROM stock WHERE qte_stock < qte_min AND qte_stock > 0", nativeQuery = true)
    public List<Stock> findLowStocks();

    @Query(value = "SELECT * FROM stock WHERE qte_stock = 0", nativeQuery = true)
    public List<Stock> findEmptyStocks();

    @Query(value="SELECT * FROM stock ORDER BY id_stock LIMIT 20 OFFSET ?1", nativeQuery = true)
    public List<Stock> getStocksByPage(Integer offset);

    @Query(value="SELECT COUNT(*) FROM stock WHERE qte_stock = 0", nativeQuery = true)
    public long getEmptyCount();

    @Query(value="SELECT COUNT(*) FROM stock WHERE qte_stock < qte_min AND qte_stock > 0", nativeQuery = true)
    public long getLowCount();

    @Query(value="SELECT COUNT(*) FROM stock WHERE qte_stock > qte_min", nativeQuery = true)
    public long getAvgCount();

    @Query(value="SELECT COUNT(*) FROM stock", nativeQuery = true)
    public long getTotalCount();
}
