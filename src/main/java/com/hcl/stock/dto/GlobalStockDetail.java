package com.hcl.stock.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Laxman
 * @date 25 SEPT 2019
 *
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GlobalStockDetail {
	
	@JsonProperty("01. symbol")
	private String symbol;

	@JsonProperty("02. open")
	private Double open;

	@JsonProperty("03. high")
	private Double high;

	@JsonProperty("04. low")
	private Double low;

	@JsonProperty("05. price")
	private Double price;

	@JsonProperty("06. volume")
	private Integer volume;

	@JsonProperty("07. latest trading day")
	private LocalDate latestTradingDay;

	@JsonProperty("08. previous close")
	private Double close;

	@JsonProperty("09. change")
	private Double change;

	@JsonProperty("10. change percent")
	private String percent;
}
