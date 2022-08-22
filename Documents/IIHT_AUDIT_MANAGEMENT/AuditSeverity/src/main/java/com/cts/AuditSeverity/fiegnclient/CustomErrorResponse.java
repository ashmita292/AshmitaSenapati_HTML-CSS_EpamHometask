package com.cts.AuditSeverity.fiegnclient;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 			This class is used as a response of error handling message.
 *          In the {@link GlobalErrorHandler} class {@link CustomErrorResponse} class 
 *          is used as a return type that will be
 *          shown to the client whenever any kind of exception occurs. 
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class CustomErrorResponse {

	/**
	 * Variable timestamp is used to store time when the exception occurred.
	 */
	private LocalDateTime timestamp;
	/**
	 * Variable status is used to store status which will be set in this variable
	 *  from {@link GlobalErrorHandler} class.
	 */
	private HttpStatus status;
	/**
	 * Variable reason is used to store the reason why the exception occurred.
	 */
	private String reason;
	
	/**
	 * Variable message is used to store message which is retrieved from the constructor of exception class. 
	 */
	private String message;

	
}
