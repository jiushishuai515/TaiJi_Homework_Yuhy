package com.taiji.yuhongyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.taiji.yuhongyue.entity.User;

@Mapper
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> selectAll();
}