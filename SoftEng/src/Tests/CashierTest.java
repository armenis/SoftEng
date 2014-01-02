package tests;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;

import program.Cashier;

public class CashierTest {
	

	Cashier cash = new Cashier();
	@Test
	public void testNameTextField() throws Exception {
		String testString = "stamatis";
  
		assertNotNull(cash);  // Instantiated?

		JTextField input = (JTextField)TestUtils.getChildNamed(cash, "name");
		assertNotNull(input); // Component found?
   
		input.setText(testString);
		input.postActionEvent();  // Type in a test message + ENTER

		assertEquals(testString, input.getText());
    }
	
	@Test
	public void testSurnameTextField() throws Exception {
		String testString = "armenis";
  
		assertNotNull(cash);  // Instantiated?

		JTextField input = (JTextField)TestUtils.getChildNamed(cash, "surname");
		assertNotNull(input); // Component found?
   
		input.setText(testString);
		input.postActionEvent();  // Type in a test message + ENTER

		assertEquals(testString, input.getText());
    }
	
	@Test
	public void testPaymentTextField() throws Exception {
		String testString = "50";
  
		assertNotNull(cash);  // Instantiated?

		JTextField input = (JTextField)TestUtils.getChildNamed(cash, "payment");
		assertNotNull(input); // Component found?
   
		input.setText(testString);
		input.postActionEvent();  // Type in a test message + ENTER

		assertEquals(testString, input.getText());
    }
	
	@Test
	public void testGetClientName(){
		String testuser = "stamatis";
		JTextField user = (JTextField)TestUtils.getChildNamed(cash, "name");
		assertNotNull(user); // Component found?
		user.setText(testuser);
		user.postActionEvent();
		
		assertEquals("stamatis",cash.getClientName());
	}
	
	@Test
	public void testGetClientUsername(){
		String testuser = "armenis";
		JTextField user = (JTextField)TestUtils.getChildNamed(cash, "surname");
		assertNotNull(user); // Component found?
		user.setText(testuser);
		user.postActionEvent();
		
		assertEquals("armenis",cash.getClientSurname());
	}
	
	@Test
	public void testGetPayment(){
		String testuser = "50";
		JTextField user = (JTextField)TestUtils.getChildNamed(cash, "payment");
		assertNotNull(user); // Component found?
		user.setText(testuser);
		user.postActionEvent();
		
		assertEquals("50",cash.getPayment());
	}
}
