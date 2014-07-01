package com.wonders.frame.core.mybatis.dao;

import com.wonders.frame.core.mybatis.model.UserRoleKey;


public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
}