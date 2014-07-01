package junit.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration({"classpath:spring-jpa.xml", "classpath:spring-beans.xml"})
public class TestUserDetailsService extends AbstractJUnit4SpringContextTests {

	@Resource
	private UserDetailsService userDetailsService;
	
	@Test
	public void test() {
		UserDetails ud = userDetailsService.loadUserByUsername("admin");
		System.out.println(ud.getPassword());
	}
}
