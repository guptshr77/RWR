package com.example.restservice.model;

public class Bookmark {
	int bookmarkId;
	int listingId;
	int userId;
	String message; 
	
	public Bookmark(int bookmarkId, int listingId, int userId) {
		super();
		this.bookmarkId = bookmarkId;
		this.listingId = listingId;
		this.userId = userId;
	}
	
	public Bookmark(int listingId, int userId) {
		super();
		this.listingId = listingId;
		this.userId = userId;
	}
	public int getBookmarkId() {
		return bookmarkId;
	}
	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}
	public int getListingId() {
		return listingId;
	}
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
