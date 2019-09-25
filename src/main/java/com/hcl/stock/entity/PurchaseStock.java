/**
 * @author User1
 * @name PurchaseStock.java
 * @date Sep 25, 2019
 */
package com.hcl.stock.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author User1
 *
 */
@Entity
public class PurchaseStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer purchaseStockId;
	private Integer userId;
	private Double purchasePrice;
	private Integer stockQuantity;
	private Integer stockId;
	private LocalDate purchsedDate;
	private Double brokerageAmount;
	
	public PurchaseStock(){
		
	}

	public Integer getPurchaseStockId() {
		return purchaseStockId;
	}

	public void setPurchaseStockId(Integer purchaseStockId) {
		this.purchaseStockId = purchaseStockId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public LocalDate getPurchsedDate() {
		return purchsedDate;
	}

	public void setPurchsedDate(LocalDate purchsedDate) {
		this.purchsedDate = purchsedDate;
	}

	public Double getBrokerageAmount() {
		return brokerageAmount;
	}

	public void setBrokerageAmount(Double brokerageAmount) {
		this.brokerageAmount = brokerageAmount;
	}

	/**
	 * @param userId
	 * @param purchasePrice
	 * @param quantity
	 * @param stockId
	 * @param purchsedDate
	 * @param brokerageAmount
	 */
	public PurchaseStock(Integer userId, Double purchasePrice, Integer stockQuantity, Integer stockId,
			LocalDate purchsedDate, Double brokerageAmount) {
		super();
		this.userId = userId;
		this.purchasePrice = purchasePrice;
		this.stockQuantity = stockQuantity;
		this.stockId = stockId;
		this.purchsedDate = purchsedDate;
		this.brokerageAmount = brokerageAmount;
	}

}
