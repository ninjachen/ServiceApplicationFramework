package com.wonders.frame.core.mybatis.dao;

import java.util.List;

import com.wonders.frame.core.mybatis.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    User selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
    
    List<User> getAll();
    
    User findOne(Integer id);
    
    
}