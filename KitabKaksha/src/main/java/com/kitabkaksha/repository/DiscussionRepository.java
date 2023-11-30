package com.kitabkaksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitabkaksha.entity.Discussions;

public interface DiscussionRepository extends JpaRepository<Discussions, Integer> {

}
