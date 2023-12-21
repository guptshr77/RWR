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

import com.example.restservice.model.Bookmark;
import com.example.restservice.model.Consumer;
import com.example.restservice.model.Likes;
import com.example.restservice.model.Listing2;
import com.example.restservice.model.RwrMessage;

@Component
public class OtherActionsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void purchase(int listingId){
        String stmt = "CALL purchase(?)";
        
        jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>(){
        	@Override
        	public Boolean doInPreparedStatement(PreparedStatement ps)
	        	throws SQLException, DataAccessException {
	        		ps.setInt(1, listingId);
	        		
	        		return ps.execute();
	        	}
        });
	}
	
	public void addBookmark(Bookmark bookmark){
        String stmt = "CALL addBookmark(?,?)";
        
        jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>(){
        	@Override
        	public Boolean doInPreparedStatement(PreparedStatement ps)
	        	throws SQLException, DataAccessException {
	        		ps.setInt(1, bookmark.getUserId());
	        		ps.setInt(2, bookmark.getListingId());
	        		
	        		return ps.execute();
	        	}
        });
	}
	
	public List<Listing2> getBookmarks(int userId){
		//accepts range of odometer readings
		String query = "SELECT l.listing_id, c.car_id, l.price, l.description, c.model, c.manufacturer \r\n"
				+ "FROM listing l, car c \r\n"
				+ "WHERE l.listing_id IN \r\n"
				+ "	(SELECT listing_id FROM bookmark WHERE user_id = " + userId + ")\r\n"
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
	
	public void addLike(Likes like){
        String stmt = "CALL addLike(?,?)";
        
        jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>(){
        	@Override
        	public Boolean doInPreparedStatement(PreparedStatement ps)
	        	throws SQLException, DataAccessException {
	        		ps.setInt(1, like.getUserId());
	        		ps.setString(2, like.getCarId());
	        		
	        		return ps.execute();
	        	}
        });
	}
	
	public void addReport(RwrMessage message){
        String stmt = "CALL addreport(?,?,?)";
        
        jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>(){
        	@Override
        	public Boolean doInPreparedStatement(PreparedStatement ps)
	        	throws SQLException, DataAccessException {
	        		ps.setString(1, message.getContent());
	        		ps.setString(2, message.getSubject());
	        		ps.setInt(3, message.getSenderId());
	        		
	        		return ps.execute();
	        	}
        });
	}
}
