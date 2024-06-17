package com.auspost.datedifferencecalculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.auspost.datedifferencecalculator.model.DateInput;
import com.auspost.datedifferencecalculator.model.DateOutput;
import com.auspost.datedifferencecalculator.service.DateService;

public class DateServiceTest {
	
	private final DateService dateService = new DateService();
	
	@Test
	void testCalculateDateDifference() {
		 DateInput dateInput = new DateInput();
		 dateInput.setDate1("20 04 1995");
		 dateInput.setDate2("09 04 2003");
		 
		 DateOutput result = dateService.calculateDateDifference(dateInput);
		 
		 assertEquals("20 04 1995", result.getDate1());
		 assertEquals("09 04 2003", result.getDate2());
		 assertEquals(2911, result.getDifference());
				 
	}
	
	@Test
	void testCalculateDateDifferenceWithSameDate() {
		DateInput dateInput = new DateInput();
		dateInput.setDate1("05 07 2007");
		dateInput.setDate2("05 07 2007");
		
		DateOutput result = dateService.calculateDateDifference(dateInput);
		
		assertEquals("05 07 2007", result.getDate1());
		assertEquals("05 07 2007", result.getDate2());
		assertEquals(0, result.getDifference());
	}
	
	@Test
	void testCalculateDateDifferenceWithInvalidDate() {
		DateInput dateInput = new DateInput();
		
		dateInput.setDate1("12 12 2010");
		dateInput.setDate2("15 15 2000");
		
		assertThrows(IllegalArgumentException.class,()-> dateService.calculateDateDifference(dateInput));
	}
	

}
