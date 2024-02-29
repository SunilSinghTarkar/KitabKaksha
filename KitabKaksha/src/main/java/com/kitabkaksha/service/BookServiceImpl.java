package com.kitabkaksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Books;
import com.kitabkaksha.exception.KitabKakshaException;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.BooksRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepository bookRepo;

	@Override
	public Books addBook(Books book) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String publisher = auth.getName();
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String publisher = auth.getName();
		List<Books> books = bookRepo.findByPublisher(publisher);
		return books;
	}

	@Override
	public Books updateBook(Integer bookId, Integer quantity, double price) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String publisher = auth.getName();
		Books book = getBookById(bookId);
		if (!book.getPublisher().equals(publisher)) {
			throw new KitabKakshaException("Invalid token received!");
		}
		book.setQuantity(quantity);
		book.setPrice(price);

		return bookRepo.save(book);
	}

}
