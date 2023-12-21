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

import com.example.restservice.model.Consumer;

@Component
public class ConsumerDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Consumer> login(String email, String password){
		String query = "SELECT * FROM consumer WHERE email = '" + email + "' AND password = '" + password +"'";
	
        return jdbcTemplate.query(query,
        		(rs, rowNum) ->
	        new Consumer(
	        		rs.getInt("user_id"),
	        		rs.getString("email"),
	        		rs.getString("first_name"),
	        		rs.getString("last_name")));
	}
	
	public void createConsumer(Consumer consumer){
        String stmt = "CALL createConsumer('?', '?', '?', '?')";
        
        jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>(){
        	@Override
        	public Boolean doInPreparedStatement(PreparedStatement ps)
	        	throws SQLException, DataAccessException {
	        		ps.setString(1, consumer.getEmail());
	        		ps.setString(2, consumer.getLastname());
	        		ps.setString(3, consumer.getFirstname());
	        		ps.setString(4, consumer.getPassword());
	        		
	        		return ps.execute();
	        	}
        });
	}
}
