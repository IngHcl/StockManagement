package com.hcl.stock.service;

import static com.hcl.stock.util.StockManagementConstants.BROKERAGE_PERCENATGE;
import static com.hcl.stock.util.StockManagementConstants.INDIAN_TIME_ZONE;
import static com.hcl.stock.util.StockManagementConstants.INVALID_STOCK;
import static com.hcl.stock.util.StockManagementConstants.INVALID_UESR;
import static com.hcl.stock.util.StockManagementConstants.STOCK_NOT_AVAILABAL;
import static com.hcl.stock.util.StockManagementConstants.STOCK_PURCHASED_SUCCSESS;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stock.dto.ResponseDto;
import com.hcl.stock.dto.StockBuyInput;
import com.hcl.stock.entity.PurchaseStock;
import com.hcl.stock.entity.Stock;
import com.hcl.stock.exception.StockManagementException;
import com.hcl.stock.repository.PurchaseStockRepository;
import com.hcl.stock.repository.StockRepository;
import com.hcl.stock.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author sairam
 *
 */

@Service
@Slf4j
public class StockBuyServiceImpl implements StockBuyService {

	private static final Logger lOGGER = LoggerFactory.getLogger(StockBuyServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	PurchaseStockRepository purchaseStockRepository;
	@Autowired
	StockRepository stockRepository;

	/**
	 * @apiNote buyStock will use for purchase the stocks
	 * @param stockBuyInput contains stockId, stockPrice, stockQuantity, userId;
	 * @return ResponseDto contains message, statusCode
	 */
	@Override
	public ResponseDto buyStock(StockBuyInput stockBuyInput) {
		lOGGER.info("StockBuyServiceImpl--> buyStock enterd");

		if (!userRepository.findById(stockBuyInput.getUserId()).isPresent())
			throw new StockManagementException(INVALID_UESR);
		Optional<Stock> stock = stockRepository.findById(stockBuyInput.getStockId());
		if (!stock.isPresent())
			throw new StockManagementException(INVALID_STOCK);

		if (stock.get().getStockQuantity() < stockBuyInput.getStockQuantity())
			throw new StockManagementException(STOCK_NOT_AVAILABAL);

		// store the data in purchased stock table
		PurchaseStock purchaseStock = new PurchaseStock();
		BeanUtils.copyProperties(stockBuyInput, purchaseStock);
		purchaseStock.setPurchasePrice(stockBuyInput.getStockPrice());
		purchaseStock.setPurchsedDate(LocalDate.now(ZoneId.of(INDIAN_TIME_ZONE)));
		purchaseStock.setBrokerageAmount(Validations.brockerageClaculation(stockBuyInput.getStockPrice(),
				stockBuyInput.getStockQuantity(), BROKERAGE_PERCENATGE));
		purchaseStockRepository.save(purchaseStock);

		// updates total stocks in stock table
		int stockQuantity = (stock.get().getStockQuantity() - stockBuyInput.getStockQuantity());
		stock.get().setStockQuantity(stockQuantity);
		stockRepository.save(stock.get());

		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(STOCK_PURCHASED_SUCCSESS);
		responseDto.setStatusCode(HttpStatus.CREATED.value());

		lOGGER.info("StockBuyServiceImpl--> buyStock completed");

		return responseDto;

	}

}
