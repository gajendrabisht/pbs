package com.pbs.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
	
}
