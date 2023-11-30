package com.kitabkaksha.service;

import com.kitabkaksha.entity.Messages;

public interface MessageService {
	public Messages writeMessage(Messages message,Integer discussionId);
}
