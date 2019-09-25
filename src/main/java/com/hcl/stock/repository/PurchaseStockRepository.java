package com.hcl.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stock.entity.PurchaseStock;

@Repository
public interface PurchaseStockRepository extends JpaRepository<PurchaseStock, Integer> {

	public List<PurchaseStock> findAllByUserId(Integer userId);

}
