package com.hcl.stock.service;

import com.hcl.stock.dto.GlobalStockMarketPrice;

public interface GlobalApiService {

	GlobalStockMarketPrice currentMarketPrice(String stockName);

}
