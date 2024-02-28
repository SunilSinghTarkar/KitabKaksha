package com.kitabkaksha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitabkaksha.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	List<Books> findByPublisher(String publisher);

}
