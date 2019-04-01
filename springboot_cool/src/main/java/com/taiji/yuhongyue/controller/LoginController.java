package com.taiji.yuhongyue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taiji.yuhongyue.entity.Person;
import com.taiji.yuhongyue.entity.User;

@Controller
public class LoginController {
	
////////////thymeleaf登录和展示   页面使用 * 进行object数据绑定
		@GetMapping("/login")
		public String regsubmit(Person person) {
			person.setUsername("王二小");
			person.setPassword("123456");
			System.out.println(person.toString());
			return "login";
		}
		
		@PostMapping("/regsubmit")
		@ResponseBody
		public String reg(@ModelAttribute Person person) {
			String username=person.getUsername();
			String password=person.getPassword();
			return username+"___"+password;
		}
//////////////////////登录和展示
		
		
		
		
		
		@GetMapping("/reg")
		public String reg(User user, Model model) {
			model.addAttribute(user);
			return "reg";
		}

}
