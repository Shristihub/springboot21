package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookapp.model.User;
import com.bookapp.service.UserService;


@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/loginUser")
	public String loginUser(@ModelAttribute User user, Model model) {
		if(userService.validateUser(user).equals("admin")) {
			model.addAttribute("username", user.getUsername());
			return "admin";
		}else if(userService.validateUser(user).equals("Sri")){
			model.addAttribute("username", user.getUsername());
			return "cart";
		}else {
			model.addAttribute("errorMessage", "Invalid Credentials");
			return "login";
		}
	}
	
	@GetMapping("/addBookForm")
	public String addBookForm() {
		return "addBook";
	}
	@GetMapping("/editBookForm")
	public String editBookForm() {
		return "editBook";
	}
	@GetMapping("/deleteBookForm")
	public String deleteBookForm() {
		return "deleteBook";
	}
	
}
