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
	public static String getTimeAfter(Date date, int timeAfter) {
		long newTimeInLong = date.getTime() + timeAfter * 60 * 1000;
		date.setTime(newTimeInLong);
		String str = new SimpleDateFormat("hh:mma ").format(date);
		if (str.indexOf("上午") > -1) str = str.replace("上午", " AM");
		if (str.indexOf("下午") > -1) str = str.replace("下午", " PM");
		return str;
	}
}
