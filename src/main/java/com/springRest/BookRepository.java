package com.springRest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRest.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
