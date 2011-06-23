package com.pbs.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.pbs.dao.UserDao;
import com.pbs.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationServiceTest {
	
	private UserRegistrationService service;
	@Mock UserDao userDao;
	
	@Before
	public void setUp() {
		service = new UserRegistrationService(userDao);
	}
	
	@Test
	public void shouldRegisterUser() {
		// when we register user
		User user = new User();
		service.registerUser(user);
		
		// then user is added
		verify(userDao).save(user);
	}

}
