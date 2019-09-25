package com.hcl.stock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Laxman
 * @date 25 SEPT 2019
 *
 */
@Setter
@Getter
@Builder
public class GlobalStockMarketPrice {

	private Double stockPrice;
}
