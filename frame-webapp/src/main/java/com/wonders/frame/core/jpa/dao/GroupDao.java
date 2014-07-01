package com.wonders.frame.core.jpa.dao;

import java.util.List;

import com.wonders.frame.core.jpa.domain.Group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface GroupDao extends Repository<Group, Integer> {

	public List<Group> findByOwnerUsername(String username);

	public Group findOne(Integer id);

	public Group save(Group group);

	public void delete(Integer id);

	@Query("select count(g.id) from Group as g where g.owner.username = :username")
	public long count(@Param("username") String username);

	public Page<Group> findByOwnerUsername(String username, Pageable pageable);
}
