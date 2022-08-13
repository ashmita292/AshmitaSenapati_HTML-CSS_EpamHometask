package com.cognizant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cognizant.exception.FeignProxyException;
import com.cognizant.feignclient.AuthClient;
import com.cognizant.pojo.AuthResponse;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * This class is implementing {@link ITokenService}.
 * The method of this class is used in other classes to validate token received.
 *
 */
@Service
@Slf4j
public class TokenServiceImpl implements ITokenService {

	/**
	 * Interface interacting with Auth microservice
	 */
	@Autowired
	private AuthClient authClient;
	@Autowired
	Environment env;
	
	Logger log= LoggerFactory.getLogger(this.getClass());
	
	/**
	 * @param token
	 * @return boolean this method will check the token validity by communicating
	 *         with auth client.
	 */
	public Boolean checkTokenValidity(String token)  {
		log.info(env.getProperty("string.start"));
    	log.debug(env.getProperty("string.token"), token);

		try {
			log.debug(env.getProperty("valcheck.success"));
			AuthResponse authResponse = authClient.getValidity(token).getBody();
			if(authResponse==null) throw new FeignProxyException();
			
			log.info(env.getProperty("string.end"));
			
			return authResponse.isValid();
		} catch (FeignProxyException fe) {
			
			log.debug(env.getProperty("valcheck.fail"));
			log.error(env.getProperty("feign.proxy.exp"),fe);
			log.info(env.getProperty("string.end"));
			
			return false;
		}catch(FeignException e) {
			log.debug(env.getProperty("valcheck.fail"));
			log.error(env.getProperty("feign.exp"),e);
			log.info(env.getProperty("string.end"));
			
			return false;
		}
		
	}

}
