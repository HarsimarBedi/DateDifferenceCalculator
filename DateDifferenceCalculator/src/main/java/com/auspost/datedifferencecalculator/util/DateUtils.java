package com.auspost.datedifferencecalculator.util;

public class DateUtils {
	
	public static boolean isLeapYear(int year) {
		if(year % 4 == 0 ) {
			if(year % 100 != 0) {
				return true;
			}else {
				if(year % 400 == 0) {
					return true;
				}else {
				return false;
				}
			}
		}else {
		return false;
		}
	}
	
	public static int daysInMonth(int month, int year) {
		return switch(month) {
		case 4,6,9,11 -> 30;
		case 2 -> isLeapYear(year) ? 29 : 28;
		default -> 31;
		};
	}
	
	public static boolean isValidDate(int day, int month, int year) {
		if(year < 1900 || year > 2020) {
			return false;
		}
		if(month < 1 || month > 12) {
			return false;
		}
		if(day >= 1 && day <= daysInMonth(month, year)) {
			return true;
		}
		return false;
	}
	
	public static int daysFromStartOfYear(int day, int month, int year) {
		int days = day;
		for( int i = 1; i < month ; i++) {
			days = days + daysInMonth(i, year);
		}
		return days;
	}
	
	public static int daysSince1900(int day, int month, int year) {
		int days = 0;
		for( int i = 1900 ; i < year ; i++) {
			days = days + (isLeapYear(i)? 366 : 365);
		}
		days = days + daysFromStartOfYear(day, month, year);
		return days;
	}
	
	public static int dateDifference(int day1, int month1, int year1, int day2, int month2, int year2) {
		int days1 = daysSince1900(day1, month1, year1);
		int days2 = daysSince1900(day2, month2, year2);
		 return Math.abs(days1 - days2);
		
	}
	
}



