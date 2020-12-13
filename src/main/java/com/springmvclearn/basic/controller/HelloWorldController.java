package com.springmvclearn.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@ApiOperation(value = "Hello World Controller")
@RequestMapping("/hello")
public class HelloWorldController {

    @ApiOperation(value = "Hello World Show Form")
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(){
        return "helloworld-form";
    }

    @ApiOperation(value = "Hello World Process Form with no parameter required.")
    @RequestMapping(value = "/processForm", method = RequestMethod.GET)
    public String processForm(){
        return "helloworld";
    }

    @ApiOperation(value = "Hello World Process Form with parameter get using HttpServletRequest.")
    @RequestMapping(value = "/processFormVersionTwo", method = RequestMethod.GET)
    public String processForm2(HttpServletRequest request, Model model){
        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Yo! " + name;

        model.addAttribute("message", result);
        return "helloworld";
    }

    @ApiOperation(value = "Hello World Process Form with parameter get using RequestParam.")
    @RequestMapping(value = "/processFormVersionThree", method = RequestMethod.GET)
    public String processForm3(@RequestParam("studentName") String name, Model model){
        name = name.toUpperCase();
        String result = "Yo! " + name;

        model.addAttribute("message", result);
        return "helloworld";
    }
}
