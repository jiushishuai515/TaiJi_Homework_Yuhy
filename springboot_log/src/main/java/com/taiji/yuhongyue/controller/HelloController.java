package com.taiji.yuhongyue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	public static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/hello")
	public String hello() {
		logger.debug("------debug");
		logger.info("-------info");
		logger.trace("------trace");
		logger.error("------error");
		logger.warn("-------warn");
		return "hello";
	}

}
