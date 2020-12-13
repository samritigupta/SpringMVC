package com.springmvclearn.basic.controller;

import java.util.Map;

import com.springmvclearn.basic.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(tags = "Student")
@ApiOperation(value = "Student Home Page")
@RequestMapping("/student")
public class StudentController {

	@Value("#{languageOptions}")
	private Map<String, String> languageOptions;

	@ApiOperation(value = "Student show Form")
	@RequestMapping(value = "/showForm", method = RequestMethod.GET)
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("theLanguageOptions", languageOptions);
		
		return "student-form";
	}

	@ApiOperation(value = "Student Process Form with parameter get using ModelAttribute.")
	@RequestMapping(value = "/processForm", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName()
							+ " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
	
}









