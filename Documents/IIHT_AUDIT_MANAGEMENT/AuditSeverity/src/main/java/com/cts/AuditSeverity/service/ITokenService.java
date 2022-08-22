package com.cts.AuditSeverity.service;
/** 
 * 			This interface communicates with Auth microservice to check validity of the token. 
 *          Its an interface to call another MicroService using feign client
 *
 */
public interface ITokenService {
	/**
	 * @param token
	 * @return Boolean
	 */
	Boolean checkTokenValidity(String token);

}
