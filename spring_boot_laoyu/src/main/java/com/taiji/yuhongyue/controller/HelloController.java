package com.taiji.yuhongyue.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${my.name}")
	private String name;
	@Value("${my.height}")
	private int height;
	@Value("${my.sex}")
	private String sex;

	@RequestMapping("/hello")
	public String hello() {
		
		return "姓名:"+name+"身高:"+height+"性别:"+sex;
		
	}


}
