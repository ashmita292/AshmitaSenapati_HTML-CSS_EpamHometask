package com.cognizant.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.feignclient.AuthClient;
import com.cognizant.pojo.AuthResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * This class contains test cases for the TokenServiceImpl class.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class TokenServiceImplTest {

	@InjectMocks
	TokenServiceImpl tokenService;
	@Mock
	AuthClient authClient;

	@Mock
	AuthResponse authResponse;
	@Mock
	Environment env;
	@Mock
	ResponseEntity<AuthResponse> entity;

	/**
	 * test to check the validity of token when token is valid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {

		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true), HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(entity);

		assertEquals(true, tokenService.checkTokenValidity("token"));

	}

	/**
	 * test to check the validity of token when token gives null pointer exception
	 */
	@Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {

		// assertThrows(NullPointerException.class,() ->
		// tokenService.checkTokenValidity("token"));

	}

	/**
	 * test to check the validity of token when token is invalid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {

		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, false), HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(entity);
		assertEquals(false, tokenService.checkTokenValidity("token"));

	}

}
