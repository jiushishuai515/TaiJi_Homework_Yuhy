package com.taiji.yuhongyue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taiji.yuhongyue.entity.User;
import com.taiji.yuhongyue.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/regist")
	public String regist(User user) {
		//User user1 = userService.getById(user); 
		System.out.println(user.getUsername());
		return "redirect:show";
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public List<User> show() {
		List<User> userList = userService.selectAll();
		for (User user : userList) {
			System.out.println(user.getUsername());
		}
		return userList;
	}
	
	

}
