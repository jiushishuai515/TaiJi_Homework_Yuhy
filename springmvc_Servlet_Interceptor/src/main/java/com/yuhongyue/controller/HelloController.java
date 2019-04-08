package com.yuhongyue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/user")
	public String say(User user,Model model) {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user);
		model.addAttribute("name", user);
		return "index";
		
	}
	
	@GetMapping("/param")
	public String param(@RequestParam String age) {

		System.out.println(age);
		return "index";
		
	}
	
	@GetMapping("/login")
	@ResponseBody
	public String login() {

		System.out.println("haha");
		return "!!!!";
		
	}
	
	@GetMapping("/another/{name}")
	public String another(@PathVariable @RequestAttribute String name) {
		
		System.out.println(name);
		return "index";
		
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		String name="nidaye";
		model.addAttribute("name",name);
		return "index";
	}

}
