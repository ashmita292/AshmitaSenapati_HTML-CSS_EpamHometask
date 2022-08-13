package com.cognizant.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * This model class is used for validation of token 
 * for authorization 
 *
 */
//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class AuthResponse {
	/**
	 * Variable uId is used to store the uId for user login
	 * credentials. The data type is String.
	 */
	private String uid;
	/**
	 * Variable isValid is used to store whether the token is valid
	 * or not. The data type is boolean.
	 */
	private boolean isValid;
	
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AuthResponse(String uid, boolean isValid) {
		super();
		this.uid = uid;
		this.isValid = isValid;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "AuthResponse [uid=" + uid + ", isValid=" + isValid + "]";
	}
	

}
