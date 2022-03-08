package com.apibook.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="books")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
	public BookEntity(int bookId, String bookName, Author author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
