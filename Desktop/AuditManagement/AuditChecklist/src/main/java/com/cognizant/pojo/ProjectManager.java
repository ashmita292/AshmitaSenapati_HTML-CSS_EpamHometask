package com.cognizant.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * 
 * This is a POJO class used to store the Authentication detail
 *
 */

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class ProjectManager {

	/**
	 * This field will be used to store the userId 
	 */
	private String userId;
	/**
	 * This field will be used to store the password 
	 */
	private String password;
	/**
	 * This field will be used to store the authToken 
	 *
	 */
	private String authToken;
	public ProjectManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectManager(String userId, String password, String authToken) {
		super();
		this.userId = userId;
		this.password = password;
		this.authToken = authToken;
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
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	@Override
	public String toString() {
		return "ProjectManager [userId=" + userId + ", password=" + password + ", authToken=" + authToken + "]";
	}	
	
}
