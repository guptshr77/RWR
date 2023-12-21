package com.example.restservice.model;

import java.math.BigDecimal;

public class Listing extends Car {
	int userId;
	String carId;
	double price;
	String description;
	String region;
	int madeYear;
	String manufacturer;
	String model;
	String carCondition;
	String cylinder;
	String fuel;
	int odometer;
	String titleStatus;
	String transmission;
	String vin;
	String drive;
	String carType;
	String paintColor;
	String locState;
	int listingId;
	String postingDate;
	boolean sold;
	
	public Listing(String carId, String region, int madeYear, String manufacturer, String model, String carCondition,
			String cylinder, String fuel, int odometer, String titleStatus, String transmission, String vin,
			String drive, String carType, String paintColor, String locState, boolean sold, int listingId, 
			double price, String description, String postingDate, int userId) {
		
		super(carId, region, madeYear, manufacturer, model, carCondition, cylinder, fuel, odometer, titleStatus, 
				transmission, vin, drive, carType, paintColor, locState, sold);
		this.listingId = listingId;
		this.carId = carId;
		this.price = price;
		this.description = description;
		this.postingDate = postingDate;
		this.userId = userId;
	}
	
	public Listing(int listingId, String carId, double price, String description, String postingDate, int userId, 
			String car_id, String region, int madeYear, String manufacturer, String model, String carCondition, 
			String cylinder, String fuel, int odometer, String titleStatus, String transmission, String vin, String drive, 
			String carType, String paintColor, String locState, boolean sold) {
		
		super(carId, region, madeYear, manufacturer, model, carCondition, cylinder, fuel, odometer, titleStatus, 
				transmission, vin, drive, carType, paintColor, locState, sold);
		
		this.listingId = listingId;
		this.carId = carId;
		this.price = price;
		this.description = description;
		this.postingDate = postingDate;
		this.userId = userId;
	}
	
	public Listing(int userId, String carId, double price, String description,
			String region, int madeYear, String manufacturer, String model, 
			String carCondition, String cylinder, String fuel, int odometer, 
			String titleStatus, String transmission, String vin, String drive, 
			String carType, String paintColor, String locState) {
		
		super(carId, region, madeYear, manufacturer, model, carCondition, cylinder, fuel, odometer, titleStatus, 
				transmission, vin, drive, carType, paintColor, locState);
		
		this.carId = carId;
		this.price = price;
		this.description = description;
		this.userId = userId;
	}

	public Listing(int listingId, String carId, double price, String description, 
			String manufacturer, String model) {
		super(carId, manufacturer, model);
		this.listingId = listingId;
		this.price = price;
		this.description = description;
	}
	public int getListingId() {
		return listingId;
	}

	public void setListingId(int listingId) {
		this.listingId = listingId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getMadeYear() {
		return madeYear;
	}

	public void setMadeYear(int madeYear) {
		this.madeYear = madeYear;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCarCondition() {
		return carCondition;
	}

	public void setCarCondition(String carCondition) {
		this.carCondition = carCondition;
	}

	public String getCylinder() {
		return cylinder;
	}

	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public String getTitleStatus() {
		return titleStatus;
	}

	public void setTitleStatus(String titleStatus) {
		this.titleStatus = titleStatus;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getPaintColor() {
		return paintColor;
	}

	public void setPaintColor(String paintColor) {
		this.paintColor = paintColor;
	}

	public String getLocState() {
		return locState;
	}

	public void setLocState(String locState) {
		this.locState = locState;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}
}
