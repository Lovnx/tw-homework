package com.tw.homework.conference;

import java.util.List;
import java.util.Map;

/*
 * function - strategy pattern Context class
 * author - yezhiyuan
 * date - 02 08 2018
 */
public class Context {

	private Allocation allocation;

	public Context(Allocation allocate) {
		this.allocation = allocate;
	}

	public void setAllocate(Allocation allocate) {
		this.allocation = allocate;
	}
	
	public void operate(Object object) throws Exception{
		allocation.operate(object);
	}
	
	public Map<String, List<Conference>> getResult(){
		return allocation.getResult();
	}
}
