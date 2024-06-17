package com.auspost.datedifferencecalculator.model;

public class DateOutput {
	private String date1;
	private String date2;
	private int difference;

	
	public DateOutput(String date1, String date2, int difference) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.difference = difference;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public int getDifference() {
		return difference;
	}

	public void setDifference(int difference) {
		this.difference = difference;
	}

}
