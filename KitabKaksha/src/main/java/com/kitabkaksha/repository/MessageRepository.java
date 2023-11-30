package com.kitabkaksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitabkaksha.entity.Messages;

public interface MessageRepository extends JpaRepository<Messages, Integer> {

}
