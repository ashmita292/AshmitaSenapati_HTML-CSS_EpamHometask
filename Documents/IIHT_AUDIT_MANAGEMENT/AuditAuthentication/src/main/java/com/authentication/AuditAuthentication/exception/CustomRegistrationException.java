package com.authentication.AuditAuthentication.exception;

/**
 * This class is used for handling exceptions pertaining to registration
 *
 */
public class CustomRegistrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomRegistrationException(String message) {
		super(message);
	}

	public CustomRegistrationException(Throwable cause) {
		super(cause);
	}
}