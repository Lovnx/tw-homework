package com.tw.homework.conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * function - template class for implement
 * author - yezhiyuan
 * date - 02 08 2018
 */
public abstract class AllocateTemplate implements Allocate{
	
	protected List<Conference> trackOneAm = new ArrayList<Conference>();
	
	protected List<Conference> trackOnePm = new ArrayList<Conference>();
	
	protected List<Conference> trackTwoAm = new ArrayList<Conference>();
	
	protected List<Conference> trackTwoPm = new ArrayList<Conference>();

	@Override
	public Map<String, List<Conference>> getResult() {
		Map<String, List<Conference>> map = new HashMap<String, List<Conference>>();
		map.put("trackOneAm", trackOneAm);
		map.put("trackOnePm", trackOnePm);
		map.put("trackTwoAm", trackTwoAm);
		map.put("trackTwoPm", trackTwoPm);
		return map;
	}
}
