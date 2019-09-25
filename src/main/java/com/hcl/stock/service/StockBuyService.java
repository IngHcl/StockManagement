package com.hcl.stock.service;

import com.hcl.stock.dto.ResponseDto;
import com.hcl.stock.dto.StockBuyInput;

public interface StockBuyService {
	
	public ResponseDto buyStock(StockBuyInput stockBuyInput);

}
