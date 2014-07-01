package junit.dao;

import javax.annotation.Resource;

import com.wonders.frame.core.jpa.dao.ContactDao;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:spring-beans.xml", "classpath:spring-jpa.xml"})
public class TestContactDao extends AbstractJUnit4SpringContextTests {

	@Resource private ContactDao dao;
	
	@Test
	public void test() {
		long count = dao.countByOwnerUsernameAndGroupId("admin", 1);
		System.out.println(count);
	}
}
