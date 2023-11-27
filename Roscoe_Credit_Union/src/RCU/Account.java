package RCU;


public class Account {
	protected String username;
	protected String password;
	private String ssn;
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	protected int accountID;
	
	
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
	 * @param accountID
	 */
	public Account(String username, String password, String ssn, String firstName, String middleName,
			String lastName, String streetAddress, String city, String state, String zip, int accountID) {
		
		this.username = username;
		this.password = password;
		this.ssn = ssn;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.accountID = accountID;

	}
	
	/**
	 * getter for customerID
	 * @return customerID
	 */
	public int getAccountID() {
		return accountID;
	}
	/**
	 * getter for username
	 * @return customerID
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * getter for password
	 * @return firstName
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setter for password
	 * @return firstName
	 */
	public void setPassword(String pass) {
		password = pass;
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
	public String getSSN() {
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
	public String getZip() {
		return zip;
	}
	/**
	 * setter for zip
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * getter for bankAccounts
	 * @return bankAccounts
	 */
	
}
