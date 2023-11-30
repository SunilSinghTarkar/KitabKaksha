package com.kitabkaksha.service;

import java.util.List;

import com.kitabkaksha.entity.Books;

public interface BookService {
	public Books addBook(Books book);

	public Books getBookById(Integer bookId);

	public List<Books> getAllBook();
}