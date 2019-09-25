package com.hcl.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.stock.dto.MyStockResponseDTO;
import com.hcl.stock.entity.PurchaseStock;
import com.hcl.stock.entity.Stock;
import com.hcl.stock.entity.User;
import com.hcl.stock.repository.PurchaseStockRepository;
import com.hcl.stock.repository.StockRepository;
import com.hcl.stock.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MyStockServiceImplTest {

	@Mock
	PurchaseStockRepository purchaseStockRepository;
	@Mock
	StockRepository stockRepository;
	@Mock
	UserRepository userRepository;
	@InjectMocks
	MyStockServiceImpl myStockService;

	List<PurchaseStock> purchaseStockList = new ArrayList<>();
	PurchaseStock purchaseStock1 = new PurchaseStock();
	PurchaseStock purchaseStock2 = new PurchaseStock();
	Stock stock = new Stock();
	User user = new User();

	@Before
	public void executeForEach() {

		purchaseStock1.setBrokerageAmount(50.0);
		purchaseStock1.setPurchasePrice(300.0);
		purchaseStock1.setPurchaseStockId(101);
		purchaseStock1.setPurchsedDate(LocalDate.of(2019, 9, 25));
		purchaseStock1.setStockId(1);
		purchaseStock1.setStockQuantity(5);
		purchaseStock1.setUserId(1);

		purchaseStock2.setBrokerageAmount(50.0);
		purchaseStock2.setPurchasePrice(250.0);
		purchaseStock2.setPurchaseStockId(102);
		purchaseStock2.setPurchsedDate(LocalDate.of(2019, 9, 24));
		purchaseStock2.setStockId(2);
		purchaseStock2.setStockQuantity(5);
		purchaseStock2.setUserId(1);

		purchaseStockList.add(purchaseStock1);
		purchaseStockList.add(purchaseStock1);

		stock.setStockName("AAPL");
		stock.setStockDescription("AAPL Stock");
		stock.setStockPrice(300.0);
		stock.setStockQuantity(5);
		stock.setStockId(1);

		user.setMobileNo(8867124205L);
		user.setPassword("shreyanair");
		user.setUserEmail("shreya.nair@hcl.com");
		user.setUserId(1);
		user.setUserName("Shreya Nair");

	}

	@Test
	public void getMyStock() {
		Mockito.when(purchaseStockRepository.findAllByUserId(Mockito.anyInt())).thenReturn(purchaseStockList);
		assertEquals(2, purchaseStockList.size());
		assertFalse(purchaseStockList.isEmpty());
	}

	@Test
	public void getStockName() {
		Mockito.when(stockRepository.findByStockId(Mockito.anyInt())).thenReturn(stock);
		assertEquals("AAPL", stock.getStockName());
	}

	@Test
	public void getUser() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		assertNotNull(user);
		assertEquals(1, user.getUserId().intValue());
	}

	@Test
	public void displayStock() {


		Mockito.when(stockRepository.findByStockId(Mockito.anyInt())).thenReturn(stock);
		Mockito.when(purchaseStockRepository.findAllByUserId(Mockito.anyInt())).thenReturn(purchaseStockList);

		List<MyStockResponseDTO> actual = myStockService.displayStock(user);
		Assert.assertEquals(purchaseStockList.size(), actual.size());


	}
}
