package com.cts.AuditSeverity.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * Its a simple POJO class to store user details required by feign client
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectManager {

	/**
	 * Stores the UserId
	 */
	private String userId;
	/**
	 * Stores the password
	 */
	private String password;
	/**
	 * Stores the Token
	 *
	 */
	private String authToken;
	
}
