package com.cognizant.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * This POJO class is used to handle user details entered from UI by User
 */
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class UserCredentials {
	/**
	 * This field will contain the userid
	 */
	private String userId;
	/**
	 * This field will contain the password
	 */
	private String password;
	public UserCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCredentials(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserCredentials [userId=" + userId + ", password=" + password + "]";
	}
	
	
}
