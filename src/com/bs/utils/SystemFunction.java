package com.bs.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SystemFunction {
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String firstLetterToUpper(String str) {
		char[] array = str.toCharArray();
		array[0] -= 32;
		return String.valueOf(array);
	}

	public static String firstLetterToLower(String str) {
		char[] array = str.toCharArray();
		array[0] += 32;
		return String.valueOf(array);
	}

	public static void StringToFile(String path, String content)
			throws IOException {
		File file = new File(path);
		if (file.exists() && file.isFile())
			file.delete();
		file.createNewFile();
		StringBuffer sb = new StringBuffer();
		sb.append(content);
		FileOutputStream out = new FileOutputStream(file, true);
		out.write(sb.toString().getBytes("utf-8"));
		out.close();
	}

	public static String dateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	public static List<Date> getBetweenDates(Date start, Date end) {
	    List<Date> result = new ArrayList<Date>();
	    result.add(start);
	    Calendar tempStart = Calendar.getInstance();
	    tempStart.setTime(start);
	    tempStart.add(Calendar.DAY_OF_YEAR, 1);
	    
	    Calendar tempEnd = Calendar.getInstance();
	    tempEnd.setTime(end);
	    while (tempStart.before(tempEnd)) {
	        result.add(tempStart.getTime());
	        tempStart.add(Calendar.DAY_OF_YEAR, 1);
	    }
	    result.add(end);
	    return result;
	}
}