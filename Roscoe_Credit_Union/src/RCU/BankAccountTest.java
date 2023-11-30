package RCU;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
	BankAccount bank1;
	BankAccount bank2;
	
	
	@Before
	public void setUp() {
		bank1 = new BankAccount(1, "One", 500, "");
		bank2 = new BankAccount(2, "Two", 1000, "");
	}
	
	// test toString()
	@Test
	public void testToString1() {
		String expected = "One: $500.00";
		String result = bank1.toString();
		
		assertEquals(expected, result);
	}
	@Test
	public void testToString2() {
		String expected = "Two: $1,000.00";
		String result = bank2.toString();
		
		assertEquals(expected, result);
	}

	// test transfer()
	@Test
	public void testTransfer1() {
		bank1.transfer(100, bank2);
		double expected = 400;
		double result = bank1.getBalance();
		
		assertEquals(expected, result, 0.01);
	}
	// test transfer()
		@Test
		public void testTransfer2() {
			bank1.transfer(100, bank2);
			double expected = 1100;
			double result = bank2.getBalance();
			
			assertEquals(expected, result, 0.01);
		}
	
	// test withdraw()
	@Test
	public void testWithdraw() {
		bank1.withdraw(250.01);
		double expected = 249.99;
		double result = bank1.getBalance();
		
		assertEquals(expected, result, 0.01);
	}
	
	// test deposit()
	@Test
	public void testDeposit() {
		bank1.deposit(550);
		double expected = 1050;
		double result = bank1.getBalance();
		
		assertEquals(expected, result, 0.01);
	}
}
