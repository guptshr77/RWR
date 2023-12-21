package com.example.restservice.model;

public class Likes {
	String carId;
	int userId;
	public Likes(String carId, int userId) {
		super();
		this.carId = carId;
		this.userId = userId;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
