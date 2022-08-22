package com.cts.AuditSeverity.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * 
 * This class handles the FeignProxy exception
 *
 */

public class FeignProxyException extends Exception {

	private static final long serialVersionUID = 1L;

	@Autowired
	Environment environment;

	public FeignProxyException() {
		super();

	}

}
