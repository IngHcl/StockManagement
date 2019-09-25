package com.hcl.stock.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto {

	private String message;

	private Integer statusCode;

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

	/**
	 * @param message
	 * @param statusCode
	 */
	public ResponseDto(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}

}
