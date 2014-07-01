package junit.dao;

import java.util.List;

import javax.annotation.Resource;

import com.wonders.frame.core.jpa.dao.GroupDao;
import com.wonders.frame.core.jpa.domain.Group;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration({"classpath:spring-jpa.xml", "classpath:spring-beans.xml"})
public class TestGroupDao extends AbstractJUnit4SpringContextTests {

	@Resource
	private GroupDao groupDao;

	@Test
	public void test1() {
		List<Group> list = groupDao.findByOwnerUsername("admin");
		
		System.out.println(list.size());
	}
	
	@Test
	public void test2() {
		
	}
}
