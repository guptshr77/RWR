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

import com.example.restservice.model.Car;
import com.example.restservice.model.Listing;
import com.example.restservice.model.Listing2;


@Component
public class CarDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Listing2> getAllCars(){
		String query = "SELECT * FROM car;";
		
		return jdbcTemplate.query(query, 
				(rs, rowNum) ->
			new Listing2(
					rs.getString("car_id"),
					rs.getString("region"),
					rs.getInt("made_year"),
					rs.getString("manufacturer"),
					rs.getString("model"),
					rs.getString("car_condition"),
					rs.getString("cylinder"),
					rs.getString("fuel"),
					rs.getInt("odometer"),
					rs.getString("title_status"),
					rs.getString("transmission"),
					rs.getString("vin"),
					rs.getString("drive"),
					rs.getString("car_type"),
					rs.getString("paint_color"),
					rs.getString("loc_state"),
					rs.getBoolean("sold")));
	}
		
}
