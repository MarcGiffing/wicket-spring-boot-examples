package com.giffing.examples.wicket.spring.boot.simple;

import java.util.Date;

import org.apache.wicket.protocol.ws.api.message.IWebSocketPushMessage;

public class DateEvent implements IWebSocketPushMessage {
	
	private Date currentDate;

	public DateEvent(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
}
