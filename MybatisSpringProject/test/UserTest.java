import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import com.hp.batis.constant.WorkType;
import com.hp.batis.dao.impl.UserDaoImpl;
import com.hp.batis.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserTest {
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDaoImpl userDaoImpl;
	@Before
	public void before(){
//		userDaoImpl = new UserDaoImpl();
	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setId(6);
		user.setName("hejian");
		Date birthday = null;
		try {
			birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1990-07-02");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setBirthday(birthday);
		user.setTelephone("18721432848");
		user.setWorkType(WorkType.CONTINGENT);
		userDaoImpl.addUser(user);
		
	}
	
	@Test
	public void testGetUserById(){
		User user = userDaoImpl.getUserById(6);
		System.out.println("type : " + user.getWorkType());
		assertEquals("18721432848", user.getTelephone());
	}
	
	@Test
	public void testUpdateUser(){
		User user = userDaoImpl.getUserById(4);
		user.setWorkType(WorkType.REGULOR);
		userDaoImpl.updateUser(user);
	}
	
	@Test
	public void testDeleteUser(){
		User user = new User();
		user.setId(3);
		userDaoImpl.deleteUser(user);
	}
	
	@Test
	public void testDeleteUserById(){
		userDaoImpl.deleteUserById(2);
	}
	
	@Test
	public void testGetUsers(){
		assertEquals(4, userDaoImpl.getUsers().size());
	}

	@Test
	public void testGetPartionUsers(){
		assertEquals(5, userDaoImpl.getPartionUsers().size());
	}

}
