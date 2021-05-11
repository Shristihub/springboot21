package com.userapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.userapp.model.User;
import com.userapp.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
//	@PostMapping("/loginUser")
	@RequestMapping(value = "/loginUser",method = RequestMethod.POST)
	public String loginUser(@ModelAttribute User user, Model model) {
		boolean result = userService.validateUser(user);
		if(!result) {
			model.addAttribute("errorMessage","username or password is wrong");
			return "login";
		}
		model.addAttribute("username",user.getUsername());
		return "show";
	}
	@GetMapping("/showItems")
	public String showItems(@RequestParam("category")String categ, Model model) {
		List<String> itemsList = userService.getItemsByCategory(categ);
		model.addAttribute("itemsList",itemsList);
		return "final";
	}
}












