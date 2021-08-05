package com.ct.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) {
		SimpleDateFormat day = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return (Date) day.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
