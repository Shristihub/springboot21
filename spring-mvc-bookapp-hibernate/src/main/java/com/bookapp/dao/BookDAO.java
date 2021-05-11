package com.bookapp.dao;

import java.util.List;

import com.bookapp.model.Book;

public interface BookDAO {
	void addOneBook(Book book);
	void updateOneBook(int bookid, double price);
	void deleteOneBook(int bookid);
	Book findById(int bookid);
	
	List<Book> findAll();
	List<Book> findByAuthor(String author) ;
	List<Book> findByCategory(String category) ;
	List<Book> findByCatOrTitleOrAuth(String choice);

}
