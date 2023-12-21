package com.example.restservice;

import java.util.List;
import org.json.JSONObject;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.bo.ConsumerBo;
import com.example.restservice.model.Consumer;

@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerBo cbo;
	
	@CrossOrigin
	@GetMapping("/login")
	public Consumer oldlogin(@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password){
		Consumer c = (cbo.login(new Consumer(email, password)));
		return c;
	}
	
	@CrossOrigin
	@PostMapping("/login2")
	public String login(@RequestBody() String body){
		JSONObject json = new JSONObject(body);
		if(body != null) {
			System.out.println(body);
			return  body;
		}
		else {
			return "404";
		}
	}
		
	@GetMapping("/addconsumer")
	public String addConsumer(@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "firstname", defaultValue = "") String firstname,
			@RequestParam(value = "lastname", defaultValue = "") String lastname,
			@RequestParam(value = "password", defaultValue = "") String password) {
		return cbo.createConsumer(new Consumer(email, firstname, lastname, password));
	}
}
