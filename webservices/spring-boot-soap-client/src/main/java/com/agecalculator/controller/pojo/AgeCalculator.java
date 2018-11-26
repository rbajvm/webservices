package com.agecalculator.controller.pojo;

import org.springframework.stereotype.Component;

@Component
public class AgeCalculator {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	private String gender;
	private String dob;
	private String name;
}
