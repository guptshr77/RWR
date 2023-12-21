package com.example.restservice.model;

public class RwrMessage {
	int messageId;
	String content;
	String subject;
	String resolved;
	int senderId;
	public RwrMessage(int messageId, String content, String subject, String resolved, int senderId) {
		super();
		this.messageId = messageId;
		this.content = content;
		this.subject = subject;
		this.resolved = resolved;
		this.senderId = senderId;
	}
	
	public RwrMessage(String content, String subject, int senderId) {
		super();
		this.content = content;
		this.subject = subject;
		this.senderId = senderId;
	}
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
}
