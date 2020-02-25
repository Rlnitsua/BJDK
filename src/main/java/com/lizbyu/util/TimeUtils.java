package com.lizbyu.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	public static String getCurrentTime(){
		Date currentTime = new Date();
		DateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
		return format.format(currentTime) + " ";
	}
}
