package com.studentapp.exception;

public class CityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityNotFoundException() {
		super();
	}

	public CityNotFoundException(String message) {
		super(message);
	}

}
