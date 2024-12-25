package com.example.demo.Service;

import org.springframework.http.ResponseEntity;

import com.example.demo.entities.Book;
import com.example.demo.utility.ResponseStruture;

public interface Service {
	
	public 	ResponseEntity<ResponseStruture<Book>> addBook(Book book);

	public ResponseEntity<ResponseStruture<Book>> findBybookId(int bookId);

	public ResponseEntity<ResponseStruture<Book>> updateByBookId(int bookId, Book updatedBook);

	public Book deleteByBookId(int bookId);

}