package com.agecalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.agecalculator.service.AgeCalculator;
import com.ashok.xml.agecalculator.AgeCalculatorRequest;
import com.ashok.xml.agecalculator.AgeCalculatorResponse;

@Endpoint
public class AgeCalculatorEndpoint {
	private static final String NAMESPACE_URI = "http://www.ashok.com/xml/agecalculator";

	private AgeCalculator AgeCalculator;

	@Autowired
	public AgeCalculatorEndpoint(AgeCalculator ageCalculator) {
		this.AgeCalculator = ageCalculator;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AgeCalculatorRequest")
	@ResponsePayload
	public AgeCalculatorResponse getStudent(@RequestPayload AgeCalculatorRequest request) {
		AgeCalculatorResponse response = new AgeCalculatorResponse();
		response.setDataList(AgeCalculator.getData(request.getName(), request.getGender(), request.getDob()));
		return response;
	}
}