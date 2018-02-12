package com.tw.homework.conference;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * function - time controller
 * author - yezhiyuan
 * date - 02 08 2018
 */
public class TimeUtil {

	/*
	 * function - caculate the clock, pass 'timeAfter' minutes
	 */
	public static String getTimeAfter(Date date, int timeDuration) {
		long newTimeInLong = date.getTime() + timeDuration * 60 * 1000;
		date.setTime(newTimeInLong);
		String str = new SimpleDateFormat("hh:mma ").format(date);
		if (str.indexOf("上午") > -1) str = str.replace("上午", " AM");
		if (str.indexOf("下午") > -1) str = str.replace("下午", " PM");
		return str;
	}
	
	@SuppressWarnings("deprecation")
	public static Date getMorningBegins() {
		Date morning = new Date();
		morning.setHours(9);
		morning.setMinutes(0);
		morning.setSeconds(0);
		return morning;
	}
	
	@SuppressWarnings("deprecation")
	public static Date getAfternoonBegins() {
		Date afternoon = new Date();
		afternoon.setHours(13);
		afternoon.setMinutes(0);
		afternoon.setSeconds(0);
		return afternoon;
	}
}
