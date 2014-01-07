package tests;


import javax.swing.JTextField;

import junit.framework.TestCase;
import login.*;
import org.junit.Test;

public class LoginTest extends TestCase {
	
	//Testarei to JTextField gia to Username !!
	Login log = new Login();
	@Test
	public void testUsernameTextfield() throws Exception {
		String testString = "admin";
  
		assertNotNull(log);  // Instantiated?

		JTextField input = (JTextField)TestUtils.getChildNamed(log, "user");
		assertNotNull(input); // Component found?
   
		input.setText(testString);
		input.postActionEvent();  // Type in a test message + ENTER

		assertEquals(testString, input.getText());
    }
	
	//Testarei to JTextField gia to Password !!
	@Test
	public void testPswTextField() throws Exception {
		String testString = "1234";
  
		assertNotNull(log);  // Instantiated?

		JTextField input = (JTextField)TestUtils.getChildNamed(log, "psw");
		assertNotNull(input); // Component found?
   
		input.setText(testString);
		input.postActionEvent();  // Type in a test message + ENTER

		assertEquals(testString, input.getText());
    }
	
	//Testaroume thn Authenticate() ths Login

	@Test
	public void testAuthnticate() {

		String testuser = "admin";
		String testpsw = "1234";
		JTextField user = (JTextField)TestUtils.getChildNamed(log, "user");
		JTextField psw = (JTextField)TestUtils.getChildNamed(log, "psw");
		assertNotNull(user); // Component found?
		assertNotNull(psw); // Component found?
		user.setText(testuser);
		psw.setText(testpsw);
		user.postActionEvent();
		psw.postActionEvent();

		assertTrue("Login Data are Correct !!",Login.authenticate(user.getText(), psw.getText()));
	}
	
	
	@Test
	public void testGetUsername(){
		String testuser = "admin";
		JTextField user = (JTextField)TestUtils.getChildNamed(log, "user");
		assertNotNull(user); // Component found?
		user.setText(testuser);
		user.postActionEvent();
		
		assertEquals("admin",log.getUsername());
	}
	
	@Test
	public void testGetPassword(){
		String testpsw = "1234";
		JTextField psw = (JTextField)TestUtils.getChildNamed(log, "psw");
		assertNotNull(psw); // Component found?
		psw.setText(testpsw);
		psw.postActionEvent();
		
		assertEquals("1234",log.getPassword());
	}

}
