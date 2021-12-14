package com.example.demo.repositories;

import com.example.demo.entity.Stock;
import com.example.demo.entity.StockLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockLogsRepository extends JpaRepository<StockLogs,Long>{

    @Query(value = "SELECT * FROM stock_logs WHERE id_stock = ?1", nativeQuery = true)
    public List<StockLogs> findLogs(Long id);

    @Query(value = "DELETE FROM stock_logs WHERE id_stock = ?1", nativeQuery = true)
    public List<StockLogs> delete(Long id);

    @Query(value = "SELECT * FROM stock_logs WHERE action = ?1", nativeQuery = true)
    public List<StockLogs> GetByType(String t);
}
