package com.example.restservice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.dal.ListingDAO;
import com.example.restservice.model.Listing;
import com.example.restservice.model.Listing2;


@Component
public class ListingBo {

	@Autowired
	private ListingDAO listingdao;
	
	public String createPosting(Listing listing) {
		List<Integer> numCars = listingdao.checkCarID(listing.getCarId());
		if (numCars.get(0) == 0) {
			listingdao.createListing(listing);
			return "Car successfully posted.";
		}else {
			return "Please pick a different car id. Your current car id has already been taken";
		}
	}
	
	public List<Listing2> advancedSearch(String searchBy, String input){
		//Figure out which kind of search it is and call the corresponding method 
		List<Listing2> listings;
			
			if (searchBy.equals("carType") || searchBy.equals("fuel")) { //Non Like Search
				listings = listingdao.advancedSearchNonLike(searchBy, input);
			}else if (searchBy.equals("model") || searchBy.equals("transmission") || searchBy.equals("manufacturer")||
					searchBy.equals("cylinder") || searchBy.equals("drive") || searchBy.equals("paint_color") 
					|| searchBy.equals("car_condition")) { //Like Search
				listings = listingdao.advancedSearchLike(searchBy, input);
			}else if (searchBy.equals("odometer")) { //Odometer Search
				int odometer = Integer.parseInt(input);
				int low = odometer - 10000;
				int high = odometer + 10000;
				listings = listingdao.searchByOdometer(low, high);
			}else if (searchBy.equals("yearMade")) { // Year Made Search
				int year = Integer.parseInt(input);
				listings = listingdao.searchByMadeYear(year);
			}else if (searchBy.equals("price")){
				double price = Double.parseDouble(input);
				double low = price - 10000;
				double high = price + 10000;
				listings = listingdao.searchByPrice(low, high);
			}else { //Other
				System.out.println("Incorrect input");
				listings = null;
			}
			
		return listings;
	}
	
	public List<Listing2> get100Random(){
		return listingdao.get100Random();
	}
	
	public List<Listing2> getAllListings(){
		return listingdao.getAllListings();
	}
	
	public Listing2 getRandomListing() {
		Listing2 listing = (listingdao.getRandomListing()).get(0);
		System.out.println(listing.getCarId());
		return listing;
		
	}
}
