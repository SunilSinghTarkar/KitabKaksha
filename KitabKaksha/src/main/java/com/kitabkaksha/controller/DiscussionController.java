package com.kitabkaksha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitabkaksha.entity.Discussions;
import com.kitabkaksha.entity.Messages;
import com.kitabkaksha.service.DiscussionService;
import com.kitabkaksha.service.MessageService;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {
	@Autowired
	private DiscussionService discussionService;
	@Autowired
	private MessageService messageService;

	@PostMapping("/create")
	public Discussions crateDiscussion(@RequestBody Discussions discussion) {
		return discussionService.createDiscussion(discussion);
	}

	@PostMapping("/message/{discussionId}")
	public Messages writeMessage(@RequestBody Messages message , @PathVariable Integer discussionId) {
		return messageService.writeMessage(message,discussionId);
	}
	@GetMapping("/getAll")
	public List<Discussions> getAllDiscussions(){
		return discussionService.getAll();
	}

}
