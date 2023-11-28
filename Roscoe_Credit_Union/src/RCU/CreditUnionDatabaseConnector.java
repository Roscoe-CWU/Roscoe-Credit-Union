package RCU;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreditUnionDatabaseConnector {

    private Connection con;

    // Constructor to initialize the database connection
    public CreditUnionDatabaseConnector() {
        initializeDBConnection();
    }

    // Initialize database connection
    private void initializeDBConnection() {
        String url = "jdbc:mysql://localhost:3306/mydb"; // Update with your database URL
        String userName = "root"; // Update with your database username
        String password = ""; // Update with your database password

        try {
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to establish connection");
        }
    }

    // Add an account to the 'Account' table
    public void addAccount(int personAccountID, String firstName, String middleName, String lastName, String SSN, String streetAddress, String city, String state, String zipCode, String username, String password) {
        String query = "INSERT INTO Account (personAccountID, firstName, middleName, lastName, SSN, streetAddress, city, state, zipCode, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, personAccountID);
            pstmt.setString(2, firstName);
            pstmt.setString(3, middleName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, SSN);
            pstmt.setString(6, streetAddress);
            pstmt.setString(7, city);
            pstmt.setString(8, state);
            pstmt.setString(9, zipCode);
            pstmt.setString(10, username);
            pstmt.setString(11, password);
            pstmt.executeUpdate();
            System.out.println("Account added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add account");
        }
    }

    // Get an account from the 'Account' table by personAccountID
    public Account getAccountByPersonID(int personAccountID) {
        String query = "SELECT * FROM Account WHERE personAccountID = ?";
        return getAccount(query, personAccountID);
    }

    // Get an account from the 'Account' table by username and password
    public Account getAccountByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM Account WHERE username = ? AND password = ?";
        return getAccount(query, username, password);
    }
    
    // Get an account from the 'Account' table by SSN
    public Account getAccountBySSN(String SSN) {
        String query = "SELECT * FROM Account WHERE SSN = ?";
        return getAccount(query, SSN);
    }

    // Helper method to retrieve account
    private Account getAccount(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getString("username"), rs.getString("password"), rs.getString("SSN"), rs.getString("firstName"), rs.getString("middleName"), rs.getString("lastName"), rs.getString("streetAddress"), rs.getString("city"), rs.getString("state"), rs.getString("zipCode"), rs.getInt("personAccountID"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to retrieve account");
        }
        return null; // If not found
    }

 // Update an account in the 'Account' table
    public void updateAccount(int personAccountID, String firstName, String middleName, String lastName, String SSN, String streetAddress, String city, String state, String zipCode, String username, String password) {
        String query = "UPDATE Account SET firstName = ?, middleName = ?, lastName = ?, SSN = ?, streetAddress = ?, city = ?, state = ?, zipCode = ?, username = ?, password = ? WHERE personAccountID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, middleName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, SSN);
            pstmt.setString(5, streetAddress);
            pstmt.setString(6, city);
            pstmt.setString(7, state);
            pstmt.setString(8, zipCode);
            pstmt.setString(9, username);
            pstmt.setString(10, password);
            pstmt.setInt(11, personAccountID);
            pstmt.executeUpdate();
            System.out.println("Account updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update account");
        }
    }

    // Delete an account from the 'Account' table
    public void deleteAccount(int personAccountID) {
        String query = "DELETE FROM Account WHERE personAccountID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, personAccountID);
            pstmt.executeUpdate();
            System.out.println("Account deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete account");
        }
    }

    // Methods for other tables (BankAccount, Customer, CreditCard, DebitCard, Manager, Teller) will be similar in structure
    // Implement them following the same pattern as above

    /*public static void main(String[] args) {
        CreditUnionDatabaseConnector connector = new CreditUnionDatabaseConnector();
        // Test the connector here with various operations
    }*/




    // CUSTOMER ACCOUNT METHODS
    
    public boolean isCustomer(int personAccountID) {
        String query = "SELECT COUNT(*) FROM Customer WHERE customerID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, personAccountID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Check if the count is greater than 0
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally handle the exception more gracefully
        }
        return false; // Return false if no record found or in case of exception
    }

    
    
    
    public boolean isTeller(int personAccountID) {
        String query = "SELECT COUNT(*) FROM Teller WHERE employeeID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, personAccountID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Check if the count is greater than 0
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally handle the exception more gracefully
        }
        return false; // Return false if no record found or in case of exception
    }
    
    
    
    public boolean isManager(int personAccountID) {
        String query = "SELECT COUNT(*) FROM Manager WHERE accountID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, personAccountID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Check if the count is greater than 0
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally handle the exception more gracefully
        }
        return false; // Return false if no record found or in case of exception
    }






    public List<BankAccount> getBankAccounts(CustomerAccount customer, int accountID) {
        String query = "SELECT * FROM BankAccount WHERE accountID = ?";
        List<BankAccount> bankAccounts = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, accountID); // Set the accountID parameter
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Assuming BankAccount has a constructor that takes ResultSet
            	customer.addBankAccount(new BankAccount(
                    rs.getInt("accountID"),
                    rs.getString("accountName"),
                    rs.getDouble("balance"),
                    rs.getString("AccountType")
                ));
                //bankAccounts.add(bankAccount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to retrieve bank accounts");
        }

        return bankAccounts; // This will be empty if no accounts found or on error
    }




    // ACCOUNT GETTER AND SETTERS

    public void updateAccountFirstName(int personAccountID, String newFirstName) {
        String query = "UPDATE Account SET firstName = ? WHERE personAccountID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, newFirstName);
            pstmt.setInt(2, personAccountID);
            pstmt.executeUpdate();
            System.out.println("First Name updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update First Name");
        }
    }
    public void updateAccountLastName(int personAccountID, String newLastName) {
        String query = "UPDATE Account SET lastName = ? WHERE personAccountID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, newLastName);
            pstmt.setInt(2, personAccountID);
            pstmt.executeUpdate();
            System.out.println("Last Name updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update Last Name");
        }
    }
    public void updateAccountAddress(int personAccountID, String newStreet, String newCity, String newState, String newZip) {
        String query = "UPDATE Account SET streetAddress = ?, city = ?, state = ?, zipCode = ? WHERE personAccountID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, newStreet);
            pstmt.setString(2, newCity);
            pstmt.setString(3, newState);
            pstmt.setString(4, newZip);
            pstmt.setInt(5, personAccountID);
            pstmt.executeUpdate();
            System.out.println("Address updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update Address");
        }
    }

    // CUSTOMER ACCOUNT GETTER AND SETTERS

    
    
    // BANK ACCOUNT GETTER AND SETTERS
    
    public void updateBankAccountBalance(int bankAccountID, String accountName, double newBalance) {
        String query = "UPDATE BankAccount SET balance = ? WHERE accountID = ? && accountName = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, bankAccountID);
            pstmt.setString(3, accountName);
            pstmt.executeUpdate();
            System.out.println("Balance updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update Balance");
        }
    }
    public void updateBankAccountName(int bankAccountID, String prevAccountName, String newAccountName) {
        String query = "UPDATE BankAccount SET accountName = ? WHERE accountID = ? && accountName = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, newAccountName);
            pstmt.setInt(2, bankAccountID);
            pstmt.setString(3, prevAccountName);
            pstmt.executeUpdate();
            System.out.println("Balance updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update Balance");
        }
    }
    
    
    public void deleteBankAccount(int bankAccountID, String accountName) {
    	String query = "DELETE FROM BankAccount WHERE accountID = ? && accountName = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
        	pstmt.setInt(1, bankAccountID);
            pstmt.setString(2, accountName);
            pstmt.executeUpdate();
            System.out.println("Bank Account deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete Bank Account");
        }
    }
    public void addBankAccount(int bankAccountID, String accountName, double balance, String accountType) {
    	String query = "INSERT INTO BankAccount (accountID, accountName, balance, AccountType) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, bankAccountID);
            pstmt.setString(2, accountName);
            pstmt.setDouble(3, balance);
            pstmt.setString(4, accountType);
            pstmt.executeUpdate();
            System.out.println("Account added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add account");
        }
    }

    // CARD GETTER AND SETTERS

    // CREDIT CARD GETTER AND SETTERS

    // DEBIT CARD GETTER AND SETTERS


}