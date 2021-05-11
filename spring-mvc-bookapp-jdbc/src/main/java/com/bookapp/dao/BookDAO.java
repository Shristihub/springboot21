package com.bookapp.dao;

import java.util.List;

import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

public interface BookDAO {
	void addOneBook(Book book);
	void updateOneBook(int bookid, double price)throws IdNotFoundException;
	void deleteOneBook(int bookid)throws IdNotFoundException;
	Book findById(int bookid) throws IdNotFoundException;
	
	List<Book> findAll();
	List<Book> findByAuthor(String author) throws AuthorNotFoundException;
	List<Book> findByCategory(String category) throws CategoryNotFoundException;
	List<Book> findByCatOrTitleOrAuth(String choice);

}
