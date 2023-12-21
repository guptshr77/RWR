package com.example.restservice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.dal.CarDAO;
import com.example.restservice.model.Listing2;

@Component
public class CarBo {

	@Autowired
	private CarDAO cardao;
	
	public List<Listing2> getAllCars(){
		return cardao.getAllCars();
	}
}
