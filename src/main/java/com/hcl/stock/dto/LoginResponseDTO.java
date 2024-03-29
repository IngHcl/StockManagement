package com.hcl.stock.dto;

import java.io.Serializable;

public class LoginResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String message;
	private Integer statusCode;
	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param userId
	 * @param message
	 * @param statusCode
	 * @param userName
	 */
	public LoginResponseDTO(Integer userId, String message, Integer statusCode, String userName) {
		super();
		this.userId = userId;
		this.message = message;
		this.statusCode = statusCode;
		this.userName = userName;
	}

	public LoginResponseDTO() {
		super();

	}

}
