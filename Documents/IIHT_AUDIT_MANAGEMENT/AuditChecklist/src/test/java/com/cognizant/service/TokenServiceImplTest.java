package com.cognizant.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.feignclient.AuthClient;
import com.cognizant.pojo.AuthResponse;

/**
 * This class contains test cases for the TokenServiceImpl class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TokenServiceImpl.class)
public class TokenServiceImplTest {

	@Autowired
	TokenServiceImpl tokenService;
	@MockBean
	AuthClient authClient;
	@MockBean
	AuthResponse authResponse;
	@MockBean
	ResponseEntity<AuthResponse> entity;

	/**
	 * to check token validity when token is valid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {
		String token = token();
		AuthResponse authResponse = prepareAuthResponse();
		entity = new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
		Mockito.when(authClient.getValidity(Mockito.any())).thenReturn(entity);

		assertEquals(true, tokenService.checkTokenValidity(token));

	}

	/**
	 * to check token validity when token gives null pointer exception
	 */
	@Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {
		Mockito.when(authClient.getValidity(Mockito.any())).thenReturn(null);
	}

	/**
	 * to check token when token validity is invalid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
		AuthResponse authResponseInvalid = prepareAuthResponseInvalid();
		entity = new ResponseEntity<AuthResponse>(authResponseInvalid, HttpStatus.FORBIDDEN);
		Mockito.when(authClient.getValidity(Mockito.any())).thenReturn(entity);

		assertEquals(false, tokenService.checkTokenValidity(""));

	}

	private String token() {
		return "token";
	}
	private AuthResponse prepareAuthResponse() {
		AuthResponse authResponse = new AuthResponse();
		authResponse.setUid("abc");
		authResponse.setValid(true);
		return authResponse;
	}
	private AuthResponse prepareAuthResponseInvalid() {
		AuthResponse authResponse = new AuthResponse();
		authResponse.setUid("abc");
		authResponse.setValid(false);
		return authResponse;
	}

}
