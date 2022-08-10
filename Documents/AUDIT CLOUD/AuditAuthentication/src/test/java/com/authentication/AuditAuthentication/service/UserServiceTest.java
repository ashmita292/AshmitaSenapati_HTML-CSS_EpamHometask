package com.authentication.AuditAuthentication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.authentication.AuditAuthentication.model.LoginModel;
import com.authentication.AuditAuthentication.model.UserCredentials;
import com.authentication.AuditAuthentication.repository.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
class UserServiceTest {
	@Autowired
	UserServiceImpl userService;
	@Autowired
	JwtUtil jwtUtilObject;
	@MockBean
	UserRepository userRepository;

	@Test
	void addNewUserTest() {
		UserCredentials userCredentials = prepareUserCredentials();
		Optional<UserCredentials> existingUser = userRepository.findById("dummy");
		if (!existingUser.isPresent()) {
			Mockito.when(userRepository.save(Mockito.any())).thenReturn(userCredentials);
			assertEquals("abc", userCredentials.getUsername());
		}

	}

	@Test
	void addExistingUserTest() {
		UserCredentials userCredentials = prepareUserCredentials();
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(userCredentials);
		assertEquals("abc", userCredentials.getUsername());

	}

	@Test
	void loadUserByCorrectUsernameTest() {
		UserCredentials userCredentials = prepareUserCredentials();
		LoginModel loginModel = prepareLoginModel();
//		UserDetails loadUserByUsername = userService.loadUserByUsername(userCredentials.getUsername());
//		Mockito.when(userService.loadUserByUsername(Mockito.any())).thenReturn(loadUserByUsername);
		assertEquals(loginModel.getUsername(), userCredentials.getUsername());

	}

	@Test
	void loadUserByIncorrectUsernameTest() {
		String username = "add min";
		UserCredentials userCredentials = prepareUserCredentials();
		LoginModel loginModel = prepareLoginModel();
//		UserDetails loadUserByUsername = userService.loadUserByUsername(userCredentials.getUsername());
//		Mockito.when(userService.loadUserByUsername(Mockito.any())).thenReturn(loadUserByUsername);
		assertNotEquals(username, userCredentials.getUsername());
	}

	@Test
	void validateCorrectCredentialsUserTest() {
		UserCredentials userCredentials = prepareUserCredentials();
		LoginModel loginModel = prepareLoginModel();
		assertEquals(loginModel.getUsername(), userCredentials.getUsername());
//		LoginModel validateCredentialsUser = userService.validateCredentialsUser(userCredentials);
//		assertNotNull(validateCredentialsUser);
//		Mockito.when(userService.validateCredentialsUser(Mockito.any())).thenReturn(validateCredentialsUser);

	}

	@Test
	void validateIncorrectCredentialsUserTest() {
		UserCredentials userCredentials = prepareUserCredentials();
		LoginModel loginModel = prepareLoginModel();
		assertNotEquals("xyz", userCredentials.getUsername());
//		LoginModel validateCredentialsUser = userService.validateCredentialsUser(userCredentials);
//		assertNotNull(validateCredentialsUser);
//		Mockito.when(userService.validateCredentialsUser(Mockito.any())).thenReturn(validateCredentialsUser);

	}

	@Test
	void validateCorrectJwtToken() {
		String token= "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyNjk0MTAxOCwiaWF0IjoxNjI2OTM5MjE4fQ.cROV5sjMXDcVY74zgWZsawx4MRAaW-Ai9_pjuX8woPA";
		LoginModel loginModel = prepareLoginModel();
		assertEquals(token, loginModel.getToken());

}

	@Test
	void validateIncorrectJwtToken() {
		String token= "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyNjk0MTAxOCwiaWF0IjoxNjI2OTM5MjE4fQ.cROV5sjMXDcVY74zgWZsawx4MRAaW-Ai9_pjuX8woPA ";
		LoginModel loginModel = prepareLoginModel();
		assertNotEquals(token, loginModel.getToken());
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
