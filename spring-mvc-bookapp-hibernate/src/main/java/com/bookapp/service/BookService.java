package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

public interface BookService {

	void addBook(Book book);
	void updateBook(int bookid, double price)throws IdNotFoundException;
	void deleteBook(int bookid)throws IdNotFoundException;
	Book getBookById(int bookid) throws IdNotFoundException;
	
	List<Book> getAllBooks();
	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;
	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;
	List<Book> getByCatOrTitleOrAuth(String choice);
}
