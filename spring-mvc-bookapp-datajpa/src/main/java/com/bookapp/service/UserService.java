package com.bookapp.service;

import com.bookapp.exceptions.UserNotFoundException;
import com.bookapp.model.User;

public interface UserService {
	String validateUser(User user) throws UserNotFoundException;

}
