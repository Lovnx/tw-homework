package com.tw.homework.conference;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class WholeProcessTest {
	
	Map<String, List<Talk>> map = null;
	
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
		List<Talk> trackOneAm = map.get("trackOneAm");
		for (Talk talk : trackOneAm) {
			Date morning = TimeUtil.getMorningBegins();
			System.out.println(TimeUtil.getTimeAfter(morning, t1a) + talk.getTitle());
			t1a += talk.getTimeAfter();
		}
		System.out.println("12:00 PM Lunch");
		List<Talk> trackOnePm = map.get("trackOnePm");
		for (Talk talk : trackOnePm) {
			Date aftermoon = TimeUtil.getAfternoonBegins();
			System.out.println(TimeUtil.getTimeAfter(aftermoon, t1p) + talk.getTitle());
			t1p += talk.getTimeAfter();
		}
		
		System.out.println();
		
		System.out.println("Track 2:");
		List<Talk> trackTwoAm = map.get("trackTwoAm");
		for (Talk talk : trackTwoAm) {
			Date morning = TimeUtil.getMorningBegins();
			System.out.println(TimeUtil.getTimeAfter(morning, t2a) + talk.getTitle());
			t2a += talk.getTimeAfter();
		}
		System.out.println("12:00 PM Lunch");
		List<Talk> trackTwoPm = map.get("trackTwoPm");
		for (Talk talk : trackTwoPm) {
			Date aftermoon = TimeUtil.getAfternoonBegins();
			System.out.println(TimeUtil.getTimeAfter(aftermoon, t2p) + talk.getTitle());
			t2p += talk.getTimeAfter();
		}
		System.out.println();
		System.out.println("------------------spend total: "+(System.currentTimeMillis() - begin)+"ms------------------");
	}
}
