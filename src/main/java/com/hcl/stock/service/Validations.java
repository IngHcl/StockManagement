package com.hcl.stock.service;

public class Validations {

	public static Double brockerageClaculation(Double stockPrice, Integer stockQuantity,
			Integer brockeragePercenatage) {

		return ((stockPrice * stockQuantity) / brockeragePercenatage);

	}

}
