package com.hcl.stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.stock.dto.GlobalQuoteDto;
import com.hcl.stock.dto.GlobalStockMarketPrice;
import com.hcl.stock.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Laxman
 * @date 25 SEPT 2019
 * 
 *       This Service class is for getting current market Price of Stock
 */
@Slf4j
@Service
public class GlobalApiServiceImpl implements GlobalApiService {

	@Value("${global.api.url}")
	private String globalApiUrl;

	@Value("${global.queryParam}")
	private String globalQueryParam;

	@Value("${global.api.key}")
	private String globalApiKey;

	@Value("${stock.not.found.exception}")
	private String stockNotFoundException;

	@Autowired
	private StockRepository stockRepository;
	RestTemplate restTemplate =null;
	/**
	 * @param stockName
	 * @return GlobalStockMarketPrice
	 * @date 25 SEPT 2019
	 * 
	 *       This method is to get current market price from third party API call by
	 *       using restTemplate
	 */
	@Override
	public GlobalStockMarketPrice currentMarketPrice(String stockName) {
		
		log.info(" :: currentMarketPrice ----  START --");
		 restTemplate = new RestTemplate();

		GlobalStockMarketPrice globalStockMarketPrice = null;
		log.info(" :: currentMarketPrice ----  Calling third party API --");
		GlobalQuoteDto globalQuoteDto = restTemplate
				.exchange(globalApiUrl + globalQueryParam + stockName + globalApiKey, HttpMethod.GET, null,
						GlobalQuoteDto.class)
				.getBody();

		if (globalQuoteDto.getGlobalStockDetail() == null) {
			log.info(" :: currentMarketPrice ----  checking in Database --");
			Optional<Double> optionalDouble = stockRepository.findPriceByStockName(stockName);
			if (optionalDouble.isPresent()) {
				globalStockMarketPrice = GlobalStockMarketPrice.builder().stockPrice(optionalDouble.get()).build();
			}
		} else {
			globalStockMarketPrice = GlobalStockMarketPrice.builder()
					.stockPrice(globalQuoteDto.getGlobalStockDetail().getPrice()).build();
		}
		log.info(" :: currentMarketPrice ----  END --");
		return globalStockMarketPrice;
	}
}
