package com.tw.homework.conference;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class RunMain {

	public static void main(String[] args) throws Exception {
		long begin = System.currentTimeMillis();
		//initial the Context
		Context context;
		//read file
		context = new Context(new FileReader());
		context.operate(Constant.FILE_NAME);
		//allocate
		context.setAllocate(new RadomAllocateStrategy());
		context.operate(null);
		//get allocate result Map, step to this line, our goal has been reached
		Map<String, List<Talk>> map = context.getResult();
		
		
		//the next is iterative printing process
		System.out.println("Track 1:");
		List<Talk> trackOneAm = map.get("trackOneAm");
		int t1a = 0;
		for (Talk talk : trackOneAm) {
			Date morning = new Date();
			morning.setHours(9);
			morning.setMinutes(0);
			morning.setSeconds(0);
			System.out.println(TimeUtil.getTimeAfter(morning, t1a) + talk.getTitle());
			t1a += talk.getTimeAfter();
			
		}
		System.out.println("12:00 PM Lunch");
		List<Talk> trackOnePm = map.get("trackOnePm");
		int t1p = 0;
		for (Talk talk : trackOnePm) {
			Date aftermoon = new Date();
			aftermoon.setHours(13);
			aftermoon.setMinutes(0);
			aftermoon.setSeconds(0);
			System.out.println(TimeUtil.getTimeAfter(aftermoon, t1p) + talk.getTitle());
			t1p += talk.getTimeAfter();
		}
		
		System.out.println();
		
		System.out.println("Track 2:");
		List<Talk> trackTwoAm = map.get("trackTwoAm");
		int t2a = 0;
		for (Talk talk : trackTwoAm) {
			Date morning2 = new Date();
			morning2.setHours(9);
			morning2.setMinutes(0);
			morning2.setSeconds(0);
			System.out.println(TimeUtil.getTimeAfter(morning2, t2a) + talk.getTitle());
			t2a += talk.getTimeAfter();
		}
		System.out.println("12:00 PM Lunch");
		List<Talk> trackTwoPm = map.get("trackTwoPm");
		int t2p = 0;
		for (Talk talk : trackTwoPm) {
			Date aftermoon2 = new Date();
			aftermoon2.setHours(13);
			aftermoon2.setMinutes(0);
			aftermoon2.setSeconds(0);
			System.out.println(TimeUtil.getTimeAfter(aftermoon2, t2p) + talk.getTitle());
			t2p += talk.getTimeAfter();
		}
		System.out.println();
		System.out.println("------------------spend total: "+(System.currentTimeMillis() - begin)+"ms------------------");
	}
}