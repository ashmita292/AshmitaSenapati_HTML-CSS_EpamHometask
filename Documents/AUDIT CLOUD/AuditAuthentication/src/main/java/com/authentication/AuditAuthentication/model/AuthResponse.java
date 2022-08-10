package com.authentication.AuditAuthentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class AuthResponse {

	private String uid;
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


}
