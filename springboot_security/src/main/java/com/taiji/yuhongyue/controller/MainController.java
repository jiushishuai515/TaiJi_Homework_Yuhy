package com.taiji.yuhongyue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/main")
	public String main() {
		return "hello";
	}
	
	@GetMapping("/a")
	public String a() {
		return "im aaaaaaaaaa";
	}

}
