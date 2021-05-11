package com.bookapp.service;

import org.springframework.stereotype.Service;

import com.bookapp.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public String validateUser(User user) {
		if(user.getUsername().equals("admin")&& user.getPassword().equals("admin123")) {
			return "admin";
		}else if(user.getUsername().equals("Sri")&& user.getPassword().equals("sri123")) {
			return "user";
		}else {
			return "error";
		}
	}

}
