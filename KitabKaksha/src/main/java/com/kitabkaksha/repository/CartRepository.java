package com.kitabkaksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitabkaksha.entity.Carts;

public interface CartRepository extends JpaRepository<Carts, Integer> {

}
