package com.hcl.stock.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.hcl.stock.dto.LoginDTO;
import com.hcl.stock.dto.LoginResponseDTO;
import com.hcl.stock.service.LoginServiceImpl;
import static com.hcl.stock.util.StockManagementConstants.*;

public class LoginControllerTest {

	@Mock
	LoginServiceImpl loginServiceImpl;

	@InjectMocks
	LoginController loginController;
	LoginDTO loginDTO = null;
	LoginResponseDTO loginResponseDTO = null;

	@Before
	public void setup() {
		loginDTO = new LoginDTO();
		loginDTO.setUserEmail("raja@gmail.com");
		loginDTO.setPassword("raja@123");

		loginResponseDTO = new LoginResponseDTO();
		loginResponseDTO.setUserId(1);
		loginResponseDTO.setUserName("raja@gmail.com");
		loginResponseDTO.setMessage(LOGIN_SUCCESS);
		loginResponseDTO.setStatusCode(LOGIN_SUCCESS_CODE);
	}

	@Test
	public void testGetUser() {
		Mockito.when(loginServiceImpl.getUserDetails(loginDTO)).thenReturn(loginResponseDTO);
		ResponseEntity<LoginResponseDTO> actualValue = loginController.getUser(loginDTO);
		assertEquals(loginResponseDTO.getStatusCode(), actualValue.getBody().getStatusCode());

	}

}
