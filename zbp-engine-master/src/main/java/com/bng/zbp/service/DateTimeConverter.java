package com.bng.zbp.service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeConverter {
	private final static Logger logger = LoggerFactory.getLogger(DateTimeConverter.class);
	public String convertdate(String date,String time,String timezonevalue,String operator) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dates;
		String datetime="";
		try {
			dates = dateFormat.parse(date+" "+time);
			logger.info("Date"+dates+"Operator"+operator);
			String output = dateFormat.format(dates);
			logger.info("Date "+output);
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(dates);
			String timef = timezonevalue+":00";
			String[] units = timef.split(":");
			int hour = Integer.parseInt(units[0]);
			int minutes = Integer.parseInt(units[1]); 
			int seconds = Integer.parseInt(units[2]);
			int duration = 3600 * hour+60 * minutes + seconds;
			if(operator.equals("+")) {
				logger.info("INSIDE +");
				calendar.set(Calendar.SECOND,(calendar.get(Calendar.SECOND)-duration));
			}else {
				logger.info("INSIDE -");
				calendar.set(Calendar.SECOND,(calendar.get(Calendar.SECOND)+duration));
			}
			datetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(calendar.getTime());
			
			logger.info("New Date"+datetime+"Duration"+duration);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		return datetime;
	}
	public String convertdateHour(String date,String time,String timezonevalue,String operator) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dates;
		String datetime="";
		try {
			dates = dateFormat.parse(date+" "+time);
			logger.info("Date"+dates+"Operator"+operator);
			String output = dateFormat.format(dates);
			logger.info("Date "+output);
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(dates);
			String timef = timezonevalue+":00";
			String[] units = timef.split(":");
			int hour = Integer.parseInt(units[0]);
			int minutes = Integer.parseInt(units[1]); 
			int seconds = Integer.parseInt(units[2]);
			int duration = 3600 * hour+60 * minutes + seconds;
			if(operator.equals("+")) {
				logger.info("INSIDE +");
				calendar.set(Calendar.SECOND,(calendar.get(Calendar.SECOND)-duration));
			}else {
				logger.info("INSIDE -");
				calendar.set(Calendar.SECOND,(calendar.get(Calendar.SECOND)+duration));
			}
			datetime = new SimpleDateFormat("yyyy-MM-dd HH").format(calendar.getTime()).toString();
			logger.info("New Date"+datetime+"Duration"+duration);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		return datetime;
	}
	public String getTime(String type,String data) {
		SimpleDateFormat date;
		if(type=="time") {
			date = new SimpleDateFormat("HH:mm:ss");
		}else {
			date = new SimpleDateFormat("yyyy-MM-dd");
		}
		String return_data = null;
		try {
			return_data = date.parse(data).toString();
			logger.info("Parse"+return_data);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.info("Unable to Parse");
		}
		return return_data;
	}
}
