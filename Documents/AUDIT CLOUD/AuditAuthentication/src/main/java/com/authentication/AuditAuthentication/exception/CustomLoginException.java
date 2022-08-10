package com.authentication.AuditAuthentication.exception;

/**
 * This class is used for handling exceptions pertaining to login
 *
 */
public class CustomLoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomLoginException(String message) {
		super(message);
	}

	public CustomLoginException(Throwable cause) {
		super(cause);
	}

	public CustomLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomLoginException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}