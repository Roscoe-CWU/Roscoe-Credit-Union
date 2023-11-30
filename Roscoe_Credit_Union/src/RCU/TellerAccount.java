package RCU;

public class TellerAccount extends Account{

	/**
	 * constructor for TellerAccount
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
	public TellerAccount(String username, String password, String ssn, String firstName, String middleName,
			String lastName, String streetAddress, String city, String state, String zip, int accountID) {
		super(username, password, ssn, firstName, middleName, lastName, streetAddress, city, state, zip, accountID);
	}
}
