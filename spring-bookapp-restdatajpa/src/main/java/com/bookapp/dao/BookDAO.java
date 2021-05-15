package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer>{
	
	// query by properties
	//	getBy,findbyPropertyName
	   
	   List<Book> findByCategory(String category);
	   List<Book> findByAuthor(String author);
//	   search for whole word
//	   List<Book> findByAuthorOrCategoryOrTitle(String choice,String choice1,String choice2);
	   
	   //custom queries - serach for any letter
	   @Query("from Book b where b.author like :choice Or b.category like :choice Or b.title like :choice")
	   List<Book> findByCatOrTitleOrAuth(String choice);
	   
	   
	   
	
}
