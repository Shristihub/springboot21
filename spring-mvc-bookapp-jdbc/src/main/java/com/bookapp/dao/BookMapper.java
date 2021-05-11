package com.bookapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bookapp.model.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

		String title = rs.getString("title");
		String author = rs.getString("author");
		String category = rs.getString("category");
		int bookId = rs.getInt("bookid");
		double price = rs.getDouble("price");
		Book book = new Book(title,bookId,author,category,price);
		return book;
	}

}
