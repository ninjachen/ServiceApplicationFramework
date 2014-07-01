package com.wonders.frame.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.alibaba.fastjson.JSON;
import com.wonders.frame.core.mybatis.model.User;
import com.wonders.frame.core.mybatis.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:spring-mybatis.xml", "classpath:spring-beans.xml" })
public class TestMybatis {

//	private static final Logger logger = Logger.getLogger(TestMybatis.class);
//
//	private UserService userService;
//
//	public UserService getUserService() {
//		return userService;
//	}
//
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//
//	@Test
//	public void test1() {
//		User u = userService.getUserById(1);
//		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
//	}
//
//	@Test
//	public void test2() {
//		List<User> l = userService.getAll();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}

//	@Test
//	public void test3() {
//		List<User> l = userService.getAll2();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}
//
//	@Test
//	public void test4() {
//		List<User> l = userService.getAll3();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}
}
