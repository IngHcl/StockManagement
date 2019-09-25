package com.hcl.stock.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.stock.controller.GlobalApiController;
import com.hcl.stock.dto.GlobalStockMarketPrice;
import com.hcl.stock.service.GlobalApiService;

@RunWith(MockitoJUnitRunner.class)
public class GlobalApiControllerTest {

	@Mock
	private GlobalApiService globalApiService;
	
	@InjectMocks
	private GlobalApiController globalApiController;
	
	private GlobalStockMarketPrice globalStockMarketPrice = null;
	
	@Before
	public void setUp() {
		globalStockMarketPrice = GlobalStockMarketPrice.builder().stockPrice(209.8).build(); 
	}
	
	@Test
	public void currentMarketPriceTest() {
		Mockito.when(globalApiService.currentMarketPrice("HCLIT")).thenReturn(globalStockMarketPrice);
		ResponseEntity<GlobalStockMarketPrice> actualResponse = globalApiController.currentMarketPrice("HCLIT");
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
	}
}
