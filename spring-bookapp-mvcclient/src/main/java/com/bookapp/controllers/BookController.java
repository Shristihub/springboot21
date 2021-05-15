package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.bookapp.model.Book;

@Controller
public class BookController {

	@Autowired
	RestTemplate template;
	public static final String BASEURL = "http://localhost:8081/book-api";

	@GetMapping("/")
	public String homePage(Model model) {
		String url = BASEURL + "/books";
		ResponseEntity<?> entity = template.getForEntity(url, List.class);
		model.addAttribute("bookList", entity.getBody());
		return "home";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		return "admin";
	}

	@GetMapping("/books")
	public String allBook(Model model) {
		return "redirect:/";
	}

	@PostMapping("/addBook")
	public String addBookForm(@ModelAttribute Book book, Model model) {
		String url = BASEURL + "/books";

		// use multivalue map for body client
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("title", book.getTitle());
		paramMap.add("bookId", book.getBookId());
		paramMap.add("author", book.getAuthor());
		paramMap.add("category", book.getCategory());
		paramMap.add("price", book.getPrice());
		// getting the bodycontent alone
		ResponseEntity<Void> entity = template.postForEntity(url, paramMap, Void.class);
		String message = "added successfully";
		if (entity.getStatusCodeValue() != 201) {
			message = "exception";
		}
		model.addAttribute("message", message);
		return "admin";
	}

	@GetMapping("/editBook")
	public String editBook(@RequestParam("bookId") int id, Model model) {
		String url = BASEURL + "/books-by-id/" + id;
		ResponseEntity<Book> entity = template.getForEntity(url, Book.class);
		Book book = entity.getBody();
		model.addAttribute("book", book);
		return "updateBook";
	}
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") int id, Model model) {
		System.out.println(id);
		String url = BASEURL + "/books/" + id;
		template.delete(url);
		
		return "admin";
	}

	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute Book book, Model model) {
		String url = BASEURL + "/books";
		// use multivalue map for body client
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("title", book.getTitle());
		paramMap.add("bookId", book.getBookId());
		paramMap.add("author", book.getAuthor());
		paramMap.add("category", book.getCategory());
		paramMap.add("price", book.getPrice());
		// getting the bodycontent alone
		template.put(url, paramMap);
		model.addAttribute("updated", "up");
		return "admin";
	}

	@GetMapping("/home")
	public String home(Model model) {
		return "redirect:/";
	}

	@GetMapping("/search-by-author")
	public String searchByBrand(@RequestParam("author") String author, Model model) {
		String url = BASEURL + "/books-by-author/" + author;
		ResponseEntity<?> entity = template.getForEntity(url, List.class);
		model.addAttribute("bookList", entity.getBody());
		return "home";
	}

	@GetMapping("/search-by-category")
	public String searchByCategory(@RequestParam("category") String category, Model model) {
		String url = BASEURL + "/books-by-category/" + category;
		ResponseEntity<?> entity = template.getForEntity(url, List.class);
		model.addAttribute("bookList", entity.getBody());
		return "home";
	}

	@GetMapping("/search-by-id")
	public String searchById(@RequestParam("bookId") int id, Model model) {
		String url = BASEURL + "/books-by-id/" + id;
		ResponseEntity<Book> entity = template.getForEntity(url, Book.class);
		Book book = entity.getBody();
		model.addAttribute("book", book);
		return "home";
	}

	@GetMapping("/search")
	public String searchByChoice(@RequestParam("choice") String choice, Model model) {
		String url = BASEURL + "/books-by-choice/" + choice;
		ResponseEntity<?> entity = template.getForEntity(url, List.class);
		model.addAttribute("bookList", entity.getBody());
		return "home";
	}
}
