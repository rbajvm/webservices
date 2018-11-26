package com.agecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapClientApplication.class, args);
	}
/*	
	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			String name = "Ashok";//Default Name
			String gender = "m";
			String dob = "03/07/1989";
		
			AgeCalculatorRequest request = new AgeCalculatorRequest();
			request.setName(name);
			request.setGender(gender);
			request.setDob(dob);
			AgeCalculatorResponse response =(AgeCalculatorResponse) soapConnector.callWebService("http://localhost:8080/service/agecalculator", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Name : "+response.getDataList().getName());
			System.out.println("Year : "+response.getDataList().getAgeinyear());

		};
	}*/
}
