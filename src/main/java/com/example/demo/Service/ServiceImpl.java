package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entities.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.utility.ResponseStruture;



@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public ResponseEntity<ResponseStruture<Book>> addBook(Book book) {
		Book book2 = bookRepository.save(book);
		ResponseStruture<Book> responseStructure = new ResponseStruture<Book>();
		responseStructure.setMessage("Book Object created successfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value()); // for body
		responseStructure.setBook(book2);

//		return new ResponseEntity<Actor>(book,HttpStatus.CREATED); // it will provide the status code (HTTP code)
				
		return new ResponseEntity<ResponseStruture<Book>>(responseStructure, HttpStatus.CREATED); //for header
	}

	@Override
	public ResponseEntity<ResponseStruture<Book>> findBybookId(int bookId) {
		
		Optional<Book> optional = bookRepository.findById(bookId);
		
		if(optional.isPresent())
		{
			Book book =optional.get();
			ResponseStruture<Book> responseStructure = new ResponseStruture<Book>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Book object found Successfully");
			responseStructure.setBook(book);
			return new ResponseEntity<ResponseStruture<Book>>(responseStructure, HttpStatus.FOUND);
		}
		
		else
		{
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStruture<Book>> updateByBookId(int bookId, Book updatedBook) {
		Optional <Book> optional = bookRepository.findById(bookId);
		
		if(optional.isPresent())
		{
			Book book = optional.get();
			Book existingBook = optional.get();
			updatedBook.setBookID(existingBook.getBookID());
			Book up =bookRepository.save(updatedBook);
			ResponseStruture<Book> responseStructure = new ResponseStruture<Book>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Book object updated Successfully");
			responseStructure.setBook(up);
			return new ResponseEntity<ResponseStruture<Book>>(responseStructure, HttpStatus.FOUND);
		}
		else
		return null;
	}

	@Override
	public Book deleteByBookId(int bookId) {
		Optional<Book> optional = bookRepository.findById(bookId);
		
		
		if(optional.isPresent())
		{
			Book book =optional.get();
			bookRepository.delete(book);
			return book;
		}
		
		else
		{
			return null;
		}
	}
	
	

}
