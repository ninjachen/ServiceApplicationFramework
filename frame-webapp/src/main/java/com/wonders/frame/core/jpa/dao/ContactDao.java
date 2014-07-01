package com.wonders.frame.core.jpa.dao;

import java.util.List;

import com.wonders.frame.core.jpa.domain.Contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ContactDao extends Repository<Contact, Integer> {

	public Contact findOne(Integer id);

	public Page<Contact> findByOwnerUsername(String username, Pageable pageable);

	public List<Contact> findByOwnerUsername(String username);

	@Query("select count(c.id) from Contact as c where c.owner.username = :username and c.group.id = :groupId")
	public long countByOwnerUsernameAndGroupId(@Param("username") String username, @Param("groupId") Integer groupId);

	public void delete(Integer id);

	public Contact save(Contact contact);

}
