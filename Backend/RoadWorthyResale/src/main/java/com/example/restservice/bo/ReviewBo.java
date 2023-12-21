package com.example.restservice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.dal.ReviewDAO;
import com.example.restservice.model.Review;

@Component 
public class ReviewBo {
	
	@Autowired 
	private ReviewDAO reviewdao;
	
	public List<Review> getReview(int ratedId){
		return reviewdao.getReview(ratedId);
	}
	
	public String addReview(Review review) {
		reviewdao.addReview(review);
		return "Review posted";
	}

}
