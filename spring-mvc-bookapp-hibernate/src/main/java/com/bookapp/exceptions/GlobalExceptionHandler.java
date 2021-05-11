package com.bookapp.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public String handleIdException(IdNotFoundException e, Model model) {
		model.addAttribute("errorMessage", e.getMessage());
		return "editBook";
	}
	@ExceptionHandler(AuthorNotFoundException.class)
	public String handleAuthorException(Exception e, Model model) {
		model.addAttribute("errorMessage", "Exception.....");
		return "redirect:/";
	}
	@ExceptionHandler(CategoryNotFoundException.class)
	public String handleCategoryException(CategoryNotFoundException e, Model model) {
		model.addAttribute("errorMessage", e.getMessage());
		return "redirect:/";
	}
	@ExceptionHandler(BookNotFoundException.class)
	public String handleBookException(BookNotFoundException e, Model model) {
		model.addAttribute("errorMessage", e.getMessage());
		return "redirect:/";
	}

}
