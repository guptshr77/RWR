package com.example.restservice.model;

public class Car {
	String carId;
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
	boolean sold;
	
	public Car(String carId, String region, int madeYear, String manufacturer, String model, String carCondition,
			String cylinder, String fuel, int odometer, String titleStatus, String transmission, String vin,
			String drive, String carType, String paintColor, String locState, boolean sold) {
		this.carId = carId;
		this.region = region;
		this.madeYear = madeYear;
		this.manufacturer = manufacturer;
		this.model = model;
		this.carCondition = carCondition;
		this.cylinder = cylinder;
		this.fuel = fuel;
		this.odometer = odometer;
		this.titleStatus = titleStatus;
		this.transmission = transmission;
		this.vin = vin;
		this.drive = drive;
		this.carType = carType;
		this.paintColor = paintColor;
		this.locState = locState;
		this.sold = sold;
	}
	
	public Car(String carId, String region, int madeYear, String manufacturer, String model, String carCondition, 
			String cylinder, String fuel, int odometer, String titleStatus, String transmission, String vin, 
			String drive, String carType, String paintColor, String locState) {

		this.carId = carId;
		this.region = region;
		this.madeYear = madeYear;
		this.manufacturer = manufacturer;
		this.model = model;
		this.carCondition = carCondition;
		this.cylinder = cylinder;
		this.fuel = fuel;
		this.odometer = odometer;
		this.titleStatus = titleStatus;
		this.transmission = transmission;
		this.vin = vin;
		this.drive = drive;
		this.carType = carType;
		this.paintColor = paintColor;
		this.locState = locState;
	}

	public Car(String carId, String manufacturer, String model) {
		this.carId = carId;
		this.manufacturer = manufacturer;
		this.model = model;
		
	}
	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
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
