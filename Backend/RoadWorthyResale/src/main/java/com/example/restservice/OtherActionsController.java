package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.bo.OtherActionsBo;
import com.example.restservice.model.Bookmark;
import com.example.restservice.model.Likes;
import com.example.restservice.model.Listing2;
import com.example.restservice.model.RwrMessage;

@RestController
public class OtherActionsController {

	@Autowired
	private OtherActionsBo oabo;
	
	@GetMapping("/purchase")
	public String purchase(@RequestParam(value = "listingId", defaultValue = "") String listingId) {
		return oabo.purchase(Integer.parseInt(listingId));
	}
	
	@CrossOrigin
	@GetMapping("/bookmark")
	public Bookmark bookmark(@RequestParam(value = "listingId", defaultValue = "") String listingId,
			@RequestParam(value = "userId", defaultValue = "") String userId) {
		//~look at meeeee, I would never passs~ "Integer.parseInt()""
		Bookmark bm = new Bookmark(Integer.parseInt(listingId), Integer.parseInt(userId));
		Bookmark b = oabo.bookmark(bm);
		System.out.println(b.getMessage());
		return b;
	}
	
	@CrossOrigin
	@GetMapping("/getbookmark")
	public List<Listing2> getBookmark(@RequestParam(value = "userId", defaultValue = "") String userId) {
		//~look at meeeee, I would never passs~ "Integer.parseInt()""
		return oabo.getBookmarks(Integer.parseInt(userId));
	}
	
	
	@GetMapping("/addlike")
	public String addLike(@RequestParam(value = "carId", defaultValue = "") String carId,
			@RequestParam(value = "userId", defaultValue = "") String userId) {
		Likes like = new Likes(carId, Integer.parseInt(userId));
		return oabo.addLike(like);
	}
	
	@CrossOrigin
	@GetMapping("/report")
	public String report(@RequestParam(value = "content", defaultValue = "") String content,
			@RequestParam(value = "subject", defaultValue = "") String subject,
			@RequestParam(value = "senderId", defaultValue = "") String senderId) {
		RwrMessage report = new RwrMessage(content, subject, Integer.parseInt(senderId));
		return oabo.report(report);
	}
}
