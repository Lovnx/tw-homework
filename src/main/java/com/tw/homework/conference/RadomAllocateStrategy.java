package com.tw.homework.conference;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * function - core class of conference management
 * author - yzhiyuan
 * date - 02 08 2018
 */
public class RadomAllocateStrategy extends AllocateTemplate {

	@Override
	public void operate(Object object) throws Exception {
		if (origin.isEmpty()) {
			throw new RuntimeException("Please read the file firstly！");
		}
		List<Talk> listTemp = allocateTrackOneAm();
		List<Talk> listTemp2 = allocateTrackTwoAm(listTemp);
		List<Talk> listTemp3 = allocateTrackOnePm(listTemp2);
		allocateTrackTwoPm(listTemp3);
	}
	/*
	 * allocate Track 1 AM Conference
	 */
	private List<Talk> allocateTrackOneAm() {
		int sum = 0;
		List<Talk> listTemp = new LinkedList<Talk>();
		listTemp.addAll(origin);
		while (sum != Constant.AM_MINUTES) {
			Integer index = new Random().nextInt(listTemp.size());
			Talk ele = listTemp.get(index);
			super.trackOneAm.add(ele);
			listTemp.remove((int)index);
			if ((sum += ele.getTimeAfter()) > 180) {
				sum = 0;
				super.trackOneAm.clear();
				listTemp.clear();
				listTemp.addAll(origin);
			}
		}
		return listTemp;
	}
	/*
	 * allocate Track 1 PM Conference
	 */
	private List<Talk> allocateTrackTwoAm(List<Talk> listTemp) {
		int sum2 = 0;
		List<Talk> listTemp2 = new LinkedList<Talk>();
		listTemp2.addAll(listTemp);
		while (sum2 != Constant.AM_MINUTES) {
			Integer index = new Random().nextInt(listTemp2.size());
			Talk ele = listTemp2.get(index);
			listTemp2.remove((int)index);
			super.trackTwoAm.add(ele);
			if ((sum2 += ele.getTimeAfter()) > 180) {
				sum2 = 0;
				super.trackTwoAm.clear();
				listTemp2.clear();
				listTemp2.addAll(listTemp);
			}
		}
		return listTemp2;
	}
	/*
	 * allocate Track 2 AM Conference
	 */
	private List<Talk> allocateTrackOnePm(List<Talk> listTemp2) {
		int sum3 = 0;
		List<Talk> listTemp3 = new LinkedList<Talk>();
		listTemp3.addAll(listTemp2);
		while (sum3 < Constant.PM_MINUTES_MIN || sum3 > Constant.PM_MINUTES_MAX) {
			Integer index = new Random().nextInt(listTemp3.size());
			Talk ele = listTemp3.get(index);
			listTemp3.remove((int)index);
			super.trackOnePm.add(ele);
			sum3 += ele.getTimeAfter();
		}
		super.trackOnePm.add(new Talk("Networking Event", "Networking Event", 0));
		return listTemp3;
	}
	/*
	 * allocate Track 2 PM Conference
	 */
	private void allocateTrackTwoPm(List<Talk> listTemp3) {
		super.trackTwoPm.addAll(listTemp3);
		super.trackTwoPm.add(new Talk("Networking Event", "Networking Event", 0));
	}
}
