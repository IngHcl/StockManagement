package com.hcl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stock.dto.EmailDto;
import com.hcl.stock.dto.GlobalStockMarketPrice;
import com.hcl.stock.service.GlobalApiService;
import com.hcl.stock.util.MailService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Laxman
 * @date 25 SEPT 2019
 * 
 *       This Controller class to fetch current market price of STOCK.
 *
 */

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders= {"*","/"},origins= {"*","/"})
public class GlobalApiController {

	@Autowired
	private GlobalApiService globalApiService;

	/**
	 * @param stockName
	 * @return GlobalStockMarketPrice
	 * @date 25 SEPT 2019
	 * 
	 *         This method is to get current market price By using third party API
	 * 
	 */
	@GetMapping("/stocks/{stockName}/price")
	public ResponseEntity<GlobalStockMarketPrice> currentMarketPrice(@PathVariable String stockName) {

		log.info(" :: currentMarketPrice ----- ");
		return new ResponseEntity<>(globalApiService.currentMarketPrice(stockName),
				HttpStatus.OK);
	}

}
