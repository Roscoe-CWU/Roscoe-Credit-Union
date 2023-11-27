package RCU;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerAccount extends Account {
	private int customerID;
	private ArrayList<BankAccount> bankAccounts;
	
	public CustomerAccount(String username, String password, String ssn, String firstName, String middleName,
			String lastName, String streetAddress, String city, String state, String zip, int accountID) {
		
		
		super(username, password, ssn, firstName, middleName, lastName, streetAddress, city, state, zip, accountID);
		this.customerID = accountID;
		bankAccounts = new ArrayList<BankAccount>();
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void addBankAccount(BankAccount account) {
		bankAccounts.add(account);
	}
	public void removeBankAccount(BankAccount account) {
		bankAccounts.remove(account);
	}
	public ArrayList<BankAccount> getBankAccounts() {
		ArrayList<BankAccount> temp = new ArrayList<BankAccount>();
		for(BankAccount bank : bankAccounts) {
			temp.add(bank);
		}
		return temp;
	}
}
