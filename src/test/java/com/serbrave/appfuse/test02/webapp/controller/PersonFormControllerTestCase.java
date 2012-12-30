package com.serbrave.appfuse.test02.webapp.controller;


import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.serbrave.appfuse.test02.webapp.model.Person;

public class PersonFormControllerTestCase extends BaseControllerTestCase {
	@Autowired
	private PersonFormController form;
	private Person person;
	private MockHttpServletRequest request;
	
	@Test
	public void testEdit() throws Exception{
		log.debug("test Editing ... ");
		request = newGet("/personform");
		request.addParameter("id", "-1");
		
		person = form.showForm(request);
		assertNotNull(person);
	}
	
	@Test
	public void testSave() throws Exception{
		request = newGet("/personform");
		request.addParameter("id", "-1");
		
		person = form.showForm(request);
		assertNotNull(person);
		
		request = newPost("/personform");
		
		person = form.showForm(request);
		// update required fields
		person.setId(2L);
		person.setFirstName("Robert");
		person.setLastName("Tsang");
		
		BindingResult errors = new DataBinder(person).getBindingResult();
		form.onSubmit(person, errors, request, new MockHttpServletResponse());
		
		assertFalse(errors.hasErrors());
		assertNotNull(request.getSession().getAttribute("successMessages"));
	}
	
	
	@Test
	public void testRemove() throws Exception{
		request = newGet("/personform");
		request.addParameter("delete", "");
		
		person = new Person();
		person.setId(-1L);
		
		BindingResult errors = new DataBinder(person).getBindingResult();
		form.onSubmit(person, errors, request, new MockHttpServletResponse());
		
		assertNotNull(request.getSession().getAttribute("successMessages"));
	}
}
