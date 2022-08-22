package com.cts.AuditSeverity.pojo;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class Stores the login credentials of a user
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Generated
public class User {
	/**
	 * Stores the userid sent from the request body for getting the token
	 */
	private String userId;
	/**
	 * Stores the passward sent from the request body for getting the token
	 */
	private String password;
		
}
