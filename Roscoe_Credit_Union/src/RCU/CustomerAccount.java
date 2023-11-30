package RCU;

import java.util.ArrayList;


public class CustomerAccount extends Account {
	private int customerID;
	private ArrayList<BankAccount> bankAccounts;
	
	/**
	 * Constructor for CustomerAccount
	 * @param username
	 * @param password
	 * @param ssn
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param zip
	 * @param accountID
	 */
	public CustomerAccount(String username, String password, String ssn, String firstName, String middleName,
			String lastName, String streetAddress, String city, String state, String zip, int accountID) {
		
		
		super(username, password, ssn, firstName, middleName, lastName, streetAddress, city, state, zip, accountID);
		this.customerID = accountID;
		bankAccounts = new ArrayList<BankAccount>();
	}
	/**
	 * getter for customerID
	 * @return customerID
	 */
	public int getCustomerID() {
		return customerID;
	}
	/**
	 * method to add a bank account
	 * @param account
	 */
	public void addBankAccount(BankAccount account) {
		bankAccounts.add(account);
	}
	/**
	 * method to remove a bank account
	 * @param account
	 */
	public void removeBankAccount(BankAccount account) {
		bankAccounts.remove(account);
	}
	/**
	 * getter for bankAccounts
	 * @return bankAccounts
	 */
	public ArrayList<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	/**
	 * setter for username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
