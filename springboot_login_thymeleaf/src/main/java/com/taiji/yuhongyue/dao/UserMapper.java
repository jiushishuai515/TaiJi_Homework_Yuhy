package com.taiji.yuhongyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.taiji.yuhongyue.entity.User;

@Mapper
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

	List<User> selectAll();
	
	String selectByUserName(String username);
}