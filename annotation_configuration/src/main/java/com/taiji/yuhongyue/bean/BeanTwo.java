package com.taiji.yuhongyue.bean;

import org.springframework.stereotype.Component;

@Component("beanTwo")
public class BeanTwo {
	
	String name ="yuhongyue222";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
