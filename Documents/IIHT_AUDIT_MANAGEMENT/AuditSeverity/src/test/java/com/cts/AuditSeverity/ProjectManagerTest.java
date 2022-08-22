package com.cts.AuditSeverity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.pojo.ProjectManager;


/**
 * @version 11
 * To test ProjectManager class
 * 
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest(classes= ProjectManager.class)
public class ProjectManagerTest {
	
	@Autowired
	ProjectManager projectManager;
	

	/**
	 * to test the all param constructor of userRetail
	 */
	@Test
	public void testProjectManagerAllConstructor()
	{
		ProjectManager manager=new ProjectManager("ABC", "ABC", null);
		assertEquals( "ABC" , manager.getUserId());
	}
	/**
	 * to test the getter setter of Uid
	 */
	@Test
	public void testUserid()
	{
		ProjectManager projectManager = prepareProjectManager();
		assertEquals( "abc123",  projectManager.getUserId());
	}
	/**
	 * to test the getter setter of UserPassword
	 */
	@Test
	public void testUserPassword()
	{
		ProjectManager projectManager = prepareProjectManager();
		assertEquals( "password" , projectManager.getPassword());
	}
	/**
	 * to test the getter setter of AuthToken
	 */
	@Test
	public void testAuthToken()
	{
		ProjectManager projectManager = prepareProjectManager();
		assertEquals("xyz", projectManager.getAuthToken());
	}
	/**
	 * to test the toString
	 */
	@Test
	public void testoString() {
		String string = projectManager.toString();
		assertEquals(string , projectManager.toString());
	}

	private ProjectManager prepareProjectManager() {
		ProjectManager manager=new ProjectManager();
		manager.setUserId("abc123");
		manager.setPassword("password");
		manager.setAuthToken("xyz");
		return manager;
	}
}
