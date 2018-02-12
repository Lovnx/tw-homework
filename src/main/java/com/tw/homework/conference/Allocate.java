package com.tw.homework.conference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * function - core interface
 * author - yezhiyuan
 * date - 02 08 2018
 */
public interface Allocate {
	
	List<Conference> initialTalkList = new ArrayList<Conference>();
	
	Map<String, List<Conference>> getResult();
	
	void operate(Object object) throws Exception;
}