package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.bo.ReviewBo;
import com.example.restservice.model.Review;

@RestController
public class ReviewController {

	@Autowired
	private ReviewBo rbo;
	
	@GetMapping("/getreview")
	public List<Review> getReview(@RequestParam(value = "userId", defaultValue = "") String userId){
		return rbo.getReview(Integer.parseInt(userId));
	}
	
	@GetMapping("/addreview")
	public String addReview(@RequestParam(value = "ratedId", defaultValue = "") String ratedId,
			@RequestParam(value = "raterId", defaultValue = "") String raterId,
			@RequestParam(value = "raterComment", defaultValue = "") String raterComment,
			@RequestParam(value = "starValue", defaultValue = "") String starValue) {
		Review review = new Review(Integer.parseInt(ratedId), Integer.parseInt(raterId), 
				raterComment, Integer.parseInt(starValue));
		return rbo.addReview(review);
	}
}
