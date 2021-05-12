package com.mobapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {

	private Integer mobileId;
	private String model;
	private String brand;
	private double price;
	
	
}
