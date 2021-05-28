package dao;

import static org.junit.Assert.*;

import java.sql.Savepoint;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.User;

public class testuser {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testLogin() {
		//nhap dung tendang nhap
		
		User user = new User(1,"levana","lva","1","0902002490","nobjt44@gmail.com","quanly",null);
		Userdao dao = new Userdao();
		User dangnhap = new User();
		dangnhap.setIgn("lva");
		dangnhap.setPassword("1");
		assertEquals(dao.Login(dangnhap).toString(), user.toString());
	}
	@Test
	public void testLogin2() {
		//Nhap sai ten dang nhap
		User user = new User(1,"levana","lva","1","0902002490","nobjt44@gmail.com","quanly",null);
		Userdao dao = new Userdao();
		User dangnhap = new User();
		dangnhap.setIgn("lvb");
		dangnhap.setPassword("1");
		assertEquals(dao.Login(dangnhap).getVaitro(), null);
	}
	
	@Test
	public void testTimUser() {
		//Tim User levana ket qua la array chua 1 phan tu user
		User user = new User(1,"levana","lva","1","0902002490","nobjt44@gmail.com","quanly",null);
		ArrayList<User> listuser = new ArrayList();
		listuser.add(user);
		Userdao dao = new Userdao();
		assertEquals(dao.timUser("levana").toString(),listuser.toString());
	}
	@Test
	public void testTimUser2() {
		//Tim User levancxcvcx ket qua la array rong
		User user = new User(1,"levana","lva","1","0902002490","nobjt44@gmail.com","quanly",null);
		ArrayList<User> listuser = new ArrayList();
		Userdao dao = new Userdao();
		assertEquals(dao.timUser("levancxcvcx").toString(),listuser.toString());
	}
	@Test
	public void testThemUser() {
		//Them 1 user -> timUser truoc + user them = timUsersau()
		User user = new User(4,"levand","lvd","4","0902002490","nobjt44@gmail.com","quanly",null);
		ArrayList<User> listuser = new ArrayList();
		Userdao dao = new Userdao();
		listuser = dao.timUser("");
		listuser.add(user);
		try {
		dao.con.setAutoCommit(false);
		Savepoint spt1 = dao.con.setSavepoint("svpt1");
		dao.themUser(user);	
		assertEquals(dao.timUser("").toString(),listuser.toString());
		dao.con.rollback(spt1);
		
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	public void testThemUser2() {
		//Them 2 user -> timUser truoc +  2 user them = timUsersau()
		User user = new User(4,"levand","lvd","4","0902002490","nobjt44@gmail.com","quanly",null);
		User user2 = new User(5,"levane","lve","5","0902002490","nobjt44@gmail.com","quanly",null);
		ArrayList<User> listuser = new ArrayList();
		Userdao dao = new Userdao();
		listuser = dao.timUser("");
		listuser.add(user);
		listuser.add(user2);
		try {
		dao.con.setAutoCommit(false);
		Savepoint spt1 = dao.con.setSavepoint("svpt1");
		dao.themUser(user);	
		dao.themUser(user2);
		assertEquals(dao.timUser("").toString(),listuser.toString());
		dao.con.rollback(spt1);
		
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	public void testSua() {
		//Sua 1 user -> sua user 3 thanh levand
		User user = new User(3,"levand","lvd","4","0902002490","nobjt44@gmail.com","quanly",null);
		ArrayList<User> listuser = new ArrayList();
		Userdao dao = new Userdao();
		listuser = dao.timUser("");
		listuser.remove(2);
		listuser.add(user);
		try {
			dao.con.setAutoCommit(false);
			Savepoint spt1 = dao.con.setSavepoint("svpt1");
			dao.sua(user);
			assertEquals(dao.timUser("").toString(),listuser.toString());
			dao.con.rollback(spt1);
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	public void testSua2() {
		//Sua 1 user -> sua user 3 thanh levand nhung trung ten dang nhap -> ket qua nhu cu
		User user = new User(3,"levand","lva","4","0902002490","nobjt44@gmail.com","quanly",null);
		ArrayList<User> listuser = new ArrayList();
		Userdao dao = new Userdao();
		listuser = dao.timUser("");
		
		try {
			dao.con.setAutoCommit(false);
			Savepoint spt1 = dao.con.setSavepoint("svpt1");
			dao.sua(user);
			assertEquals(dao.timUser("").toString(),listuser.toString());
			dao.con.rollback(spt1);
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	public void testXoa() {
		//Xoa 1 user id la 3
		ArrayList<User> listuser = new ArrayList();
		Userdao dao = new Userdao();
		listuser = dao.timUser("");
		listuser.remove(2);
		try {
			dao.con.setAutoCommit(false);
			Savepoint spt1 = dao.con.setSavepoint("svpt1");
			dao.xoa(3);
			assertEquals(dao.timUser("").toString(),listuser.toString());
			dao.con.rollback(spt1);
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	public void testXoa2() {
		//Xoa 1 user id la 5 khong co trong bang
		ArrayList<User> listuser = new ArrayList();
		Userdao dao = new Userdao();
		listuser = dao.timUser("");	
		try {
			dao.con.setAutoCommit(false);
			Savepoint spt1 = dao.con.setSavepoint("svpt1");
			dao.xoa(5);
			assertEquals(dao.timUser("").toString(),listuser.toString());
			dao.con.rollback(spt1);
		}catch(Exception e) {
			fail();
		}
	}
}
