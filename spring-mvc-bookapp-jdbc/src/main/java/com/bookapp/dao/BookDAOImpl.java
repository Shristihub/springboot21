/**
 * 
 */
package com.bookapp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

/**
 * @author Shristi
 *
 */
@Repository
public class BookDAOImpl implements BookDAO {
	

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setDatasource(DataSource datasource) {
		jdbcTemplate.setDataSource(datasource);
	}
	@Override
	public void addOneBook(Book book) {
		String sql = "insert into book values(?,?,?,?,?)";
		Object[] bookArray = { book.getBookId(),book.getTitle(),book.getAuthor(),book.getCategory(),book.getPrice() };
		jdbcTemplate.update(sql, bookArray);
	}

	

	@Override
	public void updateOneBook(int bookid, double price) throws IdNotFoundException {
		String sql = "update book set price=? where bookid=?";
		jdbcTemplate.update(sql,price,bookid);

	}

	@Override
	public void deleteOneBook(int bookid) throws IdNotFoundException {
		String sql = "delete from book where bookId=?";
		jdbcTemplate.update(sql, bookid);
	}

	@Override
	public Book findById(int bookid) throws IdNotFoundException {
		String sql = "select * from book where bookid=?";
		BookMapper mapper = new BookMapper();
		Book book = jdbcTemplate.queryForObject(sql, mapper, bookid);
		return book;
	}

	@Override
	public List<Book> findAll() {
		String sql = "select * from book";
		BookMapper mapper = new BookMapper();
		List<Book> bookList = jdbcTemplate.query(sql, mapper);
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) throws AuthorNotFoundException {
		String sql = "select * from book where author=?";
		BookMapper mapper = new BookMapper();
		List<Book> bookList = jdbcTemplate.query(sql,  mapper,author);
		return bookList;
	}

	@Override
	public List<Book> findByCategory(String category) throws CategoryNotFoundException {
		String sql = "select * from book where category=?";
		BookMapper mapper = new BookMapper();
		List<Book> bookList = jdbcTemplate.query(sql, mapper,category);
		return bookList;
	}

	@Override
	public List<Book> findByCatOrTitleOrAuth(String choice) {
		String sql = "select * from book where author=? and category =? or title =? ";
		BookMapper mapper = new BookMapper();
		List<Book> bookList = jdbcTemplate.query(sql, mapper,choice,choice,choice);
		return bookList;
	}

}
