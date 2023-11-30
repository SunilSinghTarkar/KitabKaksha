package com.kitabkaksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitabkaksha.entity.Reviews;

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {

}
