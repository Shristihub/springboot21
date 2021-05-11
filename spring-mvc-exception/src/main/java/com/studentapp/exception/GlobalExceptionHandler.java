package com.studentapp.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IDNotFoundException.class)
	public String handleIdException(IDNotFoundException e, Model model) {
		model.addAttribute("message", e.getMessage());
		System.out.println(".......global.....");
		return "redirect:/";
	}
	@ExceptionHandler(Exception.class)
	public String handleOtherException(Exception e, Model model) {
		model.addAttribute("message", "Exception.....");
		System.out.println(".......global.....");
		return "redirect:/";
	}
}
