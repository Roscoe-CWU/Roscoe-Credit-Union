package RCU;

public class Account {
	protected String username;
	protected String password;
	
	/**
	 * constructor for Account
	 * @param username
	 * @param password
	 */
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * getter for username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * setter for username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * getter for password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
