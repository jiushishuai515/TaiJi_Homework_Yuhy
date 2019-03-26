package com.taiji.yuhongyue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@ConfigurationProperties(prefix="my")
@Configuration
public class MySelf {
	
	String name;
	int height;
	String sex;
	
	@Override
	public String toString() {
		return "MySelf [name=" + name + ", height=" + height + ", sex=" + sex + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

}
