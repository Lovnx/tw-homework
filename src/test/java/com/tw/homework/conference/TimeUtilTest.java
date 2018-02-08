package com.tw.homework.conference;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TimeUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetTimeAfter() {
		Date date = new Date();
		date.setHours(13);
		date.setMinutes(0);
		date.setSeconds(0);

		System.out.println(TimeUtil.getTimeAfter(date, 61));
	}

	@Test
	public void testGetTimeAfter2() {
		Date date = new Date();
		date.setHours(9);
		date.setMinutes(0);
		date.setSeconds(0);

		System.out.println(TimeUtil.getTimeAfter(date, 61));
	}
	
	@Test
	public void testGetTimeAfter3() {
		Date date = new Date();
		date.setHours(9);
		date.setMinutes(0);
		date.setSeconds(0);

		System.out.println(TimeUtil.getTimeAfter(date, 179));
	}

}
