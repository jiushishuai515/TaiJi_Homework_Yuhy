package com.taiji.yuhongyue.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.taiji.yuhongyue.entity.User;
import com.taiji.yuhongyue.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserService userService;

	// 显示登陆界面
	@GetMapping("/login")
	public String login(HttpServletRequest httpServletRequest) {
		httpServletRequest.getAttribute("error");
		return "login";
	}

	// 登录提交
	@PostMapping("/loginSubmit")
	public ModelAndView loginSubmit(User user, ModelAndView mv) {
		if (user.getPassword().equals(userService.selectByUserName(user.getUsername()))
				&& userService.selectByUserName(user.getUsername()) != null) {
			// model.addAttribute("user", user);
			mv.addObject("user", user);
			mv.setViewName("redirect:showAllUser");
			return mv;
		}
		mv.addObject("error", "请输入正确的用户名和密码");
		mv.setViewName("/login");
		// model.addAttribute("error","请输入正确的用户名和密码");
		return mv;

	}

	// 显示注册界面
	@GetMapping("/reg")
	public String reg() {
		return "reg";
	}

	// 注册提交
	@PostMapping("/regist")
	public String regist(User user) {
		System.out.println("注册" + user.getUsername());
		userService.insert(user);
		return "redirect:showAllUser";
	}

	// 显示所有用户
	@GetMapping("/showAllUser")
	public String showUser(Model model) {
		List<User> userList = userService.selectAll();
		userList.forEach(System.out::println);
		model.addAttribute("users", userList);
		return "success";
	}

}
