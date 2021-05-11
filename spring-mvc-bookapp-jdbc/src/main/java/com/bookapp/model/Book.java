package com.bookapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private String title;
	private Integer bookId;
	private String author;
	private String category;
	private Double price;
	
}
