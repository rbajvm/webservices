package com.rest.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.agecalculator.service.AgeCalculator;

import net.sf.json.JSONObject;

@RestController
public class Controller {

	@Autowired
	AgeCalculator agecalculator;
	@CrossOrigin(origins = "http://localhost:8585")
	@RequestMapping(value = "/rest/api/agecalculator")
	public JSONObject getData(@RequestBody JSONObject input)
			throws IOException, ClassNotFoundException, SQLException, ParseException {
				
		String name=input.getString("name");
		String gender=input.getString("gender");
		String dob=input.getString("dob");
		JSONObject json = JSONObject.fromObject(agecalculator.getData(name, gender, new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(dob))));
		return json;
		
	}
	
}
