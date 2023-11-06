package RCU;

public class CreditCard extends Card {
	private String dueDate;
	private double outstandingBalance;
	
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
}
