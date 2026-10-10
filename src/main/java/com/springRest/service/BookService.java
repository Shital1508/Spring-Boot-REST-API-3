package com.springRest.service;

import java.util.List;

import com.springRest.dto.BookDto;
import com.springRest.entity.Book;

public interface BookService {

	String saveBook(BookDto bookDto);
	
	List<Book> getAllBooks();
	
	String updateBookById(Integer id, Book book);
	
	String deleteBookById(Integer id);
	
	
	
}
