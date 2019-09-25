package com.hcl.stock.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stock.dto.LoginDTO;
import com.hcl.stock.dto.LoginResponseDTO;
import com.hcl.stock.entity.User;
import com.hcl.stock.exception.StockManagementException;
import com.hcl.stock.repository.UserRepository;

import static com.hcl.stock.util.StockManagementConstants.*;

/**
 * @author User1
 * @name LoginServiceImpl.java
 * @date Sep 25, 2019
 */
@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger lOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	/**
	 * @param LoginDTO
	 * @return LoginResponseDTO
	 * @throws Stock Management Exception
	 * 
	 *               This method contains logic to login into the application and
	 *               also checks whether the entered credentials are correct or
	 *               incorrect
	 * 
	 */
	@Override
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO) {

		lOGGER.info("Inside LoginServiceImpl");
		lOGGER.info("userEmail:{} password:{}", loginDTO.getUserEmail(), loginDTO.getPassword());
		LoginResponseDTO loginResponseDTO = null;
		if (loginDTO.getUserEmail().equals("") || loginDTO.getPassword().equals("")) {
			throw new StockManagementException(EMPTY_CREDENTIALS);
		}

		else {
			Optional<User> userList = userRepository.findByUserEmailAndPassword(loginDTO.getUserEmail(),
					loginDTO.getPassword());
			if (!(userList.isPresent())) {
				throw new StockManagementException(LOGIN_FAILURE);
			} else {
				User user = userList.get();
				loginResponseDTO = new LoginResponseDTO(user.getUserId(), LOGIN_SUCCESS, LOGIN_SUCCESS_CODE,
						user.getUserName());
			}

		}
		return loginResponseDTO;

	}

}
