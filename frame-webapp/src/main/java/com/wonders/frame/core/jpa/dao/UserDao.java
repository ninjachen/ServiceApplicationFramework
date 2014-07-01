package com.wonders.frame.core.jpa.dao;

import java.util.List;

import javax.persistence.QueryHint;

import com.wonders.frame.core.jpa.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends Repository<User, Integer> {

	public long count();

	public User findOne(Integer id);

	public User findByUsername(String username);

	public User save(User user);
	
	public Page<User> findAll(Pageable pageable);
	
	// spring-data-jpa默认继承实现的一些方法
    // 该类中的方法不能通过@QueryHint来实现查询缓存。  
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })  
    public List<User> findAll();  
      
    @Query("from User")  
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })  
    public List<User> findAllCached();
    
	@Query("select t from User t where t.username = ?1")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public User findUserByUsername(String username);
	
//	@Query("select u.id from User as u where u.id=:id")
//	public User findById(@Param("id") Integer id);
//	
//	@Query( " select u.id from User as u where u.name.firstname =:firstname" )
//	public  List<User> findByFirstname(@Param("firstname") String firstname);
}
