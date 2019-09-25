package com.hcl.stock.tests;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hcl.stock.dto.GlobalQuoteDto;
import com.hcl.stock.dto.GlobalStockDetail;
import com.hcl.stock.dto.GlobalStockMarketPrice;
import com.hcl.stock.repository.StockRepository;
import com.hcl.stock.service.GlobalApiServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class GlobalApiServiceTest {

	@Mock
	private StockRepository stockRepository;

	@InjectMocks
	private GlobalApiServiceImpl globalApiServiceImpl;

	@Mock
	private RestTemplate restTemplate;

	Optional<Double> optionalDouble = null;
	GlobalQuoteDto globalQuoteDto = null;
	ResponseEntity<GlobalQuoteDto> responseEntityGlobal = null;

	String globalUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=ACC&apikey=CQA8OG03A7GVM5ZU\\";
	GlobalStockDetail globalStockDetail =null;

	@Before
	public void setUp() {
		optionalDouble = Optional.of(209.8);

		 globalStockDetail = GlobalStockDetail.builder().price(209.8).build();
		
		globalQuoteDto = new GlobalQuoteDto();
		globalQuoteDto.setGlobalStockDetail(globalStockDetail);

		responseEntityGlobal = new ResponseEntity<>(globalQuoteDto, HttpStatus.OK);

	}

	@Test
	public void currentMarketPrice() {
		Mockito.when(restTemplate.exchange(Mockito.anyString(), HttpMethod.GET, null, GlobalQuoteDto.class))
				.thenReturn(responseEntityGlobal);
		Mockito.when(stockRepository.findPriceByStockName("HCLIT")).thenReturn(optionalDouble);
		GlobalStockMarketPrice actualMarketPrice = globalApiServiceImpl.currentMarketPrice("HCLIT");
		assertEquals(optionalDouble.get(), actualMarketPrice.getStockPrice());
	}

}
