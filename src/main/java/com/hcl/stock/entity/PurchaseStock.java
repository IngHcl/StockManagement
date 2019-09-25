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
	private Integer quantity;
	private Integer stockId;
	private LocalDate purchsedDate;
	private Double brokerageAmount;

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public PurchaseStock(Integer userId, Double purchasePrice, Integer quantity, Integer stockId,
			LocalDate purchsedDate, Double brokerageAmount) {
		super();
		this.userId = userId;
		this.purchasePrice = purchasePrice;
		this.quantity = quantity;
		this.stockId = stockId;
		this.purchsedDate = purchsedDate;
		this.brokerageAmount = brokerageAmount;
	}

}
