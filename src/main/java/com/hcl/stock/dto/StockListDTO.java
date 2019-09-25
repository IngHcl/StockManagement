/**
 * @author User1
 * @name StockListDTO.java
 * @date Sep 25, 2019
 */
package com.hcl.stock.dto;

/**
 * @author User1
 *
 */
public class StockListDTO {

	private Integer StockId;
	private String stockName;
	private Double stockPrice;
	private Integer stockQuantity;

	public Integer getStockId() {
		return StockId;
	}

	public void setStockId(Integer stockId) {
		StockId = stockId;
	}

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

	/**
	 * @param stockId
	 * @param stockName
	 * @param stockPrice
	 * @param stockQuantity
	 */
	public StockListDTO(Integer stockId, String stockName, Double stockPrice, Integer stockQuantity) {
		super();
		StockId = stockId;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.stockQuantity = stockQuantity;
	}

	public StockListDTO() {
		super();

	}

}
