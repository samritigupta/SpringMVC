package com.springmvclearn.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@ApiOperation(value = "Home page for the App.")
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showPage() {
		return "main-menu";
	}
}

