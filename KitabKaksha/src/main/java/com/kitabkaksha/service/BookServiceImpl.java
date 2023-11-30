package com.kitabkaksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Books;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepo;

	@Override
	public Books addBook(Books book) {
		Books books = bookRepo.save(book);

		return books;
	}

	@Override
	public Books getBookById(Integer bookId) {
		Books book = bookRepo.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found!"));
		return book;
	}

	@Override
	public List<Books> getAllBook() {
		
		return bookRepo.findAll();
	}

}
