package com.kitabkaksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitabkaksha.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
