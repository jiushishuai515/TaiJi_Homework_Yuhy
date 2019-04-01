package com.taiji.yuhongyue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taiji.yuhongyue.entity.User;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String index(String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@GetMapping("/result")
	public String result(Model model, User user) {
		model.addAttribute("name", user.getName());
		model.addAttribute("age", user.getAge());
		return "result";
	}

	@GetMapping("/index")
	@ResponseBody
	public String hello() {
		return "emmmmmm";
	}

	@GetMapping("/user")
	@ResponseBody
	public String user(String name, Integer age) {
		return name + age;
	}

	@ResponseBody
	@GetMapping("/show")
	public String showuser(User user) {
		user.setName("王二小");
		return "hello" + user.getName();
	}

	// @ResponseBody
	@RequestMapping("/id/{num}")
	public String num(@PathVariable("num") String num, Model model) {
		model.addAttribute("num", num);
		return "num";
	}

	@ResponseBody
	@PostMapping("/json")
	public User json(@RequestBody User user) {
		user.setAge(user.getAge() + 50);
		user.toString();
		System.out.println("再过50年你就:" + user.getAge());
		return user;
	}

}
