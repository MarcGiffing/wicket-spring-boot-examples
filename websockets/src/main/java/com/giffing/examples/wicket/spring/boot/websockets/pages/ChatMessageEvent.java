package com.giffing.examples.wicket.spring.boot.websockets.pages;

import org.apache.wicket.protocol.ws.api.message.IWebSocketPushMessage;

public class ChatMessageEvent implements IWebSocketPushMessage{
	
	private String message;

	public ChatMessageEvent(String message){
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
