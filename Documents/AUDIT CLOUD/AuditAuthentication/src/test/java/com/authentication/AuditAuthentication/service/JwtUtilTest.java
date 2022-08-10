package com.authentication.AuditAuthentication.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.authentication.AuditAuthentication.model.LoginModel;
import com.authentication.AuditAuthentication.model.UserCredentials;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
class JwtUtilTest {
	@Autowired
	JwtUtil jwtUtilService;
	@Autowired
	UserServiceImpl userService;

	@Test
	void extractUsernameTest() {
		UserDetails userDetails = userService.loadUserByUsername("admin");
		String token = jwtUtilService.generateToken(userDetails);
		String username = jwtUtilService.extractUsername(token);
		assertEquals("admin", username);
	}

	@Test
	void extractExpirationTest() {
		UserDetails userDetails = userService.loadUserByUsername("admin");
		String token = jwtUtilService.generateToken(userDetails);
		Date date = jwtUtilService.extractExpiration(token);
		assertNotNull(date);
	}

	@Test
	void extractAllClaimsTest() {
		UserDetails userDetails = userService.loadUserByUsername("admin");
		String token = jwtUtilService.generateToken(userDetails);
		assertNotNull(token);

	}

	@Test
	void validateCorrectTokenTest() {
		UserDetails userDetails = userService.loadUserByUsername("admin");
		String token = jwtUtilService.generateToken(userDetails);
		assertNotNull(token);
	}

	@Test
	void validateIncorrectTokenTest() {
		LoginModel loginModel = new LoginModel("admin",
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyNjk0MTAxOCwiaWF0IjoxNjI2OTM5MjE4fQ.cROV5sjMXDcVY74zgWZsawx4MRAaW-Ai9_pjuX8woPA");
		try {
			jwtUtilService.validateToken(loginModel);
			fail("The jwt token is expired, but no error was thrown");
		} catch (Exception e) {

		}

	}
	private UserCredentials prepareUserCredentials() {
		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUsername("abc");
		userCredentials.setPassword("abc123");
		return userCredentials;
	}

	private LoginModel prepareLoginModel() {
		LoginModel loginModel = new LoginModel();
		loginModel.setUsername("abc");
		loginModel.setToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyNjk0MTAxOCwiaWF0IjoxNjI2OTM5MjE4fQ.cROV5sjMXDcVY74zgWZsawx4MRAaW-Ai9_pjuX8woPA");
		return loginModel;
	}

}
