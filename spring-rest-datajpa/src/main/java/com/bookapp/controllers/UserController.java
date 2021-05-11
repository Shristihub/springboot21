package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bookapp.service.UserService;


@Controller
public class UserController {
	@Autowired
	UserService userService;

	
	
	
}
