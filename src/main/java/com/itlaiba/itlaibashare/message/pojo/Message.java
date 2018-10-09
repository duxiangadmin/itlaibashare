package com.itlaiba.itlaibashare.message.pojo;

import java.text.ParseException;
import java.util.Date;

public class Message extends MessageKey {
    private String messageUser;

    private String messageTitle;

    private String messageContent;
    
    private String messageTime;
    
    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser == null ? null : messageUser.trim();
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

	public String getMessageTime() throws ParseException {
		return messageTime;
	}

	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
    
}