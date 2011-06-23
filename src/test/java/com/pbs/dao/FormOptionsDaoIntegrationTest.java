package com.pbs.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/daoTestContext.xml")
@Transactional
public class FormOptionsDaoIntegrationTest {
	
	@Resource FormOptionsDao dao;
	@Resource JdbcTemplate jdbcTemplate;
	
	@Test
	public void shouldReturnCountryOptions() {
		// given country options
		jdbcTemplate.update("insert into country_option values ('China')");
		jdbcTemplate.update("insert into country_option values ('India')");
		jdbcTemplate.update("insert into country_option values ('America')");
		
		// when
		List<String> countryOptions = dao.getCountryOptions();
		
		// then
		assertThat(countryOptions.get(0), is("America"));
		assertThat(countryOptions.get(1), is("China"));
		assertThat(countryOptions.get(2), is("India"));
	}

}
