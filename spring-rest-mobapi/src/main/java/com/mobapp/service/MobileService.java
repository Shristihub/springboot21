package com.mobapp.service;

import java.util.List;

import com.mobapp.model.Mobile;

public interface MobileService {

	List<Mobile> getAll();
	List<Mobile> getByBrand(String brand);
	List<Mobile> getByBrandAndModel(String brand,String model);
	Mobile getById(int id);
}
