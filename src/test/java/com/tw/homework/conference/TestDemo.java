package com.tw.homework.conference;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class TestDemo {

	@Test
	public void test() throws Exception {

		List<Integer> list = new ArrayList<Integer>();
		list.add(60);
		list.add(45);
		list.add(30);
		list.add(45);
		list.add(45);
		list.add(60);
		list.add(45);
		list.add(30);
		list.add(30);
		list.add(45);
		list.add(60);
		list.add(60);
		list.add(45);
		list.add(30);
		list.add(30);
		list.add(60);
		list.add(30);
		list.add(30);
		
		List<Integer> listTemp = new LinkedList<Integer>();
		listTemp.addAll(list);
		
		int sum = 0;
		List<Integer> temp = new ArrayList<Integer>();
		while (sum != 180) {
			Integer index = new Random().nextInt(listTemp.size());
			Integer ele = listTemp.get(index);
			temp.add(ele);
			listTemp.remove((int)index);
			if ((sum += ele) > 180) {
				sum = 0;
				temp.clear();
				listTemp.clear();
				listTemp.addAll(list);
			}
		}
		for (Integer integer : temp) {
			System.out.println("Track 1 AM -- " + integer);
		}
		System.out.println();
		
		List<Integer> listTemp2 = new LinkedList<Integer>();
		listTemp2.addAll(listTemp);
		
		int sum2 = 0;
		List<Integer> temp2 = new ArrayList<Integer>();
		while (sum2 != 180) {
			Integer index = new Random().nextInt(listTemp2.size());
			Integer ele = listTemp2.get(index);
			listTemp2.remove((int)index);
			temp2.add(ele);
			if ((sum2 += ele) > 180) {
				sum2 = 0;
				temp2.clear();
				listTemp2.clear();
				listTemp2.addAll(listTemp);
			}
		}
		for (Integer integer : temp2) {
			System.out.println("Track 2 AM -- " + integer);
		}
		System.out.println();
		
		List<Integer> listTemp3 = listTemp2;
		
		int sum3 = 0;
		List<Integer> temp3 = new ArrayList<Integer>();
		while (sum3 < 180 || sum3 > 240) {
			Integer index = new Random().nextInt(listTemp3.size());
			Integer ele = listTemp3.get(index);
			listTemp3.remove((int)index);
			temp3.add(ele);
			sum3 += ele;
		}
		for (Integer integer : temp3) {
			System.out.println("Track 1 PM -- " + integer);
		}
		System.out.println();
		
		for (Integer integer : listTemp3) {
			System.out.println("Track 2 PM -- " + integer);
		}
	
	}
}
