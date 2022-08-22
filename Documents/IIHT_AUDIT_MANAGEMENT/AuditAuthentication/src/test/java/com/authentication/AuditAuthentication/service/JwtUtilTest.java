package com.authentication.AuditAuthentication.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
}
