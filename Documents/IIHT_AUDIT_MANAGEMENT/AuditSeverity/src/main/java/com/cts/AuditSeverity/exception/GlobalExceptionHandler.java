package com.cts.AuditSeverity.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.AuditSeverity.fiegnclient.CustomErrorResponse;

import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class handles every exception occuring in this module
 *          
 *
 */
@Slf4j
@RestControllerAdvice
@Generated
public class GlobalExceptionHandler {
	/**
	 * 
	 * @param ex
	 * @return ResponseEntity<CustomErrorResponse>
	 * 
	 * This method is to Handle Exception when Date is not properly formated
	 */
	@Autowired
	Environment environment;
	
	@ExceptionHandler(FeignProxyException.class)
	public ResponseEntity<CustomErrorResponse> handelFeignProxyException(FeignProxyException ex) {
		log.info(environment.getProperty("string.start"));
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason(environment.getProperty("feign.null"));
		log.info(environment.getProperty("string.end"));
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InputsNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handelInputsException(InputsNotFoundException ex) {
		log.info(environment.getProperty("string.start"));
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason(environment.getProperty("field.exp"));
		log.info(environment.getProperty("string.end"));
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
