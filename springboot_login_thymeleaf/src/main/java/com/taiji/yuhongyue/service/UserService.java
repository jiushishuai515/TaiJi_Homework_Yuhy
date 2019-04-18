package com.taiji.yuhongyue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiji.yuhongyue.dao.UserMapper;
import com.taiji.yuhongyue.entity.User;

@Service(value = "userService")
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User getById(User user) {

		return userMapper.selectByPrimaryKey(user.getId());
	}

	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	public void insert(User user) {
		userMapper.insert(user);
	}

	public String selectByUserName(String username) {

		return userMapper.selectByUserName(username);
	}

}
