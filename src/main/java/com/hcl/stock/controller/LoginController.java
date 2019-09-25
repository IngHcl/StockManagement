package com.hcl.stock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stock.dto.LoginDTO;
import com.hcl.stock.dto.LoginResponseDTO;
import com.hcl.stock.service.LoginService;
/**
 * @author User1
 * @name LoginController.java
 * @date Sep 25, 2019
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class LoginController {

	private static final Logger lOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> getUser(@RequestBody LoginDTO loginDTO) {

		lOGGER.info("Inside LoginController class getUser()");

		return new ResponseEntity<>(loginService.getUserDetails(loginDTO), HttpStatus.OK);

	}

}
