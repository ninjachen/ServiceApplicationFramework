package com.wonders.frame.core.jpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.wonders.frame.core.jpa.dao.UserDao;
import com.wonders.frame.core.jpa.domain.Role;
import com.wonders.frame.core.jpa.domain.User;
import com.wonders.frame.core.jpa.service.UserService;
import com.wonders.frame.core.mybatis.dao.UserMapper;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private UserDao userDao;


	@Override
	public void changeInfomations(User user) {
		if (user == null) {
			throw new IllegalArgumentException("user为null");
		}
		
		if (user.getId() == null) {
			logger.debug("保存实体");
			userDao.save(user);
			return;
		}
		
		User mergedUser = userDao.findOne(user.getId());
		if (mergedUser == null) {
			logger.warn("没有找到要更新的实体");
			return;
		}
		
		logger.debug("更新实体");
		mergedUser.setEmails(user.getEmails());
		mergedUser.setName(user.getName());
		mergedUser.setGender(user.getGender());
		userDao.save(mergedUser);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	public boolean exists(Integer id, String password) {
		User user = findUserById(id);
		
		if (user != null) {
			String md5Pwd = DigestUtils.md5Hex(password);
			if (md5Pwd.equals(user.getPassword())) {
				return true;
			} else {
				logger.debug("密码不正确");
			}
		} else {
			logger.debug("没有找到实体");
		}
		return false;
	}

	@Override
	public void changePassword(Integer id, String password) {
		User user = userDao.findOne(id);
		if (user == null) {
			logger.debug("没有找到实体");
		} else {
			user.setPassword(DigestUtils.md5Hex(password));
			userDao.save(user);
		}
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userDao.findAll(pageable);
	}

	@Override
	public boolean hasRole(int userId, String roleName) {
		User user = userDao.findOne(userId);
		
		if (user == null) return false;
		for (Role role : user.getRoles()) {
			if (role.getName().equals(roleName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void lock(Integer userId) {
		User user = userDao.findOne(userId);
		user.setLock(User.Lock.LOCKED);
		userDao.save(user);
	}

	@Override
	public void unlock(Integer userId) {
		User user = userDao.findOne(userId);
		user.setLock(User.Lock.NON_LOCKED);
		userDao.save(user);
	}
	
	@Override
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	@Override
	public List<User> findAllCached() {
		return userDao.findAllCached();
	}
	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
//	public List<User> getAll(){
//		return userMapper.getAll();
//	}
//	
//	@Override
//	 public User findOne(Integer id){
//		 return userMapper.findOne(id);
//	 }
	 
//	public User findById(Integer id){
//		return userDao.findById(id);
//	}
	
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
}
