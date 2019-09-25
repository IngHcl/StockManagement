package com.hcl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stock.dto.ResponseDto;
import com.hcl.stock.dto.StockBuyInput;
import com.hcl.stock.service.StockBuyService;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	StockBuyService stockBuyService;

	@PostMapping("/")
	public ResponseEntity<ResponseDto> buyStock(@RequestBody StockBuyInput stockBuyInput) {
		return ResponseEntity.status(HttpStatus.CREATED).body(stockBuyService.buyStock(stockBuyInput));

	}

}
