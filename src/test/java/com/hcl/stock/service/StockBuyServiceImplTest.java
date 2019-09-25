package com.hcl.stock.service;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.stock.dto.ResponseDto;
import com.hcl.stock.dto.StockBuyInput;
import com.hcl.stock.entity.PurchaseStock;
import com.hcl.stock.entity.Stock;
import com.hcl.stock.entity.User;
import com.hcl.stock.exception.StockManagementException;
import com.hcl.stock.repository.PurchaseStockRepository;
import com.hcl.stock.repository.StockRepository;
import com.hcl.stock.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class StockBuyServiceImplTest {

	@InjectMocks
	StockBuyServiceImpl stockBuyServiceImpl;
	@Mock
	UserRepository userRepository;
	@Mock
	PurchaseStockRepository purchaseStockRepository;
	@Mock
	StockRepository stockRepository;
	StockBuyInput stockBuyInput;
	PurchaseStock purchaseStock;
	Stock stock;
	User user;

	@Before
	public void setUp() {

		stockBuyInput = new StockBuyInput();
		stockBuyInput.setStockId(1);
		stockBuyInput.setStockPrice(100d);
		stockBuyInput.setStockQuantity(10);
		stockBuyInput.setUserId(1);

		purchaseStock = new PurchaseStock();
		purchaseStock.setBrokerageAmount(100d);
		purchaseStock.setPurchasePrice(100d);
		purchaseStock.setPurchaseStockId(1);
		purchaseStock.setPurchsedDate(LocalDate.now());
		purchaseStock.setStockId(1);
		purchaseStock.setStockQuantity(10);
		purchaseStock.setUserId(1);

		stock = new Stock();
		stock.setStockDescription("description");
		stock.setStockId(1);
		stock.setStockName("HCL");
		stock.setStockPrice(100d);
		stock.setStockQuantity(100);

		user = new User();
		user.setUserId(1);
		user.setPassword("1234");
		user.setUserEmail("sairam4smile@gmail.com");
	}

	@Test
	public void testBuyStock() {

		Mockito.when(userRepository.findById(stockBuyInput.getUserId())).thenReturn(Optional.of(user));
		Mockito.when(stockRepository.findById(stockBuyInput.getStockId())).thenReturn(Optional.of(stock));
		Mockito.when(stockRepository.save(stock)).thenReturn(stock);

		ResponseDto actual = stockBuyServiceImpl.buyStock(stockBuyInput);
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCode().intValue());
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCode().intValue());

	}

	@Test(expected = StockManagementException.class)
	public void testBuyStockWrongUserId() {

		stockBuyServiceImpl.buyStock(stockBuyInput);

	}

	@Test(expected = StockManagementException.class)
	public void testBuyStockWrongStockId() {

		Mockito.when(userRepository.findById(stockBuyInput.getUserId())).thenReturn(Optional.of(user));

		stockBuyServiceImpl.buyStock(stockBuyInput);

	}

	@Test(expected = StockManagementException.class)
	public void testBuyStockMoreStocks() {
		stockBuyInput.setStockQuantity(1000);
		Mockito.when(userRepository.findById(stockBuyInput.getUserId())).thenReturn(Optional.of(user));
		Mockito.when(stockRepository.findById(stockBuyInput.getStockId())).thenReturn(Optional.of(stock));

		stockBuyServiceImpl.buyStock(stockBuyInput);

	}

}
