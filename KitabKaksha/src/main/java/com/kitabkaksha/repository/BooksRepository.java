package com.kitabkaksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitabkaksha.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

}
