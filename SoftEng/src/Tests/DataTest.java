package tests;

import static org.junit.Assert.*;

import java.util.Vector;

import login.Login;

import org.junit.Test;

import program.Admin;
import program.Data;
import program.Print;


public class DataTest {
	
	//Testaroume thn CalculateChange() ths Data
	Data data = new Data();
	
	@Test
	public void testCalculateChange(){
		Double change = data.calculateChange("40.0", 30.0);
		Double testchange = 10.0;
		assertEquals("Correct",testchange,change);
	}

	@Test
	public void testGetDays(){
		String perioxh = "калиа";
		Vector days = new Vector();
		days.addElement("деутеяа");
		days.addElement("пелптг");
		assertEquals(days,Data.getDays(perioxh));
	}
	
	@Test
	public void testGetPrice(){
		Double price = 18.0;
		String perioxh = "калиа";
		assertEquals(price,Data.getPrice(perioxh));
	}
	
	@Test
	public void testGetTimes(){
		String perioxh = "калиа";
		Vector times = new Vector();
		times.addElement("9:00");
		times.addElement("11:00");
		times.addElement("13:00");
		assertEquals(times,Data.getTimes(perioxh));
	}
}
