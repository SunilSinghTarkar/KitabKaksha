package com.kitabkaksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitabkaksha.entity.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {

}
