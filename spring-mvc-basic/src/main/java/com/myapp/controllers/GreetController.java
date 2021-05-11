package com.myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	
	@GetMapping("/greet")
	public String greetMessage(Model model) {
		model.addAttribute("message", "Have a great day");
		return "success";
	}
	@RequestMapping("/show")
	public String show(ModelMap model) {
		model.addAttribute("message", "Spring MVC");
		return "success";
	}
	@RequestMapping("/print")
	public ModelAndView print() {
		ModelAndView model = new ModelAndView("success","message","Gloomy Day");
		return model;
	}
}
