package com.tw.homework.conference;

/*
 * function - Conference abstract
 * author - yezhiyuan
 * date - 02 08 2018
 */
public class Talk {
	//initial talk name
    private String title;
    //talk name no duration
    private String name;
    //duration
    private Integer timeDuration;
    
	public Talk(String title, String name, Integer timeDuration) {
		this.title = title;
		this.name = name;
		this.timeDuration = timeDuration;
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
	public Integer getTimeDuration() {
		return timeDuration;
	}
	public void setTimeDuration(Integer timeDuration) {
		this.timeDuration = timeDuration;
	}
    
    
    
}
