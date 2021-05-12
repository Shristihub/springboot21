package com.mobapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mobapp.model.Mobile;

@Service
public class MobileServiceImpl implements MobileService {

	@Override
	public List<Mobile> getAll() {
		return showMobiles();
	}

	@Override
	public List<Mobile> getByBrand(String brand) {
		return showMobiles()
				.stream()
				.filter(mobile -> mobile.getBrand().equals(brand))				 
				.collect(Collectors.toList());
	}

	@Override
	public List<Mobile> getByBrandAndModel(String brand, String model) {
		return showMobiles()
				.stream()
				.filter(mobile ->
				(mobile.getBrand().equals(brand)&& mobile.getModel().equals(model)))
				.collect(Collectors.toList());
	}

	@Override
	public Mobile getById(int id) {
		return showMobiles()
		.stream()
		.filter(mobile-> mobile.getMobileId()==id)
		.findFirst().get();
	}

	private List<Mobile> showMobiles(){
		return Arrays.asList(new Mobile(10,"A123","Samsung",9900.9),
				new Mobile(11,"So234","Sony",30300.9),
				new Mobile(12,"Mt124","Motorola",21900.9),
				new Mobile(13,"Mt125","Motorola",7600.9),
				new Mobile(14,"So235","Sony",99010.9),
				new Mobile(15,"A124","Samsung",59900.9)
							
				);
	}
}
