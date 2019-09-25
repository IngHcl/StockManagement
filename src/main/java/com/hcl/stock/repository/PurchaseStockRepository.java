package com.hcl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stock.entity.PurchaseStock;

@Repository
public interface PurchaseStockRepository extends JpaRepository<PurchaseStock, Integer> {

}
