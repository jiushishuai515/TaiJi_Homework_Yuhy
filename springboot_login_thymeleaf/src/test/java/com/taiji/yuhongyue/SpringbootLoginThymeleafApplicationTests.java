package com.taiji.yuhongyue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taiji.yuhongyue.entity.User;
import com.taiji.yuhongyue.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLoginThymeleafApplicationTests {


	@Autowired
	UserService userService;
	
	@Test
	public void contextLoads() {
		
		String pass=userService.selectByUserName("1");
		System.out.println(pass);
		
	}

}
