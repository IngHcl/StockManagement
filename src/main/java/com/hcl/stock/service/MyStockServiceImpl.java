package com.hcl.stock.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.stock.dto.MyStockResponseDTO;
import com.hcl.stock.entity.PurchaseStock;
import com.hcl.stock.entity.Stock;
import com.hcl.stock.entity.User;
import com.hcl.stock.repository.PurchaseStockRepository;
import com.hcl.stock.repository.StockRepository;
import com.hcl.stock.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyStockServiceImpl implements MyStockService{

	@Autowired
	PurchaseStockRepository purchaseStockRepository;
	@Autowired 
	StockRepository stockRepository;
	@Autowired
	UserRepository userRepository;
	
	/**
	* The method getMyStock is used to fetch all stocks purchased by a user.
	* @author  Shreya Nair
	* @since   2019-09-25
	* @param   userId
	* @return  list of purchased stocks by a particular user
	*/
	@Override
	public List<PurchaseStock> getMyStock(Integer userId) {
	List<PurchaseStock> purchaseStock = null;
	purchaseStock =	purchaseStockRepository.findAllByUserId(userId);
	return purchaseStock;
	}
	
	/**
	* The method getStockName is used to fetch a stock by a stock id 
	* and return the stock name
	* @author  Shreya Nair
	* @since   2019-09-25
	* @param   stockId
	* @return  returns stock name
	*/
	@Override
	public String getStockName(Integer stockId) {
		Stock stock = stockRepository.findByStockId(stockId);
		return stock.getStockName();
	}

	/**
	* The method getUser is used to fetch a user by userId
	* @author  Shreya Nair
	* @since   2019-09-25
	* @param   userId
	* @return  returns User if user is registered else returns null
	*/
	@Override
	public User getUser(Integer userId) {
		User user = null;
		if(userId!=null) 
			user = userRepository.findById(userId).orElse(null);
		return user;
	}

	/**
	* The method displayStock is used to display the purchased stocks by a user
	* @author  Shreya Nair
	* @since   2019-09-25
	* @param   User object
	* @return  returns list of purchased stocks in the form of ResponseDTO
	*/
	public List<MyStockResponseDTO> displayStock(User user) {
		
		List<MyStockResponseDTO> viewMyStockResponseDTO = new ArrayList<>();
		List<PurchaseStock> purchaseStock =	getMyStock(user.getUserId());
		for(PurchaseStock purchasedStock:purchaseStock) {
			MyStockResponseDTO myStockResponseDTO = new MyStockResponseDTO();
			String stockName = getStockName(purchasedStock.getStockId());
			myStockResponseDTO.setStockId(purchasedStock.getPurchaseStockId());
			myStockResponseDTO.setStockName(stockName);
			myStockResponseDTO.setStockPrice(purchasedStock.getPurchasePrice());
			myStockResponseDTO.setStockQuantity(purchasedStock.getStockQuantity());
			viewMyStockResponseDTO.add(myStockResponseDTO);
		}
		
		return viewMyStockResponseDTO;
	}

}
