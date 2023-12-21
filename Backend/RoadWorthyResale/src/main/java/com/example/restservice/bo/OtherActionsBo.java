package com.example.restservice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.dal.OtherActionsDAO;
import com.example.restservice.model.Bookmark;
import com.example.restservice.model.Likes;
import com.example.restservice.model.Listing2;
import com.example.restservice.model.RwrMessage;

@Component 
public class OtherActionsBo {
	
	@Autowired
	private OtherActionsDAO oadao;
	
	public String purchase(int listingId) {
		oadao.purchase(listingId);
		return "Car Successfully bought. Please contact the seller for a reciept.";
	}
	
	public List<Listing2> getBookmarks(int uid){
		return oadao.getBookmarks(uid);
	}
	
	public Bookmark bookmark(Bookmark bookmark) {
		oadao.addBookmark(bookmark);
		bookmark.setMessage("Car added to your bookmarks");
		return bookmark;
	}
	
	public String addLike(Likes like) {
		oadao.addLike(like);
		return "Car liked!";
	}
	
	public String report(RwrMessage message) {
		oadao.addReport(message);
		return "Message sent";
	}

}
