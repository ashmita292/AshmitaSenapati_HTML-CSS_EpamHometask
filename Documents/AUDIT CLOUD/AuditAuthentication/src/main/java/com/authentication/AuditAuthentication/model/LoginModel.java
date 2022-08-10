package com.authentication.AuditAuthentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class used to authenticate tokens
 */
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class LoginModel {
	String username;
	String token;
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginModel(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
