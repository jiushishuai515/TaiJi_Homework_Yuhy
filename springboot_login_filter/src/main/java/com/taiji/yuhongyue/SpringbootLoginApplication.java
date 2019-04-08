package com.taiji.yuhongyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan(basePackages = {"com.taiji.yuhongyue.filter"})
@SpringBootApplication
public class SpringbootLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLoginApplication.class, args);
	}

}
