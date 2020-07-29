package com.lizbyu.internal.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class TimeUtils {
    static String getCurrentTime(){
        Date currentTime = new Date();
        DateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
        return format.format(currentTime) + " ";
    }
}
