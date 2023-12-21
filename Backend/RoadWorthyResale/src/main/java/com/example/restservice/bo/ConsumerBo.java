package com.example.restservice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.dal.ConsumerDAO;
import com.example.restservice.model.Consumer;

@Component
public class ConsumerBo {

	@Autowired
	private ConsumerDAO consumerdao;
	
	public Consumer login(Consumer c){
		List<Consumer> login = consumerdao.login(c.getEmail(), c.getPassword());
		if(login.size() == 1) {
			return login.get(0);
		}else {
			return new Consumer(0, null, null, null);
		}
	}
	
	public String createConsumer(Consumer consumer) {
		consumerdao.createConsumer(consumer);
		return "Account created successfully.";
	}
	
	
}
