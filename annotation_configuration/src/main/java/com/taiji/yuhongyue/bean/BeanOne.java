package com.taiji.yuhongyue.bean;

import org.springframework.stereotype.Component;

@Component("beanOne")
public class BeanOne {
	
	String name="yuhongyue111";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
