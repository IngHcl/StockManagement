package com.hcl.stock.service;

import org.springframework.stereotype.Service;

import com.hcl.stock.dto.LoginDTO;
import com.hcl.stock.dto.LoginResponseDTO;

@Service
public interface LoginService {
	
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO);

}
