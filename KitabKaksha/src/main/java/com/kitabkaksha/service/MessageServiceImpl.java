package com.kitabkaksha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Discussions;
import com.kitabkaksha.entity.Messages;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.DiscussionRepository;
import com.kitabkaksha.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private DiscussionRepository discussionRepo;

	@Override
	public Messages writeMessage(Messages message, Integer discussionId) {
		Discussions discussion = discussionRepo.findById(discussionId)
				.orElseThrow(() -> new NotFoundException("Discussion not found!"));
		discussion.getMessages().add(message);
		discussionRepo.save(discussion);
		return message;
	}

}
