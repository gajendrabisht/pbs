package com.pbs.service;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.pbs.dao.FormOptionsDao;

@RunWith(MockitoJUnitRunner.class)
public class FormOptionsServiceTest {
	
	private FormOptionsService service;
	@Mock FormOptionsDao formOptionsDao;
	
	@Before
	public void setUp() {
		service = new FormOptionsService(formOptionsDao);
	}
	
	@Test
	public void shouldReturnCountryOptions() {
		// given
		List<String> countryOptions = new ArrayList<String>();
		given(formOptionsDao.getCountryOptions()).willReturn(countryOptions);
		
		// when
		List<String> countryOptionsReturned = service.getCountryOptions();
		
		// then
		assertThat(countryOptionsReturned, sameInstance(countryOptions));
	}

}
