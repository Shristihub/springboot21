package com.userapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.userapp.model.User;
@Service
public class UserServiceImpl implements UserService {

//	String[] usernames = {"Jack","Sri","Kathy","Jo","Rakhi"};
	List<String> usernames = Arrays.asList("Jack","Sri","Kathy","Jo","Rakhi");
	
	List<String> mobiles = Arrays.asList("Samsung","Apple","Vivo","Motorola");
	List<String> laptops = Arrays.asList("Samsung","Mac","Lenova","Dell");
	List<String> headphones = Arrays.asList("Bose","iBall","JBL","Boat");
	
	@Override
	public boolean validateUser(User user) {
		if(usernames.contains(user.getUsername())&& user.getPassword().equals("user123")) {
			return true;
		}
		return false;
	}
	@Override
	public List<String> getItemsByCategory(String category) {
		if(category.equals("Mobile")) {
			return mobiles;
		}if(category.equals("Laptop")) {
			return laptops;
		}if(category.equals("Headphones")) {
			return headphones;
		}else
			return new ArrayList<>();
	}

}
