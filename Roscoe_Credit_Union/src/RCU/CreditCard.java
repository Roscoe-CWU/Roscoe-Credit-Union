package RCU;

public class CreditCard extends Card {
	private double outstandingBalance;
	private double creditLimit;
	
	/**
	 * constructor for CreditCard
	 * @param linkedAccountID
	 */
	public CreditCard(int linkedAccountID) {
		super(linkedAccountID);
		outstandingBalance = 0;
	}
	
	/**
	 * method to pay the outstanding balance for the card
	 * @param amount
	 */
	public void payCard(int amount) {
		outstandingBalance -= amount;
	}
	/**
	 * method to process a transaction by adding to the outstanding balance
	 * @param amount
	 */
	@Override
	public void transaction(int amount) {
		outstandingBalance += amount;
	}
	/**
	 * getter for outstandingBalance
	 * @return outstandingBalance
	 */
	public double getOutstandingBalance() {
		return outstandingBalance;
	}
	/**
	 * getter for creditLimit
	 */
	public double getCreditLimit() {
		return creditLimit;
	}
	/**
	 * setter for creditLimit
	 * @param amount
	 */
	public void setCreditLimit(double amount) {
		creditLimit = amount;
	}
}
