package com.tw.homework.conference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * function - core interface
 * author - yezhiyuan
 * date - 02 08 2018
 */
public interface Allocation {
	/**
	 * initial conferences read from file
	 */
	List<Conference> INITIAL_CONFERENCE_LIST = new ArrayList<Conference>();
	/**
	 * result of allocation
	 */
	Map<String, List<Conference>> getResult();
	/**
	 * template function for file reading or allocation and more..
	 */
	void operate(Object object) throws Exception;
}