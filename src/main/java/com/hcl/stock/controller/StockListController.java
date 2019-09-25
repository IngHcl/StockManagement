
package com.hcl.stock.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stock.dto.StockListDTO;
import com.hcl.stock.service.StockListService;

/**
 * @author User1
 * @name StockListController.java
 * @date Sep 25, 2019
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class StockListController {

	private static final Logger lOGGER = LoggerFactory.getLogger(StockListController.class);

	@Autowired
	StockListService stockListService;

	@GetMapping("/stocks")
	public ResponseEntity<List<StockListDTO>> getStocks() {

		lOGGER.info("Inside StockListController class getStocks()");

		return new ResponseEntity<>(stockListService.getStocks(), HttpStatus.OK);

	}

}
