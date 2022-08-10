package com.authentication.AuditAuthentication.repository;

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

import com.authentication.AuditAuthentication.model.UserCredentials;
import com.authentication.AuditAuthentication.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
class UserRepositoryTest {
	@Autowired
	UserServiceImpl service;
	@MockBean
	UserRepository userRepository;

	@Test
	void saveTest() {

			UserCredentials user = prepareUserCredentials();
			Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
			assertEquals("admin", user.getUsername());
	}

	@Test
	void findByIdCorrectTest() {
		UserCredentials user = prepareUserCredentials();
		Optional<UserCredentials> userById = userRepository.findById("admin");
		
		Mockito.when(userRepository.findById(Mockito.any())).thenReturn(userById);
		assertEquals("admin", user.getUsername());
	}

	@Test
	void findByIdIncorrectTest() {
		UserCredentials user = prepareUserCredentials();
		Optional<UserCredentials> userById = userRepository.findById("add min");
		Mockito.when(userRepository.findById(Mockito.any())).thenReturn(userById);
		assertNotEquals("add min", user.getUsername());
	}
	
	private UserCredentials prepareUserCredentials() {
		UserCredentials user = new UserCredentials("admin", "admin123");
		user.setUsername("admin");
		user.setPassword("admin123");
		return user;
	}

}
