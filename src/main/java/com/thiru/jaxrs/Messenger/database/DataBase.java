package com.thiru.jaxrs.Messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.thiru.jaxrs.Messenger.models.Message;
import com.thiru.jaxrs.Messenger.models.Profile;

public class DataBase {
	private static Map<Long, Message> messages = new HashMap();
	private static Map<Long, Profile> profiles = new HashMap();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

}
