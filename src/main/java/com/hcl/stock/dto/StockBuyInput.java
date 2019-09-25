package com.hcl.stock.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockBuyInput {

	private Integer stockId;
	private Double stockPrice;
	private Integer stockQuantity;
	private Integer userId;
}
