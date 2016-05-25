package com.cmbc.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	private String datePattern;
	private SimpleDateFormat dateFormat;

	public DateFormatter(String datePattern) {
		this.datePattern = datePattern;
		dateFormat = new SimpleDateFormat(datePattern);
		dateFormat.setLenient(false);
	}

	@Override
	public String print(Date arg0, Locale arg1) {
		// TODO Auto-generated method stub
		return dateFormat.format(arg0);
	}

	@Override
	public Date parse(String arg0, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		return dateFormat.parse(arg0);
	}

}
