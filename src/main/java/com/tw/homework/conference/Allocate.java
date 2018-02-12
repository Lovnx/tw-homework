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
	
	List<Talk> initialTalkList = new ArrayList<Talk>();
	
	Map<String, List<Talk>> getResult();
	
	void operate(Object object) throws Exception;
}