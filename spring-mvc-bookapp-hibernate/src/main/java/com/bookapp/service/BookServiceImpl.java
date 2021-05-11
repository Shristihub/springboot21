package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	@Override
	public void addBook(Book book) {
		bookDAO.addOneBook(book);
		
	}

	@Override
	public void updateBook(int bookid, double price) throws IdNotFoundException {
		
		try{
			bookDAO.updateOneBook(bookid, price);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IdNotFoundException("Invalid Id/database error");
		}
	}

	@Override
	public void deleteBook(int bookid) throws IdNotFoundException {
		try{
			bookDAO.deleteOneBook(bookid);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IdNotFoundException("Invalid Id/database error");
		}
		
	}

	@Override
	public Book getBookById(int bookid) throws IdNotFoundException {
		Book book =  bookDAO.findById(bookid);
		if(book==null) {
			throw new IdNotFoundException("Invalid Id...");
		}
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookDAO.findAll();
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		List<Book> bookList =  bookDAO.findByAuthor(author);
		if(bookList.isEmpty()) {
			throw new AuthorNotFoundException("Author not found");
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		List<Book> bookList =  bookDAO.findByCategory(category);
		if(bookList.isEmpty()) {
			throw new CategoryNotFoundException("category not found");
		}
		return bookList;
	}

	@Override
	public List<Book> getByCatOrTitleOrAuth(String choice) {
		List<Book> bookList =  bookDAO.findByCatOrTitleOrAuth(choice);
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("Book not found");
		}
		return bookList;
	}

	}
