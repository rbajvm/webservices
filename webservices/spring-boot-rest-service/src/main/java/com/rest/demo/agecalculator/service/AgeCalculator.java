package com.rest.demo.agecalculator.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.rest.demo.agecalculator.DataList;

@Component
public class AgeCalculator {
	public DataList getData(String name, String gender, String dob)
	 {
		DataList dateList =new DataList();
		
		try {
			Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
			
			long duration  = System.currentTimeMillis() - date.getTime();

			long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
			long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
			long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
			long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
			long diffInWeeks=diffInDays/7;
			long diffInMonths=diffInDays/30;
			long diffInyear=diffInDays/365;
			long remainingdays=diffInDays%365;
			long remainingmonth=remainingdays/30;
			
			if(gender.equalsIgnoreCase("m")) {
			
				if(diffInyear<21) {
					dateList.setMinmajor("Minor");
				}
				else {
					dateList.setMinmajor("Major");
				}
			}
			if(gender.equalsIgnoreCase("f")) {
				
				if(diffInyear<18) {
					dateList.setMinmajor("Minor");
				}
				else {
					dateList.setMinmajor("Major");
				}
			}
			dateList.setName(name);
			dateList.setAgeindays(String.valueOf(diffInDays));
			dateList.setAgeinhours(String.valueOf(diffInHours));
			dateList.setAgeinminutes(String.valueOf(diffInMinutes));
			dateList.setAgeinmonths(String.valueOf(diffInMonths));
			dateList.setAgeinyear(String.valueOf(diffInyear)+" Years and "+ String.valueOf(remainingmonth)+" Months");
			dateList.setAgeinweeks(String.valueOf(diffInWeeks));
			dateList.setAgeinseconds(String.valueOf(diffInSeconds));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		return dateList;
	 }
}