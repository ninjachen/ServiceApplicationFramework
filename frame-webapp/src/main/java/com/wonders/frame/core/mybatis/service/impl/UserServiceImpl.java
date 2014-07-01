package com.wonders.frame.core.mybatis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonders.frame.core.mybatis.dao.UserMapper;
import com.wonders.frame.core.mybatis.model.User;
import com.wonders.frame.core.mybatis.service.UserService;


@Service("muserService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

//	public UserMapper getUserMapper() {
//		return userMapper;
//	}
//
//	@Autowired
//	public void setUserMapper(UserMapper userMapper) {
//		this.userMapper = userMapper;
//	}
	public User getUserById(Integer id) {
		return userMapper.findOne(id);
	}

	public List<User> getAll() {
		return userMapper.getAll();
	}
	
	public int deleteByPrimaryKey(Integer id){
		return userMapper.deleteByPrimaryKey(id);
	}
}
