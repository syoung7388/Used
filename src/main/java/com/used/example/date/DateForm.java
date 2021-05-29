package com.used.example.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateForm{
	
	
	public static void DateForm(){
	
	}
	
	

	
	
	public static String getYear(){
		
		Date date = new Date();
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		String year = yearFormat.format(date);
		
		return year;
		
	}
	
	public static String getEndDate(int day) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("current: " + df.format(cal.getTime()));
		cal.add(Calendar.DATE, +day);
		System.out.println("after: " + df.format(cal.getTime()));
		String e_date = df.format(cal.getTime());
		
		return e_date;
		
	}
	
	public static Long getD_day(String enddate) throws ParseException {
		
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	
		String today= form.format(new Date());
		Date Today = form.parse(today);
		Date Dday = form.parse(enddate+' '+"23:59:59");
		System.out.println("Dday: " +Dday);
		long dday=Today.getTime()-Dday.getTime();
		long d_day = dday / (24 * 60 * 60 * 1000);
		System.out.println("diffDays: " +d_day);
		
		return d_day;
		
	}

}
