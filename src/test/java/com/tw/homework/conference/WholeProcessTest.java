package com.tw.homework.conference;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class WholeProcessTest {
	
	Map<String, List<Conference>> map = null;
	
	long begin = 0;
	
	@Before
	public void setUp() throws Exception {
		begin = System.currentTimeMillis();
		//initial the Context
		Context context;
		//read file
		context = new Context(new FileReader());
		context.operate(Constant.FILE_NAME);
		//allocate
		context.setAllocate(new RadomAllocateStrategy());
		context.operate(null);
		//get allocate result Map, step to this line, our goal has been reached
		map = context.getResult();
	}

	@Test
	public void test() throws Exception {
		//the next is iterative printing process
		int t1a = 0, t1p = 0, t2a = 0, t2p = 0;
		System.out.println("Track 1:");
		List<Conference> trackOneAm = map.get("trackOneAm");
		for (Conference Conference : trackOneAm) {
			Date morning = TimeUtil.getMorningBegins();
			System.out.println(TimeUtil.getTimeAfter(morning, t1a) + Conference.getTitle());
			t1a += Conference.getTimeDuration();
		}
		System.out.println("12:00 PM Lunch");
		List<Conference> trackOnePm = map.get("trackOnePm");
		for (Conference Conference : trackOnePm) {
			Date aftermoon = TimeUtil.getAfternoonBegins();
			System.out.println(TimeUtil.getTimeAfter(aftermoon, t1p) + Conference.getTitle());
			t1p += Conference.getTimeDuration();
		}
		
		System.out.println();
		
		System.out.println("Track 2:");
		List<Conference> trackTwoAm = map.get("trackTwoAm");
		for (Conference Conference : trackTwoAm) {
			Date morning = TimeUtil.getMorningBegins();
			System.out.println(TimeUtil.getTimeAfter(morning, t2a) + Conference.getTitle());
			t2a += Conference.getTimeDuration();
		}
		System.out.println("12:00 PM Lunch");
		List<Conference> trackTwoPm = map.get("trackTwoPm");
		for (Conference Conference : trackTwoPm) {
			Date aftermoon = TimeUtil.getAfternoonBegins();
			System.out.println(TimeUtil.getTimeAfter(aftermoon, t2p) + Conference.getTitle());
			t2p += Conference.getTimeDuration();
		}
		System.out.println();
		System.out.println("------------------spend total: "+(System.currentTimeMillis() - begin)+"ms------------------");
	}
}
