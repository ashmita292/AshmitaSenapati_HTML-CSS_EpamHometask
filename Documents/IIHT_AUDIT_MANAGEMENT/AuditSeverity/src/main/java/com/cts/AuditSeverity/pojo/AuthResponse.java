package com.cts.AuditSeverity.pojo;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is used for validation of token
 *
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class AuthResponse {
	/**
	 * Stores UserId of userlogin
	 */
	private String uid;
	/**
	 * Stores if a token is valid or not
	 */
	private boolean isValid;
	
	

}
