package com.springRest.Exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppException {
	
	@ExceptionHandler(value = BookNotFoundException.class)
	public String handleException(BookNotFoundException e)
	{
		return e.getMessage();
	}

	@ExceptionHandler(value =MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String,String>> handleMethodArgumentException(MethodArgumentNotValidException e)
	{
		HashMap<String,String> errors=new HashMap<String,String>();
		
		e.getBindingResult().getFieldErrors().forEach(error->
		{
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<HashMap<String,String>>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
