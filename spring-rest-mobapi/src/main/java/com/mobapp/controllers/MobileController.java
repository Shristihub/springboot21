package com.mobapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobapp.model.Mobile;
import com.mobapp.service.MobileService;

@RestController
@RequestMapping("/mobile-api")
public class MobileController {

	@Autowired
	MobileService mobileService;
	
	@PostMapping("/mobiles")
	public ResponseEntity<Void> addMobile(@RequestBody Mobile mobile){
		System.out.println(mobile);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	
	}
	@PutMapping("/mobiles")
	public ResponseEntity<String> updateMobile(@RequestBody Mobile mobile){
		System.out.println(mobile);
		return ResponseEntity.accepted().body("updated");
	
	}
	@DeleteMapping("/mobiles")
	public ResponseEntity<String> deleteMobile(@RequestBody Mobile mobile){
		System.out.println(mobile);
		return ResponseEntity.accepted().body("deleted");
	
	}
	@GetMapping("/mobiles")
	public ResponseEntity<List<Mobile>> getAll(){
		List<Mobile> mobileList = mobileService.getAll();
		return ResponseEntity.ok(mobileList);
	}
	
	@GetMapping("/mobiles-by-brand/{brand}")
	public ResponseEntity<List<Mobile>> getByBrand(@PathVariable("brand")String brand){
		List<Mobile> mobileList = mobileService.getByBrand(brand);
		HttpHeaders header = new HttpHeaders();
		header.add("details", "Mobiles by brand");
		return ResponseEntity.ok(mobileList);
	}
	@GetMapping("/mobiles-by-brand/{brand}/model/{model}")
	public ResponseEntity<List<Mobile>> getByBrandAndModel(@PathVariable("brand")String brand,@PathVariable("model")String model){
		List<Mobile> mobileList = mobileService.getByBrandAndModel(brand, model);
		return ResponseEntity.ok(mobileList);
	}
	@GetMapping("/mobile-by-id/{id}")
	public ResponseEntity<Mobile> getById(@PathVariable("id")int id){
		Mobile mobile = mobileService.getById(id);
		return ResponseEntity.ok(mobile); 
	}
}
