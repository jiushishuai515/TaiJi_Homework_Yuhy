package com.taiji.yuhongyue;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLogApplication.class, args);
	}
	
	public static final Logger logger = LoggerFactory.getLogger(SpringbootLogApplication.class);
	
	@PostConstruct
	public void logSomething() {
		logger.debug("----------------debug ");
		logger.info("-----------------info");
		logger.trace("----------------trace");
		logger.error("---------------error");
		logger.warn("-----------------warn");
		
	}

}
