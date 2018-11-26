package com.agecalculator.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.agecalculator.controller.pojo.AgeCalculator;
import com.agecalculator.stub.AgeCalculatorRequest;
import com.agecalculator.stub.AgeCalculatorResponse;

import net.sf.json.JSONObject;

@Controller
public class SpringController {
	@Autowired
	com.agecalculator.SOAPConnector soapConnector;
	@RequestMapping("/welcome")
	public ModelAndView login(Model model,@ModelAttribute("agecalc") AgeCalculator ageCalculator) {
	
		if(ageCalculator.getDob()!=null &&ageCalculator.getDob()!="" &&ageCalculator.getName()!=null&&ageCalculator.getName()!=""&&ageCalculator.getGender()!=null&&ageCalculator.getGender()!="") {
			AgeCalculatorRequest request = new AgeCalculatorRequest();
			request.setName(ageCalculator.getName());
			request.setGender(ageCalculator.getGender());
			String date;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(ageCalculator.getDob()));
				request.setDob(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}  
			AgeCalculatorResponse response =(AgeCalculatorResponse) soapConnector.callWebService("http://localhost:8080/service/agecalculator", request);
			model.addAttribute("soapresponse",JSONObject.fromObject(response));
		}
		Map<String, String> map =new HashMap<String, String>();
		map.put("f", "Female");
		map.put("m", "Male");
		model.addAttribute("gender", map);
		model.addAttribute("agecalc", new AgeCalculator());
		return new ModelAndView("welcome");
	}
	
	@RequestMapping("/restdemo")
	public ModelAndView restdemo(Model model,@ModelAttribute("agecalc") AgeCalculator ageCalculator) {
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.getForObject(url, responseType)
		Map<String, String> map =new HashMap<String, String>();
		map.put("f", "Female");
		map.put("m", "Male");
		model.addAttribute("gender", map);
		model.addAttribute("agecalc", new AgeCalculator());
		return new ModelAndView("restdemo");

	}	
}
