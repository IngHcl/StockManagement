package com.hcl.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.stock.dto.StockListDTO;

@Service
public interface StockListService {
	
	public List<StockListDTO> getStocks();

}
