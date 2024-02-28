package com.kitabkaksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Books;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.BooksRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepository bookRepo;

	@Override
	public Books addBook(Books book) {
		String publisher = "sunil@gmail.com";
		book.setPublisher(publisher);
		Books books = bookRepo.save(book);

		return books;
	}

	@Override
	public Books getBookById(Integer bookId) {
		Books book = bookRepo.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found!"));
		return book;
	}

	@Override
	public String deleteBookById(Integer bookId) {
		Books book = getBookById(bookId);
		bookRepo.delete(book);
		return "Book Deleted";
	}

	@Override
	public List<Books> getAllBook() {

		return bookRepo.findAll();
	}

	@Override
	public List<Books> getAllByPublisher() {
		String publisher = "sunil@gmail.com";
		List<Books> books = bookRepo.findByPublisher(publisher);
		return books;
	}

	@Override
	public Books updateBook(Integer bookId, Integer quantity, double price) {
		Books book = getBookById(bookId);

		book.setQuantity(quantity);
		book.setPrice(price);

		return bookRepo.save(book);
	}

}
