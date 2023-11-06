package RCU;

import java.util.List;
import java.util.ArrayList;

public class CustomerAccount extends Account {
	private int customerID;
	private String streetAddress;
	private String firstName;
	private String middleName;
	private String lastName;
	private int ssn;
	private String city;
	private String state;
	private int zip;
	private List<BankAccount> bankAccounts;
	
	/**
	 * Minimal constructor for Customer Account
	 * @param username
	 * @param password
	 * @param ssn
	 */
	public CustomerAccount(String username, String password, int ssn) {
		super(username, password);
		this.ssn = ssn;
		// bankAccountID = uniqueNumber
		bankAccounts = new ArrayList<BankAccount>();
	}
	/**
	 * More expansive constructor for Customer Account
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
	 */
	public CustomerAccount(String username, String password, int ssn, String firstName, String middleName, String lastName, String streetAddress, String city, String state, int zip) {
		super(username, password);
		this.ssn = ssn;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		// bankAccountID = uniqueNumber
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
	 * getter for firstName
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * setter for firstName
	 * @param firstName
	 */
	public void setFirstName(String name) {
		firstName = name;
	}
	/**
	 * getter for middleName
	 * @return middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * setter for middleName
	 * @param middleName
	 */
	public void setMiddleName(String name) {
		middleName = name;
	}
	/**
	 * getter for lastName
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * setter for lastName
	 * @param lastName
	 */
	public void setLastName(String name) {
		lastName = name;
	}
	/**
	 * getter for ssn
	 * @return ssn
	 */
	public int getSSN() {
		return ssn;
	}
	/**
	 * getter for streetAddress
	 * @return streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * setter for streetAddress
	 * @param streetAddress
	 */
	public void setStreetAddress(String streetAdd) {
		streetAddress = streetAdd;
	}
	/**
	 * getter for city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * setter for city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * getter for state
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * setter for state
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * getter for zip
	 * @return zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * setter for zip
	 * @param zip
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * getter for bankAccounts
	 * @return bankAccounts
	 */
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	
	/**
	 * method to add to bankAccounts
	 * @param account
	 */
	public void addBankAccount(BankAccount account) {
		bankAccounts.add(account);
	}
	/**
	 * method to remove from bankAccounts
	 * @param account
	 */
	public void removeBankAccount(BankAccount account) {
		bankAccounts.remove(account);
	}
}
