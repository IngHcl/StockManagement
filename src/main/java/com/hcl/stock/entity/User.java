/**
 * @author User1
 * @name User.java
 * @date Sep 25, 2019
 */
package com.hcl.stock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String password;
	private String userEmail;
	private Long mobileNo;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @param userName
	 * @param password
	 * @param userEmail
	 * @param mobileNo
	 */
	public User(String userName, String password, String userEmail, Long mobileNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
		this.mobileNo = mobileNo;
	}

	public User() {
		super();
	}

}
