package com.pbs.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;

import com.pbs.domain.User;
import com.pbs.service.FormOptionsService;
import com.pbs.service.UserRegistrationService;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationControllerTest {
	
	private UserRegistrationController controller;
	@Mock private UserRegistrationService userRegistrationService;
	@Mock FormOptionsService countryOptionsService;
	
	@Before
	public void setUp() {
		controller = new UserRegistrationController(userRegistrationService, countryOptionsService);
	}
	
	@Test
	public void shouldShowRegistrationForm() {
		// when
		User user = new User();
		String view = controller.showRegistrationForm(user );
		
		// then
		assertThat(view, is("userRegistrationForm"));
	}
	
	@Test
	public void shouldShowFormErrors() {
		// given form has errors
		BindingResult result = mock(BindingResult.class);
		given(result.hasErrors()).willReturn(true);
		
		// when
		User user = new User();
		String view = controller.submitRegistrationForm(user, result);
		
		// then
		assertThat(view, is("userRegistrationForm"));
	}
	
	@Test
	public void shouldSubmitForm() {
		// given form has no errors
		BindingResult result = mock(BindingResult.class);
		given(result.hasErrors()).willReturn(false);
		
		// when
		User user = new User();
		String view = controller.submitRegistrationForm(user, result);
		
		// then
		assertThat(view, is("registrationSuccess"));
		// and the user is added
		verify(userRegistrationService).registerUser(user);
	}
	
	@Test
	public void shouldPopulateCountryOptions() {
		// given
		List<String> countryOptions = new ArrayList<String>();
		given(countryOptionsService.getCountryOptions()).willReturn(countryOptions);
		
		// when
		List<String> actualCountryOptions = controller.getCountryOptions();
		
		// then
		assertThat(actualCountryOptions, sameInstance(countryOptions));
	}

 }
