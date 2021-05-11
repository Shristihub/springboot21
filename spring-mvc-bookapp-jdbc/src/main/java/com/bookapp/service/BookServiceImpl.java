package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.exceptions.AuthorNotFoundException;
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
		bookDAO.updateOneBook(bookid, price);
	}

	@Override
	public void deleteBook(int bookid) throws IdNotFoundException {
		bookDAO.deleteOneBook(bookid);
	}

	@Override
	public Book getBookById(int bookid) throws IdNotFoundException {
		return bookDAO.findById(bookid);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookDAO.findAll();
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		return bookDAO.findByAuthor(author);
	}

	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		return bookDAO.findByCategory(category);
	}

	@Override
	public List<Book> getByCatOrTitleOrAuth(String choice) {
		return bookDAO.findByCatOrTitleOrAuth(choice);
	}

	}
