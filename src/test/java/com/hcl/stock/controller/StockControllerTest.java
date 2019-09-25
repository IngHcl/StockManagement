package com.hcl.stock.controller;

import static com.hcl.stock.util.StockManagementConstants.STOCK_PURCHASED_SUCCSESS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.stock.dto.ResponseDto;
import com.hcl.stock.dto.StockBuyInput;
import com.hcl.stock.service.StockBuyService;

@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {

	StockBuyInput stockBuyInput;
	ResponseDto responseDto;

	@InjectMocks
	StockController stockController;
	@Mock
	StockBuyService stockBuyService;

	@Before
	public void setUp() {

		stockBuyInput = new StockBuyInput();
		stockBuyInput.setStockId(1);
		stockBuyInput.setStockPrice(100d);
		stockBuyInput.setStockQuantity(10);
		stockBuyInput.setUserId(1);

		responseDto = new ResponseDto();
		responseDto.setMessage(STOCK_PURCHASED_SUCCSESS);
		responseDto.setStatusCode(HttpStatus.CREATED.value());

	}

	@Test
	public void testBuyStock() {
		Mockito.when(stockBuyService.buyStock(stockBuyInput)).thenReturn(responseDto);
		ResponseEntity<ResponseDto> actual = stockController.buyStock(stockBuyInput);

		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCodeValue());
	}

}
