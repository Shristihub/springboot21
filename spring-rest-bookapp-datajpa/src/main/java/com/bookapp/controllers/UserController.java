package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserService userService;

	
	
	
}
