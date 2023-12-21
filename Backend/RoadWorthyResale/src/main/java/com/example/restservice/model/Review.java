package com.example.restservice.model;

public class Review {
	int ratingId;
	int ratedId;
	int raterId;
	String raterComment;
	int starValue;
	double averageStars;
	String firstName, lastname;
	
	public Review(int ratingId, int ratedId, int raterId, String raterComment, int starValue) {
		super();
		this.ratingId = ratingId;
		this.ratedId = ratedId;
		this.raterId = raterId;
		this.raterComment = raterComment;
		this.starValue = starValue;
	}
	public Review(int ratedId, int raterId, String raterComment, int starValue) {
		super();
		this.ratedId = ratedId;
		this.raterId = raterId;
		this.raterComment = raterComment;
		this.starValue = starValue;
	}
	
	public Review(String firstName, String lastName, int ratedId, String raterComment, double averageStars) {
		this.firstName = firstName;
		this.lastname = lastName;
		this.ratedId = ratedId;
		this.raterComment = raterComment;
		this.averageStars = averageStars;
	}
	
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getRatedId() {
		return ratedId;
	}
	public void setRatedId(int ratedId) {
		this.ratedId = ratedId;
	}
	public int getRaterId() {
		return raterId;
	}
	public void setRaterId(int raterId) {
		this.raterId = raterId;
	}
	public String getRaterComment() {
		return raterComment;
	}
	public void setRaterComment(String raterComment) {
		this.raterComment = raterComment;
	}
	public int getStarValue() {
		return starValue;
	}
	public void setStarValue(int starValue) {
		this.starValue = starValue;
	}
}
