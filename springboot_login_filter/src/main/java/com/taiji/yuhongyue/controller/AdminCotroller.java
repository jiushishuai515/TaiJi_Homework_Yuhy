package com.taiji.yuhongyue.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminCotroller {
	
	@PostMapping("/login")
	public String loginSubmit(HttpServletRequest request,String username) {
		request.getSession().setAttribute("username", username);
		return "登录成功";
	}
	
	@GetMapping("/index")
	public String index() {
		return "im index";
	}

	//admin可以访问a 也可以访问b
	@GetMapping("/a")
	public String a() {
		return "im aaaaaaaaaaaaaaaa";
	}
	
	
	//user只能访问b
	@GetMapping("/b")
	public String b() {
		return "im bbbbbbbbbbbbbbbb";
	}
	

}
