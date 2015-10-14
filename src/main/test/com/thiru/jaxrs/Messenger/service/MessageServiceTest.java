package com.thiru.jaxrs.Messenger.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.thiru.jaxrs.Messenger.models.Message;

import junit.framework.TestCase;

public class MessageServiceTest extends TestCase {

	private MessageService messageService  = new MessageService();

	@Test
	public void testGetAllMessages() {
		List<Message> allMessages = messageService.getAllMessages();		
		assertEquals(2, allMessages.size());
	}

	public void testGetMessage() {
		Message message = messageService.getMessage(2L);
		assertEquals("Thiru",message.getAuthor());
	}

	public void testAddMessage() {
		Message newMsg = messageService.addMessage(getNewMessage());
		assertEquals("Jane", newMsg.getAuthor());
		assertEquals("Hi John Doe", newMsg.getMessage());
		assertNotNull(newMsg);
		assertNotNull(newMsg.getId());
		assertEquals(3, messageService.getAllMessages().size());
	}

	public void testUpdateMessage() {
		Message message = messageService.getMessage(1L);
		message.setAuthor("Thiru");
		Message updateMessage = messageService.updateMessage(message);
		assertEquals("Thiru", updateMessage.getAuthor());
		message.setAuthor("Aish");
		messageService.updateMessage(message);
	}

	public void testRemoveMessage() {
		messageService.removeMessage(3L);
		assertEquals(2, messageService.getAllMessages().size());
	}
	
	public Message getNewMessage() {
		Message newMsg = new Message();
		newMsg.setAuthor("Jane");
		newMsg.setCreated(new Date());
		newMsg.setMessage("Hi John Doe");
		return newMsg;
	}

}
