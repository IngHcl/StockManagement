package com.hcl.stock.service;

import static com.hcl.stock.util.StockManagementConstants.NO_STOCKS_FOUND;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stock.dto.StockListDTO;
import com.hcl.stock.entity.Stock;
import com.hcl.stock.exception.StockManagementException;
import com.hcl.stock.repository.StockRepository;

/**
 * @author User1
 * @name StockListServiceImpl.java
 * @date Sep 25, 2019
 */
@Service
public class StockListServiceImpl implements StockListService {

	private static final Logger lOGGER = LoggerFactory.getLogger(StockListServiceImpl.class);

	@Autowired
	StockRepository stockRepository;

	/**
	 * @return List<StockListDTO>
	 * 
	 *         This method contains logic to get all the available stocks
	 * 
	 */
	@Override
	public List<StockListDTO> getStocks() {

		lOGGER.info("Inside Stock List Service class getStocks()");

		List<StockListDTO> stocksList = new ArrayList<>();
		List<Stock> stocks = stockRepository.findAll();

		if (stocks.isEmpty()) {
			throw new StockManagementException(NO_STOCKS_FOUND);
		} 
		else {
			stocks.forEach(stock -> {
				StockListDTO StockListDTO = new StockListDTO(stock.getStockId(), stock.getStockName(),
						stock.getStockPrice(), stock.getStockQuantity());
				stocksList.add(StockListDTO);
			});
		}

		return stocksList;
	}

}
