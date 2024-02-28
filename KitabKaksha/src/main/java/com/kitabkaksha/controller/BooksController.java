package com.kitabkaksha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitabkaksha.entity.Books;
import com.kitabkaksha.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<Books> addBook(@RequestBody Books book) {
		log.info("Inside BookController's addBook method");
		Books savedBook = bookService.addBook(book);
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<Books> getBookById(@PathVariable Integer bookId) {
		Books book = bookService.getBookById(bookId);
		return new ResponseEntity<Books>(book, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Books>> getAllBooks() {
		List<Books> bookList = bookService.getAllBook();
		return new ResponseEntity<List<Books>>(bookList, HttpStatus.OK);
	}

	@GetMapping("/publishers")
	public ResponseEntity<List<Books>> getBooksByPublisher() {
		List<Books> bookList = bookService.getAllByPublisher();
		return new ResponseEntity<List<Books>>(bookList, HttpStatus.OK);
	}

	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer bookId) {
		String message = bookService.deleteBookById(bookId);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}
}
