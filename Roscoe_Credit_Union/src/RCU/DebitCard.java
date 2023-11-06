package RCU;

public class DebitCard extends Card{

	/**
	 * constructor for DebitCard
	 * @param linkedAccountID
	 */
	public DebitCard(int linkedAccountID) {
		super(linkedAccountID);
	}

	/**
	 * method to perform a transaction by removing the money from the associated account
	 * @param amount
	 */
	@Override
	public void transaction(int amount) {
		// subtract amount from account in database
		// update balance in the application
	}
}
