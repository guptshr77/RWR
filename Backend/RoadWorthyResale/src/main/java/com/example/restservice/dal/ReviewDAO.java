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

import com.example.restservice.model.Review;

@Component
public class ReviewDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Review> getReview(int ratedId){
		String query = "SELECT c.first_name, c.last_name, r.rated_id, r.rater_comment, ROUND(AVG(r.star_value), 2) AS average_star_value \r\n"
				+ "FROM reviews r \r\n"
				+ "	JOIN consumer c \r\n"
				+ "		ON r.rater_id = c.user_id \r\n"
				+ "WHERE r.rated_id = " + ratedId + " \r\n"
				+ "GROUP BY c.first_name, c.last_name, r.rated_id, r.rater_comment;";
	
        return jdbcTemplate.query(query,
        		(rs, rowNum) ->
	        new Review(
	        		rs.getString("first_name"),
	        		rs.getString("last_name"),
	        		rs.getInt("rated_id"),
	        		rs.getString("rater_comment"),
	        		rs.getDouble("average_star_value")));
	}
	
	public void addReview(Review review){
        String stmt = "CALL addReview(?,?,?,?)";
        
        jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>(){
        	@Override
        	public Boolean doInPreparedStatement(PreparedStatement ps)
	        	throws SQLException, DataAccessException {
	        		ps.setInt(1, review.getRaterId());
	        		ps.setInt(2, review.getRatedId());
	        		ps.setString(3, review.getRaterComment());
	        		ps.setDouble(4, review.getStarValue());
	        		
	        		return ps.execute();
	        	}
        });
	}
}
