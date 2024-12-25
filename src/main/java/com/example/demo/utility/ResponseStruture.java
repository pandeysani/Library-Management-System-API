package com.example.demo.utility;

public class ResponseStruture<T> {
	
	private int statusCode;
	private String message;
	private T book; // can use data
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getBook() {
		return book;
	}
	public void setBook(T book) {
		this.book = book;
	}

}
