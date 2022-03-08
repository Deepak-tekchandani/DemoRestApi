package com.apibook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apibook.dao.BookRepository;
import com.apibook.entities.BookEntity;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	// this this for postman before jap
//	public static List<BookEntity> list =new ArrayList();
//	
//	static {
//		
//		list.add(new BookEntity(2,"javaEE","A"));
//		list.add(new BookEntity(3,"php","B"));
//		list.add(new BookEntity(4,"Python","C"));
//	}
	
	//get All Book
	public List<BookEntity> getAllBooks() {
		List<BookEntity> list =(List<BookEntity>)this.bookRepository.findAll();
		return list;		
	}
	
	//get Single Book by id
	public BookEntity getBookById(int id) {
		
		BookEntity bookEntity=null;
		try {
			// this this for postman before jap
		//bookEntity=list.stream().filter(e->e.getBookId()==id).findFirst().get();
			bookEntity =this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookEntity;
	}
	
	//adding Book
	public BookEntity addBook(BookEntity bookEntity) {
		// this this for postman before jap
		//list.add(b);
		BookEntity result= bookRepository.save(bookEntity);
		return result;
	}
	
	//Delete Book
	public void deleteBook(int id) {
			//// this this for postman before jap
		//list=list.stream().filter(book->book.getBookId()!=id).collect(Collectors.toList());
		bookRepository.deleteById(id);
	}
	
	//update Book
	public BookEntity updateBook(BookEntity book, int id) {
		// this this for postman before jap
//		list=list.stream().map(b->{
//			if(b.getBookId()==id) {
//				b.setBookName(book.getBookName());
//				b.setAuthor(book.getAuthor());
//			}
//			
//			return b;
//		}).collect(Collectors.toList());
		
			if(book.getBookId()==id) {
				book.setBookId(id);
			
				book.setBookName(book.getBookName());
				book.setAuthor(book.getAuthor());
			}
			bookRepository.save(book);
		return book;
	}

}
