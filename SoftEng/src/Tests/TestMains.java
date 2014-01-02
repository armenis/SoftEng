package tests;

import login.HomeDialog;
import login.Login;

import org.junit.Test;

import program.Admin;
import program.Cashier;
import program.Print;

public class TestMains {
	
	@Test 
	public void testCashierMain(){
		String[] args =null;
		Cashier.main(args);
	}
	
	@Test 
	public void testPrintMain(){
		String[] args =null;
		Print.main(args);
	}
	@Test 
	public void testAdminMain(){
		String[] args =null;
		Admin.main(args);
	}
	
	@Test 
	public void testLoginMain(){
		String[] args =null;
		Login.main(args);
	}
	
	@Test 
	public void testHomeDialogMain(){
		String[] args =null;
		HomeDialog.main(args);
	}

}
