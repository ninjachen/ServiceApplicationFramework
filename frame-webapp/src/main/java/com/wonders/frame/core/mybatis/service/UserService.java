package com.wonders.frame.core.mybatis.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wonders.frame.core.mybatis.model.User;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UserService {

	public User getUserById(Integer id);

	List<User> getAll();

	int deleteByPrimaryKey(Integer id);
}
