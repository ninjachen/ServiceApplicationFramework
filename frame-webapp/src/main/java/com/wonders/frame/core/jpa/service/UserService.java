package com.wonders.frame.core.jpa.service;

import java.util.List;

import com.wonders.frame.core.jpa.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UserService {

	@Transactional
	public void changeInfomations(User user);

	@Transactional
	public void changePassword(Integer id, String password);

	public User findUserById(Integer id);

	public boolean exists(Integer id, String password);

	public Page<User> findAll(Pageable pageable);

	public boolean hasRole(int userId, String roleName);

	@Transactional
	public void lock(Integer userId);

	@Transactional
	public void unlock(Integer userId);

	public List<User> findAll();

	public List<User> findAllCached();
	
//	public User findById(Integer id);
	public User findByUsername(String username);
	
	public User findUserByUsername(String username);
}
