package com.duttech.relationships.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duttech.relationships.models.License;
import com.duttech.relationships.models.Person;
import com.duttech.relationships.services.LicenseService;
import com.duttech.relationships.services.PersonService;

@Controller
public class MainController {
	
	@Autowired
	private PersonService personServe;
	
	@Autowired
	private LicenseService licServe;

//	index page-----------
	@RequestMapping("/persons/new")
	public String showNew(Model model, @ModelAttribute("person") Person person) {
		List<Person> newPersons = personServe.allPerson();
		model.addAttribute("newPersons", newPersons);
		return "/persons/index.jsp";
	}
	@RequestMapping(value="/create/new", method= RequestMethod.POST)
	public String newPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/persons/index.jsp";
		}else {
			personServe.newPerson(person);
			return "redirect:/persons/new";
		}
	}
	
	@GetMapping("/licenses/new")
	public String showLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> licPersons = personServe.allPerson();
		model.addAttribute("licPersons", licPersons);
		return "/licenses/index.jsp";
	}
	
	@PostMapping(path="/create/license")
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/licenses/index.jsp";
		}else {
			
			License newLic = licServe.newLicense(license);
			newLic.setNumber(String.format("%06d",newLic.getId()));
			licServe.updatedLicense(newLic);
			return "redirect:/licenses/new";
		}
		
	}
	
	@GetMapping("/persons/{id}")
	public String showLicense(@PathVariable("id") Long id, Model model) {
		License oneLic= licServe.aLicense(id);
		model.addAttribute("oneLic", oneLic);
		return "/persons/show.jsp";
	}
	

	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

	
	
}
