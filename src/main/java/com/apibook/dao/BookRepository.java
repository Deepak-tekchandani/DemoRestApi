package com.apibook.dao;

import org.springframework.data.repository.CrudRepository;

import com.apibook.entities.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity,Integer> {
	 
	public BookEntity findById(int id);
	
	

}
