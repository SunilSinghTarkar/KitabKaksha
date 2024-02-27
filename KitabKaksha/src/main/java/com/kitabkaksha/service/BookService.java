package com.kitabkaksha.service;

import java.util.List;

import com.kitabkaksha.entity.Books;

public interface BookService {
	public Books addBook(Books book);

	public Books getBookById(Integer bookId);

	public String deleteBookById(Integer bookId);

	public List<Books> getAllBook();

	public List<Books> getAllByPublisher();

	public Books updateBook(Integer bookId, Integer quantity, double price);
}
