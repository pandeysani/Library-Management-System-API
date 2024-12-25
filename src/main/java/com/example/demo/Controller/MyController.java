package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.Service;
import com.example.demo.entities.Book;
import com.example.demo.utility.ResponseStruture;

public class MyController {
	@Autowired
	private Service bookService;
	
//	@RequestMapping(value ="/book/addBook", method = RequestMethod.POST)
	@PostMapping("/book/addBook")
	public ResponseEntity<ResponseStruture<Book>> addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
//	@RequestMapping(value ="/books/addBook", method =RequestMethod.GET )
	@GetMapping("/books/BookId")
	public ResponseEntity<ResponseStruture<Book>> findBybookId(@RequestParam int bookId)
	{
		return bookService.findBybookId(bookId);
	}
	
//	@RequestMapping(value ="/books/updateByBookId", method = RequestMethod.PUT)
	@PutMapping("/books/updateByBookId")
	public ResponseEntity<ResponseStruture<Book>> updateByBookId(int bookId, @RequestBody Book updatedBook) {
	
		return bookService.updateByBookId(bookId, updatedBook);
	}
	
//	@RequestMapping(value ="/books/deleteByBookId", method = RequestMethod.DELETE)
	@DeleteMapping("/books/deleteByBookId")
	public Book deleteByBookId(int bookId) {
		return bookService.deleteByBookId(bookId);
		
	}
}
