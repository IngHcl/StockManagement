package com.hcl.stock.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.stock.dto.MyStockResponseDTO;
import com.hcl.stock.entity.User;
import com.hcl.stock.exception.StockManagementException;
import com.hcl.stock.service.MyStockService;

@RestController
@RequestMapping("/users")
public class MyStockController {
	
	@Autowired
	MyStockService purchasedStockService;
	
	/**
	* The method viewMyStock is used to display all stocks purchased by a user.
	*
	* @author  Shreya Nair
	* @since   2019-09-25
	* @param   userId
	* @return  list of purchased stocks by a particular user
	*/
	@GetMapping("/{userId}/stocks")
	public ResponseEntity<List<MyStockResponseDTO>> viewMyStock(@PathVariable("userId") Integer userId) throws StockManagementException {
		User user = purchasedStockService.getUser(userId);
		if(user!=null) {
			List<MyStockResponseDTO> myStockResponseDTO = purchasedStockService.displayStock(user);
			return new ResponseEntity<>(myStockResponseDTO, HttpStatus.OK);
		}else {
			throw new StockManagementException("User is not Registered");
		}
		
	}

}
