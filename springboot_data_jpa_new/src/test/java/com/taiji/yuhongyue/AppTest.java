package com.taiji.yuhongyue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	UserService userService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	private static final Logger log = LoggerFactory.getLogger(AppTest.class);
	
	@Ignore
	@Test
	public void insertUsers() {

		for (int i = 10; i < 19; i++) {
			User user = new User();
			user.setUsername("名字" + i);
			user.setPassword("密码" + i);
			userService.saveUser(user);		
		}	
	}
	
	@Ignore
	@Test
	public void findAllUsers() {
		List<User> userList = userService.findAllUsers();
		System.out.println(userList);
	}
	
//	@Test
	public void findByFlag() {
		System.out.println(userService.findByFlag(new Scanner(System.in).nextInt()));
		
	}
	
	
//	@Ignore
	@Test
	public void testPage() {
		String map = "{\"page\" : 2,\"pageSize\" : 2, \"filter\":{ \"filters\":[{ \"field\" : \"username\", \"value\":\"名字\"}]}}";
		Map searchParameters = new HashMap();
		try {
			searchParameters = objectMapper.readValue(map, new TypeReference<Map>() {
			});
		} catch (JsonParseException e) {
			log.error("JsonParseException{}:", e.getMessage());
		} catch (JsonMappingException e) {
			log.error("JsonMappingException{}:", e.getMessage());
		} catch (IOException e) {
			log.error("IOException{}:", e.getMessage());
		}

		Map mapUser = userService.getPage(searchParameters);

		System.out.println(mapUser.get("total"));

		System.out.println(mapUser.get("users"));
	}
}
