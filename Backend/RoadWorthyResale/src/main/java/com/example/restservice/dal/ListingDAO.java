package com.example.restservice.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.example.restservice.model.Listing;
import com.example.restservice.model.Listing2;

@Component
public class ListingDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Listing2> getRandomListing() {
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.car_id = c.car_id ORDER BY RANDOM() LIMIT 1";
		
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
	}
	
	public List<Listing2>  getAllListings(){
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.car_id = c.car_id ORDER BY posting_date DESC LIMIT 100";
		
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
		
	}
	
	public List<Listing2> get100Random(){
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.car_id = c.car_id ORDER BY RANDOM() LIMIT 100;";
		System.out.println(query);
		
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
	}
	
	
	public List<Listing2> advancedSearchNonLike(String serachBy, String input){
		//search for carType, fuel 
		//"Maybe if i just keep typing, the red will go away" - Shreya Gupta 12:21 am 12/05/2023
		//... TIME ELAPSE
		//"Sometimes less is more" - Shreya Gupta 12:36 am 12/05/2023
		
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.listing_id IN  \r\n"
				+ "	(SELECT listing_id FROM listing WHERE car_id IN \r\n"
				+ "		(SELECT car_id FROM car WHERE "+ serachBy+" = '" + input + "'))\r\n"
				+ "	AND l.car_id = c.car_id;";
	
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
	}
	
	public List<Listing2> advancedSearchLike(String searchBy, String input){	
		//for model, transmission, manufacturer, cylinder, drive, paintColor, carCondition 
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.listing_id IN  \r\n"
				+ "	(SELECT listing_id FROM listing	WHERE car_id IN \r\n"
				+ "	 	(SELECT car_id FROM car WHERE " + searchBy + " LIKE('%" + input + "%')))\r\n"
				+ "	AND l.car_id = c.car_id;";
	
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
	}
	
	public List<Listing2> searchByOdometer(int low, int high){
		//accepts range of odometer readings
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.listing_id IN  \r\n"
				+ "	(SELECT listing_id \r\n"
				+ "	FROM listing WHERE car_id IN \r\n"
				+ "	 	(SELECT car_id FROM car WHERE odometer BETWEEN " + low + " AND " + high + "))\r\n"
				+ "	AND l.car_id = c.car_id;";
	
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
	}
	
	public List<Listing2> searchByPrice(double low, double high){
		//accepts range of odometer readings
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.listing_id IN  \r\n"
				+ "	(SELECT listing_id FROM listing WHERE price BETWEEN " + low + " AND " + high + ") \r\n"
				+ "		AND l.car_id = c.car_id;";
	
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
	}
	
	public List<Listing2> searchByMadeYear(int yearMade){
		
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.listing_id IN  \r\n"
				+ "	(SELECT listing_id FROM listing WHERE car_id IN \r\n"
				+ "	 	(SELECT car_id FROM car WHERE made_year = " + yearMade + "))\r\n"
				+ "	AND l.car_id = c.car_id;";
	
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
	}
	
	public List<Listing2> searchByLocation(String region, String locState){
		
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer FROM listing l, car c WHERE l.listing_id IN  \r\n"
				+ "	(SELECT listing_id FROM listing WHERE car_id IN \r\n"
				+ "	 	(SELECT car_id FROM car WHERE region LIKE ('%" + region+ "%') AND loc_state LIKE ('%" + locState + "%')))\r\n"
				+ "	AND l.car_id = c.car_id;";
	
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
		 new Listing2(
				 	rs.getInt("listing_id"),
	        		rs.getString("car_id"),
	    	        rs.getDouble("price"),
	    	        rs.getString("description"),
	    	        rs.getString("model"),
	    	    	rs.getString("manufacturer")));
	}
	
	
	
	public List<Integer> checkCarID(String carId){
		String query = "SELECT COUNT(*) FROM car WHERE car_id = '" + carId + "';";
        return jdbcTemplate.query(query,
        		(rs, rowNum) ->
        new Integer(
	        		rs.getInt("count")));
	}
	
	public void createListing(Listing listing){
		
		
		
        String stmt = "CALL posting (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>(){
        	@Override
        	public Boolean doInPreparedStatement(PreparedStatement ps)
	        	throws SQLException, DataAccessException {
	        		ps.setInt(1, listing.getUserId());
	        		ps.setString(2, listing.getCarId());
	        		ps.setDouble(3, listing.getPrice());
	        		ps.setString(4, listing.getDescription());
	        		ps.setString(5, listing.getRegion());
	        		ps.setInt(6, listing.getMadeYear());
	        		ps.setString(7, listing.getManufacturer());
	        		ps.setString(8, listing.getModel());
	        		ps.setString(9, listing.getCarCondition());
	        		ps.setString(10, listing.getCylinder());
	        		ps.setString(11, listing.getFuel());
	        		ps.setInt(12, listing.getOdometer());
	        		ps.setString(13, listing.getTitleStatus());
	        		ps.setString(14, listing.getTransmission());
	        		ps.setString(15, listing.getVin());
	        		ps.setString(16, listing.getDrive());
	        		ps.setString(17, listing.getCarType());
	        		ps.setString(18, listing.getPaintColor());
	        		ps.setString(19, listing.getLocState());

	        		
	        		return ps.execute();
	        	}
        });
	}
}
