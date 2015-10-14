package com.thiru.jaxrs.Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.thiru.jaxrs.Messenger.database.DataBase;
import com.thiru.jaxrs.Messenger.models.Message;

public class MessageService {

	private Map<Long, Message> messages = DataBase.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello Thiru", "Aish"));
		messages.put(2L, new Message(2, "Hello Aish", "Thiru"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long msgId) {
		return messages.get(msgId);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if(message.getId() <=0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long msgId) {
		return messages.remove(msgId);
	}
}
