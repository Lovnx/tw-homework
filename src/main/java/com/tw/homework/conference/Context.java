package com.tw.homework.conference;

import java.util.List;
import java.util.Map;

/*
 * function - strategy pattern Context class
 * author - yezhiyuan
 * date - 02 08 2018
 */
public class Context {

	private Allocate allocate;

	public Context(Allocate allocate) {
		this.allocate = allocate;
	}

	public void setAllocate(Allocate allocate) {
		this.allocate = allocate;
	}
	
	public void operate(Object object) throws Exception{
		allocate.operate(object);
	}
	
	public Map<String, List<Talk>> getResult(){
		return allocate.getResult();
	}
}
