package com.kitabkaksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Discussions;
import com.kitabkaksha.repository.DiscussionRepository;

@Service
public class DiscussionServiceImpl implements DiscussionService {
	@Autowired
	private DiscussionRepository discussionRepo;

	@Override
	public Discussions createDiscussion(Discussions discussion) {

		return discussionRepo.save(discussion);
	}

	@Override
	public List<Discussions> getAll() {

		return discussionRepo.findAll();
	}

}
