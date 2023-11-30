package com.kitabkaksha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitabkaksha.entity.Books;
import com.kitabkaksha.service.BookService;
@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/add")
	public Books addBook(@RequestBody Books book) {
		return bookService.addBook(book);
	}

	@GetMapping("/get/{bookId}")
	public Books getBookById(@PathVariable Integer bookId) {
		return bookService.getBookById(bookId);
	}

	@GetMapping("/get")
	public List<Books> getAllBooks() {
		return bookService.getAllBook();
	}

}
