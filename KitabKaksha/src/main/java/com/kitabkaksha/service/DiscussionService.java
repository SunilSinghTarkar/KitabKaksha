package com.kitabkaksha.service;

import java.util.List;

import com.kitabkaksha.entity.Discussions;

public interface DiscussionService {
 public Discussions createDiscussion(Discussions discussion);
 
 public List<Discussions> getAll();


}

