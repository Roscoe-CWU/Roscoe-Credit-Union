package RCU;


public class BankAccount {
	private int bankAccountID;
	private String accountName;
	private double balance;
	private String accountSSN;
	private String accountType;
	
	/**
	 * more exansive constructor for BankAccount
	 * @param accountName
	 * @param accountSSN
	 * @param accountType
	 */
	public BankAccount(String accountName, String accountSSN, String accountType) {
		this.accountName = accountName;
		this.accountSSN = accountSSN;
		this.accountType = accountType;
	}
	/**
	 * getter for accountID
	 * @return accountID
	 */
	public int getBankAccountID() {
		return bankAccountID;
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
	public String getAccountSSN() {
		return accountSSN;
	}
	/**
	 * getter for accountType
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}
}