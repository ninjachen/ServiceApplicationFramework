package junit;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.wonders.frame.core.jpa.dao.UserDao;
import com.wonders.frame.core.jpa.domain.User;
import com.wonders.frame.core.jpa.service.UserService;
import com.wonders.frame.util.uuid.UUIDUtils;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration({"classpath:spring-jpa.xml", "classpath:spring-beans.xml","classpath:spring-mybatis.xml" })
public class TestConfig extends AbstractJUnit4SpringContextTests {

//	@Value("#{constant['me.author.name']}")
//	private String author;

//	@Test
//	public void test() {
//		System.out.println(author);
//		
//		for (int i=0; i<200; i++) {
//			System.out.println(UUIDUtils.randomUUID());
//		}
//	}
	@Autowired
	private UserService userService;
//	public UserService getUserService() {
//		return userService;
//	}
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
	@PersistenceUnit
	private EntityManagerFactory emf;
	
//	@Autowired
//	private UserDao userDao;
	
	@Test
	public void test1() {
		System.out.println("=====u1====");
		User u1 = userService.findUserById(2);
		System.out.println("=====u2====");
		User u2 = userService.findUserById(2);
		System.out.println("=====u3====");
		User u3 = userService.findUserById(2);
		System.out.println("++"+u1.getFirstName());
	}
	
	@Test
	public void test3() {
		User user = userService.findByUsername("admin");
		System.out.println("====test3===="+user);
	}
	
	/**
	 * 测试一级缓存
	 */
	@Test
	public void firstCacheTest(){	
		EntityManager em = emf.createEntityManager();
		User d1 = em.find(User.class, 1); //find id为1的对象
		User d2 = em.find(User.class, 1); //find id为1的对象
		logger.info((d1==d2)+""); //true
		em.close();
	
		EntityManager em1 = emf.createEntityManager();
		User d3 = em1.find(User.class, 1); //find id为1的对象
		EntityManager em2 = emf.createEntityManager();
		User d4 = em2.find(User.class, 1); //find id为1的对象
		logger.info((d3==d4)+""); //false
		em1.close();
		em2.close();
	}
	
	/**
	 * 测试二级缓存
	 */
	@Test
	public void secondCachetest(){
		
		EntityManager em1 = emf.createEntityManager();
		User d1 = em1.find(User.class, 1); //find id为1的对象
		System.out.println(d1.getLastName());
		em1.close();
		EntityManager em2 = emf.createEntityManager();
		User d3 = em2.find(User.class, 1); //find id为1的对象
		System.out.println(d3.getLastName());
		em2.close();
	}
	
	/**
	 * 测试查询缓存
	 */
	@Test
	public void QueryCacheTest(){
		//无效的spring-data-jpa实现的接口方法
		//输出两条sql语句
		userService.findAll();
		System.out.println("*****findAll*****");
		userService.findAll();
		System.out.println("================test 1 finish======================");
		
		//自己实现的dao方法可以被查询缓存
		//输出一条sql语句
		userService.findAllCached();
		System.out.println("*****findAllCached*****");
		userService.findAllCached();
		System.out.println("================test 2 finish======================");
		
		//系统实现的dao方法不能被查询缓存
		//输出二条sql语句
		userService.findByUsername("admin");
		System.out.println("*****findByUsername*****");
		userService.findByUsername("admin");
		System.out.println("================test 3 finish======================");
		
		//自己实现的dao方法可以被查询缓存
		//输出一条sql语句
		userService.findUserByUsername("admin");
		System.out.println("*****findUserByUsername*****");
		userService.findUserByUsername("admin");
		System.out.println("================test 4 finish======================");
	}
	
	/**
	 * 显示二级缓存和查询缓存的数据
	 */
	@Test
	public void showCacheStatisticsInfo(){
		secondCachetest();
		QueryCacheTest();
		System.out.println("===================L2======================");
		SessionFactory sf = ((HibernateEntityManagerFactory)emf).getSessionFactory();
		String[] k = sf.getStatistics().getSecondLevelCacheRegionNames();
		for (String string : k) {
			SecondLevelCacheStatistics ss = 
					sf.getStatistics().getSecondLevelCacheStatistics(string);
			System.out.println(string+" : "+ss.getPutCount());
		}
		System.out.println("=================query cache=================");
		String[] querys = sf.getStatistics().getQueries();
		for (String string : querys) {
			System.out.println(string);
		}
	}
	@Test
	public void test2() {
		boolean u = userService.exists(1, "admin");
		System.out.println("++"+u);
	}
//	@Test
//	public void test3() {
//		List<User> u = userService.findByFirstname("杰");
//		System.out.println("++"+u);
//	}
	
//	@Test
//	public void test3() {
//		User u = userService.find(1);
//		System.out.println("++"+u.getFirstName());
//	}
}
