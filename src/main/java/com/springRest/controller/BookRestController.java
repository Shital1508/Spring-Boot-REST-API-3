package com.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.dto.BookDto;
import com.springRest.entity.Book;
import com.springRest.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class BookRestController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveBook(@Valid @RequestBody BookDto bookDto)
	{
		String msg = bookService.saveBook(bookDto);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> Books = bookService.getAllBooks();
		
		return new ResponseEntity<List<Book>>(Books,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateBookById(@PathVariable int id, @RequestBody Book book)
	{
		String msg = bookService.updateBookById(id, book);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		String msg = bookService.deleteBookById(id);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	

}
