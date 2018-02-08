package com.tw.homework.conference;

/*
 * function - Conference abstract
 * author - yezhiyuan
 * date - 02 08 2018
 */
public class Talk {
	//原始字符内容
    private String title;
    //talk名称
    private String name;
    //talk时长
    private Integer timeAfter;
    
	public Talk(String title, String name, Integer timeAfter) {
		this.title = title;
		this.name = name;
		this.timeAfter = timeAfter;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTimeAfter() {
		return timeAfter;
	}
	public void setTimeAfter(Integer timeAfter) {
		this.timeAfter = timeAfter;
	}
    
}
