package com.tw.homework.conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * function - template class for implement
 * author - yzhiyuan
 * date - 02 08 2018
 */
public abstract class AllocateTemplate implements Allocate{
	
	protected List<Talk> trackOneAm = new ArrayList<Talk>();
	
	protected List<Talk> trackOnePm = new ArrayList<Talk>();
	
	protected List<Talk> trackTwoAm = new ArrayList<Talk>();
	
	protected List<Talk> trackTwoPm = new ArrayList<Talk>();

	@Override
	public Map<String, List<Talk>> getResult() {
		Map<String, List<Talk>> map = new HashMap<String, List<Talk>>();
		map.put("trackOneAm", trackOneAm);
		map.put("trackOnePm", trackOnePm);
		map.put("trackTwoAm", trackTwoAm);
		map.put("trackTwoPm", trackTwoPm);
		return map;
	}
}
