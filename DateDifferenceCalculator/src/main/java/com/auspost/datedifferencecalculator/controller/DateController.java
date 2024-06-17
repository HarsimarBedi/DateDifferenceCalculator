package com.auspost.datedifferencecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auspost.datedifferencecalculator.model.DateInput;
import com.auspost.datedifferencecalculator.model.DateOutput;
import com.auspost.datedifferencecalculator.service.DateService;

@RestController
@RequestMapping("/api/dates")
public class DateController {
	
	@Autowired
	private DateService dateService;

	@PostMapping("/calculate")
	public DateOutput calculateDateDifference(@RequestBody DateInput dateInput) {
		return dateService.calculateDateDifference(dateInput);
	}
}
