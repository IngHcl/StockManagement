package com.hcl.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Laxman
 * @date 25 SEPT 2019
 *
 */
@Setter
@Getter
public class GlobalQuoteDto {

	@JsonProperty("Global Quote")
	private GlobalStockDetail globalStockDetail;
}