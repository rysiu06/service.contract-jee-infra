package com.serbrave.appfuse.test02.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.serbrave.appfuse.test02.webapp.model.Person;

@Controller
@RequestMapping("/personform*")
public class PersonFormController extends BaseFormController{
	private GenericManager<Person, Long> personManager;

	@Autowired
	public void setPersonManager(@Qualifier("personManager") GenericManager<Person, Long> personManager){
		this.personManager = personManager;
	}
	
	public PersonFormController(){
		super.setCancelView("redirect:/persons");
		super.setSuccessView("redirect:/persons");
	}
	
	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public Person showForm(HttpServletRequest request) throws Exception{
		String id = request.getParameter("id");
		
		if (!StringUtils.isBlank(id)){
			return personManager.get(new Long(id));
		}
		return new Person();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Person person, BindingResult errors, HttpServletRequest request, HttpServletResponse mockHttpServletResponse) throws Exception{
		if (request.getParameter("cancel") != null){
			return super.getCancelView();
		}
		
		if (validator != null){
			validator.validate(person, errors);
			
			if (errors.hasErrors() && request.getParameter("delete") == null){
				return "personform";
			}
		}
		
		boolean isNew = (person.getId() == null);
		String success = super.getSuccessView();
		Locale locale = request.getLocale();
		
		if (request.getParameter("delete") != null){
			personManager.remove(person);
			super.saveMessage(request, super.getText("person.deleted", locale));
		}else{
			personManager.save(person);
			String key = isNew ? "person.added" : "person.updated";
			super.saveMessage(request, super.getText(key, locale));
			
			if (!isNew){
				success = "redirect:personform?id=" + person.getId();
			}
		}
		
		return success;
	}
	
	
	
}
