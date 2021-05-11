/**
 * 
 */
package com.bookapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
	SessionFactory factory;

	@Override
	public void addOneBook(Book book) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
	}

	@Override
	public void updateOneBook(int bookid, double price)  {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Book book = session.get(Book.class,bookid);
		book.setPrice(price);
		//no need to call update as we are in persisted state
		tx.commit();
		
	}

	@Override
	public void deleteOneBook(int bookid) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Book book = session.get(Book.class,bookid);
		session.delete(book);
		tx.commit();
	}

	@Override
	public Book findById(int bookid)  {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Book book = session.get(Book.class,bookid);
		tx.commit();
		return book;
	}

	@Override
	public List<Book> findAll() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Book> query = session.createQuery("from Book");
		List<Book> bookList = query.list();
		tx.commit();
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Book> query = session.createQuery("from Book b where b.author like :authorName");
		query.setParameter("authorName", author);
		List<Book> bookList = query.list();
		tx.commit();
		return bookList;	}

	@Override
	public List<Book> findByCategory(String category)  {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Book> query = session.createQuery("from Book b where b.category like :categoryName");
		query.setParameter("authorName", category);
		List<Book> bookList = query.list();
		tx.commit();
		return bookList;
	}

	@Override
	public List<Book> findByCatOrTitleOrAuth(String choice) {
		String lchoice = choice.toLowerCase();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from Book b where lower(b.category) like :categoryName or lower(b.title) like :categoryName or lower(b.author) like :categoryName";
		Query<Book> query = session.createQuery(sql);
		query.setParameter("categoryName", "%"+lchoice+"%");
		List<Book> bookList = query.list();
		tx.commit();
		return bookList;
	}
	
	
	
}
