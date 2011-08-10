package com.pbs.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pbs.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/daoTestContext.xml")
@Transactional
public class UserDaoIntegrationTest {
	
	@Resource UserDao userDao;
	
	@Test
	public void shouldAddAndGetUser() {
		// given we add user
		User user = new User(1L, "name", "email@pbs.com", "password", "country");
		userDao.save(user);
		
		// when we get user
		User userReturned = userDao.get(1L);
		assertThat(userReturned, is(user));
	}
	
	@Test
	public void shouldReturnAllUsers() {
		// given users
		User user = new User(1L, "name", "email@pbs.com", "password", "country");
		userDao.save(user);
		User user2 = new User(2L, "name", "email@pbs.com", "password", "country");
		userDao.save(user2);
		
		// when we get users
		List<User> allUsers = userDao.getAllUsers();
		assertThat(allUsers.size(), is(2));
		assertTrue(allUsers.contains(user));
		assertTrue(allUsers.contains(user2));
	}
	
	@Test
	public void shouldReturnAvailableUsers() {
		// given users
		User user = new User(1L, "Gajendra Bisht", "email@pbs.com", "password", "country");
		userDao.save(user);
		User user2 = new User(2L, "Kedar Mohapatra", "email@pbs.com", "password", "country");
		userDao.save(user2);
		
		// when
		List<User> allUsers = userDao.getAutoCompleteSuggestedUsers("gaj");
		
		// then
		assertThat(allUsers.size(), is(1));
		assertThat(allUsers.get(0).getName(), is("Gajendra Bisht"));
	}
	
}
