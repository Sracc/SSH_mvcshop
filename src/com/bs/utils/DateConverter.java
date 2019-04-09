package com.bs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter{
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		try {
		return format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			try {
				return format2.parse(dateString);
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		return new Date();
	}

	@Override
	public String convertToString(Map context, Object o) {
		return format.format(o);
	}

}
