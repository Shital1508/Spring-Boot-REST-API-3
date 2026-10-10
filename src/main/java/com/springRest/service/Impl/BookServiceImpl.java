package com.springRest.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.BookRepository;
import com.springRest.Exception.BookNotFoundException;
import com.springRest.dto.BookDto;
import com.springRest.entity.Book;
import com.springRest.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public String saveBook(BookDto bookDto) {
		
		Book entity =new Book();
		
		entity.setName(bookDto.getName());
		entity.setPrice(bookDto.getPrice());
		entity.setAuthor(bookDto.getAuthor());
		entity.setQty(bookDto.getQty());
		
		bookRepository.save(entity);
		
		return "Book saved successfully";
	}

	@Override
	public List<Book> getAllBooks() {
		
		List<Book> books = bookRepository.findAll();
		
		return books;
	}

	@Override
	public String updateBookById(Integer id, Book book) {
		
		Optional<Book> byId = bookRepository.findById(id);
		
		
		
		if(byId.isPresent())
		{
			Book existing = byId.get();
			existing.setName(book.getName());
			existing.setPrice(book.getPrice());
			existing.setAuthor(book.getAuthor());
			existing.setQty(book.getQty());
			
			bookRepository.save(existing);
			
			return "book updated successfully";
		}
		
		throw new BookNotFoundException("book not found with id: "+id);
	}

	@Override
	public String deleteBookById(Integer id) {
		
		if(bookRepository.existsById(id))
		{
			bookRepository.deleteById(id);
			return "book deleted successfully";
		}
		
		throw new BookNotFoundException("book not found with id: "+id);
	}

}
