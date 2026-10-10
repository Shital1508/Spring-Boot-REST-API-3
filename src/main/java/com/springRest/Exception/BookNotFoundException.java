package com.springRest.Exception;

public class BookNotFoundException extends RuntimeException {
	
	public BookNotFoundException(String msg) {
		
		super(msg);
		
	}

}
