package com.apibook.controler;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apibook.entities.BookEntity;
import com.apibook.service.BookService;

@RestController
public class BookControler {
	
	@Autowired 
	private BookService bookService;
	private BookService bookServices;
	
	//get all Book Handler
	@GetMapping("/books")
	//public List<BookEntity> getBooks() {
	public ResponseEntity<List<BookEntity>> getBooks() {
//		BookEntity bookEntity = new BookEntity();
//		bookEntity.setBookId(1);
//		bookEntity.setBookName("java");
//		bookEntity.setAuthor("john");
		//return bookService.getAllBook();
		List<BookEntity> list =  bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//get single book handler
	@GetMapping("/books/{id}")
	// or public BookEntity getBook(@PathVariable("id") int id ) {
	public ResponseEntity<BookEntity> getBook(@PathVariable("id") int id ) {
		
		//return bookService.getBookById(id);
		BookEntity bookEntity = bookService.getBookById(id);
		if(bookEntity==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bookEntity));
	}
	
	//add book
	@PostMapping("/books")
	//public BookEntity addBook(@RequestBody BookEntity bookEntity) {
	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity bookEntity) {
		BookEntity book=null;
		
		try {
			book= this.bookService.addBook(bookEntity);
			System.out.println(bookEntity);
			return ResponseEntity.of(Optional.of(book));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
	@DeleteMapping("/books/{id}")
	//public void deleteBook(@PathVariable("id") int id ) {
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id ) {		
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		
		
	}
	
	@PutMapping("/books/{id}")
	//public BookEntity updateBook(@RequestBody BookEntity book,@PathVariable("id") int id ) {
	public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity bookEntity,@PathVariable("id") int id ) {
		
		try {
			this.bookService.updateBook(bookEntity,id);
			return ResponseEntity.ok().body(bookEntity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
