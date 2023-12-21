package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.bo.CarBo;
import com.example.restservice.bo.ListingBo;
import com.example.restservice.model.Listing;
import com.example.restservice.model.Listing2;

@RestController
public class ListingController {
	
	@Autowired
	private ListingBo lbo;
	private CarBo cbo;
	
	@CrossOrigin
	@GetMapping("/createposting")
	public String post(@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "carId", defaultValue = "") String carId,
			@RequestParam(value = "price", defaultValue = "") String price,
			@RequestParam(value = "description", defaultValue = "") String description,
			@RequestParam(value = "region", defaultValue = "") String region,
			@RequestParam(value = "madeYear", defaultValue = "") String madeYear,
			@RequestParam(value = "manufacturer", defaultValue = "") String manufacturer,
			@RequestParam(value = "model", defaultValue = "") String model,
			@RequestParam(value = "carCondition", defaultValue = "") String carCondition,
			@RequestParam(value = "cylinder", defaultValue = "") String cylinder,
			@RequestParam(value = "fuel", defaultValue = "") String fuel,
			@RequestParam(value = "odometer", defaultValue = "") String odometer,
			@RequestParam(value = "titleStatus", defaultValue = "") String titleStatus,
			@RequestParam(value = "transmission", defaultValue = "") String transmission,
			@RequestParam(value = "vin", defaultValue = "") String vin,
			@RequestParam(value = "drive", defaultValue = "") String drive,
			@RequestParam(value = "carType", defaultValue = "") String carType,
			@RequestParam(value = "paintColor", defaultValue = "") String paintColor,
			@RequestParam(value = "locState", defaultValue = "") String locState) {
		Listing listing = new Listing(Integer.parseInt(userId), carId, Double.parseDouble(price), description,
				region, Integer.parseInt(madeYear), manufacturer, model, carCondition, cylinder, fuel,
				Integer.parseInt(odometer), titleStatus, transmission, vin, drive, carType,
				paintColor, locState);
		return lbo.createPosting(listing);	
	}
	
	@CrossOrigin
	@GetMapping("/search")
	public List<Listing2> advancedSearch(@RequestParam(value = "searchBy", defaultValue = "") String serachBy,
			@RequestParam(value = "input", defaultValue = "") String input) {
		System.out.println("LOL");
		return lbo.advancedSearch(serachBy, input);
	}
	
	@CrossOrigin
	@GetMapping("/get100random")
	public List<Listing2> get100Random(){
		return lbo.get100Random();
	}
	
	@CrossOrigin
	@GetMapping("/getalllistings")
	public List<Listing2> getAllListings(){
		return lbo.getAllListings();
	}
	
	@CrossOrigin
	@GetMapping("/getrandomlisting")
	public Listing2 getRandomListing(){
		return lbo.getRandomListing();
	}
	
	@CrossOrigin
	@GetMapping("/getallcars")
	public List<Listing2> getAllCars(){
		return cbo.getAllCars();
	}
	
}
