package com.mobapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.mobapp.model.Mobile;

@Controller
public class MobClientController {

	@Autowired
	RestTemplate restTemplate;
	public static final String BASEURL = "http://localhost:8081/mobile-api";

	@GetMapping("/")
	public String homePage(Model model) {
		String url = BASEURL + "/mobiles";
		ResponseEntity<?> entity = restTemplate.getForEntity(url, List.class);
		model.addAttribute("mobileList", entity.getBody());
		return "home";
	}

//	url is http://localhost:8081/mobile-api/mobiles-by-brand/Sony
	@GetMapping("/search-by-brand")
	public String searchbyBrand(@RequestParam("brand") String brand, Model model) {
		String url = BASEURL + "/mobiles-by-brand/" + brand;
		ResponseEntity<?> entity = restTemplate.getForEntity(url, List.class);
		System.out.println(entity.getHeaders().containsKey("details"));
		System.out.println(entity.getStatusCode());
		model.addAttribute("mobileList", entity.getBody());
		return "home";

	}

//	http://localhost:8081/mobile-api/mobiles-by-brand/Samsung/model/A123
	@GetMapping("/search-by-brand-model")
	public String searchbyBrandModel(@RequestParam("brand") String brand, 
			@RequestParam("model") String model,Model map) {
		String url = BASEURL + "/mobiles-by-brand/"+brand+"/model/"+model;
		ResponseEntity<?> entity = restTemplate.getForEntity(url, List.class);
		map.addAttribute("mobileList", entity.getBody());
		return "home";
	}
	
//	http://localhost:8081/mobile-api/mobile-by-id/10
	@GetMapping("/search-by-id")
	public String getById(@RequestParam("id") int mobileId, Model map) {
		String url = BASEURL + "/mobile-by-id/"+mobileId;
		ResponseEntity<Mobile> entity = restTemplate.getForEntity(url, Mobile.class);
		Mobile mobile = entity.getBody();
		map.addAttribute("mobile", mobile);
		return "home";
	}

}
