package com.tw.homework.conference;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import static com.tw.homework.conference.Constant.*;

/*
 * function - core class of random allocation strategy for conference management
 * author - yezhiyuan
 * date - 02 08 2018
 */
public class RadomAllocateStrategy extends AllocateTemplate {

	@Override
	public void operate(Object object) throws Exception {
		if (INITIAL_CONFERENCE_LIST.isEmpty()) {
			throw new RuntimeException("Please read the file firstly！");
		}
		List<Conference> listTemp = allocateTrackOneAm();
		List<Conference> listTemp2 = allocateTrackTwoAm(listTemp);
		List<Conference> listTemp3 = allocateTrackOnePm(listTemp2);
		allocateTrackTwoPm(listTemp3);
	}
	/*
	 * allocating Track 1 AM Conference
	 */
	private List<Conference> allocateTrackOneAm() {
		int sum = 0;
		List<Conference> listTemp = new LinkedList<Conference>();
		listTemp.addAll(INITIAL_CONFERENCE_LIST);
		while (sum != AM_MINUTES) {
			Integer index = new Random().nextInt(listTemp.size());
			Conference ele = listTemp.get(index);
			super.trackOneAm.add(ele);
			listTemp.remove((int)index);
			if ((sum += ele.getTimeDuration()) > AM_MINUTES) {
				sum = 0;
				super.trackOneAm.clear();
				listTemp.clear();
				listTemp.addAll(INITIAL_CONFERENCE_LIST);
			}
		}
		return listTemp;
	}
	/*
	 * allocating Track 1 PM Conference
	 */
	private List<Conference> allocateTrackTwoAm(List<Conference> listTemp) {
		int sum2 = 0;
		List<Conference> listTemp2 = new LinkedList<Conference>();
		listTemp2.addAll(listTemp);
		while (sum2 != AM_MINUTES) {
			Integer index = new Random().nextInt(listTemp2.size());
			Conference ele = listTemp2.get(index);
			listTemp2.remove((int)index);
			super.trackTwoAm.add(ele);
			if ((sum2 += ele.getTimeDuration()) > AM_MINUTES) {
				sum2 = 0;
				super.trackTwoAm.clear();
				listTemp2.clear();
				listTemp2.addAll(listTemp);
			}
		}
		return listTemp2;
	}
	/*
	 * allocating Track 2 AM Conference
	 */
	private List<Conference> allocateTrackOnePm(List<Conference> listTemp2) {
		int sum3 = 0;
		List<Conference> listTemp3 = new LinkedList<Conference>();
		listTemp3.addAll(listTemp2);
		while (sum3 < PM_MINUTES_MIN || sum3 > PM_MINUTES_MAX) {
			Integer index = new Random().nextInt(listTemp3.size());
			Conference ele = listTemp3.get(index);
			listTemp3.remove((int)index);
			super.trackOnePm.add(ele);
			sum3 += ele.getTimeDuration();
		}
		super.trackOnePm.add(new Conference("Networking Event", "Networking Event", 0));
		return listTemp3;
	}
	/*
	 * allocating Track 2 PM Conference
	 */
	private void allocateTrackTwoPm(List<Conference> listTemp3) {
		super.trackTwoPm.addAll(listTemp3);
		super.trackTwoPm.add(new Conference("Networking Event", "Networking Event", 0));
	}
}
