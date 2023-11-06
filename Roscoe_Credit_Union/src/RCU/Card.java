package RCU;

public abstract class Card {
	protected int linkedAccountID;
	protected int cardNumber;
	protected boolean isLocked;
	
	/**
	 * constructor for Card
	 * @param linkedAccountID
	 */
	public Card(int linkedAccountID) {
		this.linkedAccountID = linkedAccountID;
		//cardNumber = uniqueID;
	}
	
	/**
	 * abstract method for transactions
	 * @param amount
	 */
	public abstract void transaction(int amount);
	
	/**
	 * method to lock the card
	 */
	public void lockCard() {
		isLocked = true;
	}
	/**
	 * method to unlock the card
	 */
	public void unlockCard() {
		isLocked = false;
	}
	/**
	 * 
	 * @return if the card is currently locked
	 */
	public boolean isLocked() {
		return isLocked;
	}
	
	/**
	 * getter for linkedAccountID
	 * @return linkedAccountID
	 */
	public int getLinkedAccountID() {
		return linkedAccountID;
	}
	/**
	 * getter for cardNumber
	 * @return cardNumber
	 */
	public int getCardNumber() {
		return cardNumber;
	}
}
