package RCU;

import java.util.List;
import java.util.ArrayList;

public class BankAccount {
	private int accountID;
	private String accountName;
	private double balance;
	private int accountSSN;
	private String accountType;
	private List<CreditCard> creditCards;
	private List<DebitCard> debitCards;
	
	/**
	 * minimal constructor for BankAccount
	 * @param type
	 */
	public BankAccount(String type) {
		accountType = type;
		creditCards = new ArrayList<CreditCard>();
		debitCards = new ArrayList<DebitCard>();
	}
	/**
	 * more exansive constructor for BankAccount
	 * @param accountName
	 * @param accountSSN
	 * @param accountType
	 */
	public BankAccount(String accountName, int accountSSN, String accountType) {
		this.accountName = accountName;
		this.accountSSN = accountSSN;
		this.accountType = accountType;
		creditCards = new ArrayList<CreditCard>();
		debitCards = new ArrayList<DebitCard>();
	}
	/**
	 * getter for accountID
	 * @return accountID
	 */
	public int getAccountID() {
		return accountID;
	}
	/**
	 * getter for accountName
	 * @return accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * setter for accountName
	 * @param name
	 */
	public void setAccountName(String name) {
		accountName = name;
	}
	/**
	 * getter for balance
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * method to deposit money into account
	 * @param amount
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	/**
	 * method to withdraw money from account
	 * @param amount
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}
	/**
	 * method to transfer money to another account
	 * @param amount
	 * @param account
	 */
	public void transfer(double amount, BankAccount account) {
		withdraw(amount);
		account.deposit(amount);
	}
	/**
	 * getter for accountSSN
	 * @return accountSSN
	 */
	public int getAccountSSN() {
		return accountSSN;
	}
	/**
	 * getter for accountType
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * getter for creditCards
	 * @return creditCards
	 */
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	/**
	 * getter for debitCards
	 * @return debitCards
	 */
	public List<DebitCard> getDebitCards() {
		return debitCards;
	}
}
