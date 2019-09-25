package com.hcl.stock.service;

import java.util.List;

import com.hcl.stock.dto.MyStockResponseDTO;
import com.hcl.stock.entity.PurchaseStock;
import com.hcl.stock.entity.User;

public interface MyStockService {

	public List<PurchaseStock> getMyStock(Integer userId);

	public String getStockName(Integer stockId);

	public User getUser(Integer userId);
	
	public List<MyStockResponseDTO> displayStock(User user);

}
