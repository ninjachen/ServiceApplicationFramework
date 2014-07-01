package com.wonders.frame.core.jpa.dao;

import java.util.List;

import com.wonders.frame.core.jpa.domain.Role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface RoleDao extends Repository<Role, Integer> {

	public Role findOne(Integer id);

	public List<Role> findAll();

	public Page<Role> findAll(Pageable pageable);

	public Role findByName(String name);

	public long count();
}
