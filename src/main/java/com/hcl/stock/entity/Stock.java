/**
 * @author User1
 * @name Stock.java
 * @date Sep 25, 2019
 */
package com.hcl.stock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Entity
@Setter
@Getter
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stockId;
	private String stockName;
	private Double stockPrice;
	private Integer stockQuantity;
	private String stockDescription;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getStockDescription() {
		return stockDescription;
	}

	public void setStockDescription(String stockDescription) {
		this.stockDescription = stockDescription;
	}

	/**
	 * @param stockName
	 * @param stockPrice
	 * @param stockQuantity
	 * @param stockDescription
	 */

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	/**
	 * @param stockId
	 * @param stockName
	 * @param stockPrice
	 * @param stockQuantity
	 * @param stockDescription
	 */
	public Stock(Integer stockId, String stockName, Double stockPrice, Integer stockQuantity, String stockDescription) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.stockQuantity = stockQuantity;
		this.stockDescription = stockDescription;
	}

	public Stock() {
		super();

	}

}
