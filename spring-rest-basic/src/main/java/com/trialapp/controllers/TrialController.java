package com.trialapp.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialController {

	@GetMapping("/greet")
	public String greetMessage() {
		return "Have great day";
	}
	@GetMapping("/print/{username}")
	public String printName(@PathVariable("username")String name) {
		return "Welcome "+name;
	}
	@GetMapping("/search-by-city")
	public String printUsername(@RequestParam("city")String mycity) {
		if(mycity.equals("Bangalore"))
			return "Keys";
		else
			return "Chettinad";
	}
	
	@GetMapping("show-items")
	public List<String> showAll() {
		return Arrays.asList("Laptop","Mobile","x-box");
	}
	@GetMapping("show-by-type/{type}")
	public List<String> showbyType(@PathVariable("type")String type) {
		return Arrays.asList("Laptop-elec","Mobile-elec","x-box-gadget")
			  .stream()
			   .filter((item)->item.contains(type))
			   .collect(Collectors.toList());
	}
}
