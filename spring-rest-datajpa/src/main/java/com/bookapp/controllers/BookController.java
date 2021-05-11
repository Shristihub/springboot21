package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;


@Controller
public class BookController {

	@Autowired
	BookService bookService;
	@PostMapping("/books")
	void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	@PutMapping("/books")
	void updateBook(@RequestBody Book book)throws IdNotFoundException{
		bookService.updateBook(book);
	}
	@DeleteMapping("/books")
	void deleteBook(int bookid)throws IdNotFoundException{
		bookService.deleteBook(bookid);
	}
	@GetMapping("/books")
	List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	@GetMapping("/books-by-id/{bookid}")
	Book getBookById(@PathVariable("bookid") int bookid) throws IdNotFoundException{
		return bookService.getBookById(bookid);
	}
	
	@GetMapping("/books-by-author/{author}")
	List<Book> getBookByAuthor(@PathVariable("author")String author) throws AuthorNotFoundException{
		return bookService.getBookByAuthor(author);
	}
	@GetMapping("/books-by-category/{category}")
	List<Book> getBookByCategory(@PathVariable("category")String category) throws CategoryNotFoundException{
		return bookService.getBookByCategory(category);
	}
	@GetMapping("/books-by-choice/{choice}")
	List<Book> getByCatOrTitleOrAuth(@PathVariable("choice") String choice){
		return bookService.getByCatOrTitleOrAuth(choice);
	}
}
