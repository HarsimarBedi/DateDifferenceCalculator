package com.auspost.datedifferencecalculator.service;

import org.springframework.stereotype.Service;

import com.auspost.datedifferencecalculator.model.DateInput;
import com.auspost.datedifferencecalculator.model.DateOutput;
import com.auspost.datedifferencecalculator.util.DateUtils;

@Service
public class DateService {
	
	public DateOutput calculateDateDifference(DateInput dateInput) {
		String date1 = dateInput.getDate1();
		String date2 = dateInput.getDate2();
		
		String[] partsDate1 = date1.split(" ");
		String[] partsDate2 = date2.split(" ");
		
		//Splitting and parsing dates from string to int
		int day1 = Integer.parseInt(partsDate1[0]);
		int month1 = Integer.parseInt(partsDate1[1]);
		int year1 = Integer.parseInt(partsDate1[2]);
		
		int day2 = Integer.parseInt(partsDate2[0]);
		int month2 = Integer.parseInt(partsDate2[1]);
		int year2 = Integer.parseInt(partsDate2[2]);
		
		//Validating dates
		if(!DateUtils.isValidDate(day1, month1, year1) || !DateUtils.isValidDate(day2, month2, year2)) {
			throw new IllegalArgumentException("Invalid date format or out of bounds");
		}
		
		//Difference of days in dates
		int difference = DateUtils.dateDifference(day1, month1, year1, day2, month2, year2);
		
		//Determining earliest and latest date
		String earliestDate, latestDate;
		if(DateUtils.daysSince1900(day1, month1, year1) <= DateUtils.daysSince1900(day2, month2, year2)) {
			earliestDate = date1;
			latestDate = date2;
		}else {
			earliestDate = date2;
			latestDate = date1;
		}
		
		return new DateOutput(earliestDate, latestDate, difference);
	}

}
