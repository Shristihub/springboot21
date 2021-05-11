package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;


@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Book> bookList = bookService.getAllBooks();
		System.out.println(bookList);
		model.addAttribute("bookList",bookList);
		return "home";
	}
	@GetMapping("/home")
	public String homePage(Model model) {
		
		return "redirect:/";
	}
	@GetMapping("/search" )
	public String home(@RequestParam("choice") String choice,Model model) {
		List<Book> bookList = bookService.getByCatOrTitleOrAuth(choice);
		model.addAttribute("book",bookList);
		return "home";
	}
	@GetMapping("/addBook")
	public String addBook(@ModelAttribute Book book,Model model) {
		bookService.addBook(book);
		model.addAttribute("message","Book Added Successfully");
		model.addAttribute("book",book);
		return "admin";
	}
	@GetMapping("/editBook")
	public String editBook(@RequestParam("bookid") int bookid,Model model) {
		Book book =null;
		try {
			book = bookService.getBookById(bookid);
		} catch (IdNotFoundException e) {
			
		}
		model.addAttribute("message","Book edited Successfully");
		model.addAttribute("book",book);
		return "updateBook";
	}

	@GetMapping("/updateBook")
	public String updateBook(@ModelAttribute Book book,Model model) {
		try {
			bookService.updateBook(book.getBookId(), book.getPrice());
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
		model.addAttribute("message","Book updated Successfully");
		return "admin";
	}
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookid") int bookid,Model model) {
		try {
			bookService.deleteBook(bookid);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("message","Book deleted Successfully");
		return "admin";
	}
}
