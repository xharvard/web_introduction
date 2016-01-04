package com.xharvard.learning.note03;

import java.util.HashMap;
import java.util.Map;

public class HelloModel {

	private Map<String, String> messages = new HashMap<String, String>();

	public HelloModel() {
		messages.put("xhh", "Hello");
		messages.put("xharvard", "Welcome");
		messages.put("x", "Hi");
	}

	public String doHello(String user) {
		String message = messages.get(user);
		return message + ", " + user + "!";
	}

}
