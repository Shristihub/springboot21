package com.userapp.service;

import java.util.List;

import com.userapp.model.User;

public interface UserService {
	boolean validateUser(User user);
	List<String> getItemsByCategory(String category);

}
