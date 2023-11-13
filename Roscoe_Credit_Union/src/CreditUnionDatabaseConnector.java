import java.sql.*;

public class CreditUnionDatabaseConnector {

    private Connection con;

    // Constructor to initialize the database connection
    public CreditUnionDatabaseConnector() {
        initializeDBConnection();
    }

    // Initialize database connection
    private void initializeDBConnection() {
        String url = "jdbc:mysql://localhost:3306/mydb"; // Update with your database URL
        String userName = "yourUsername"; // Update with your database username
        String password = "yourPassword"; // Update with your database password

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

    // Helper method to retrieve account
    private Account getAccount(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setPersonAccountID(rs.getInt("personAccountID"));
                account.setFirstName(rs.getString("firstName"));
                account.setMiddleName(rs.getString("middleName"));
                account.setLastName(rs.getString("lastName"));
                account.setSSN(rs.getString("SSN"));
                account.setStreetAddress(rs.getString("streetAddress"));
                account.setCity(rs.getString("city"));
                account.setState(rs.getString("state"));
                account.setZipCode(rs.getString("zipCode"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
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

    public static void main(String[] args) {
        CreditUnionDatabaseConnector connector = new CreditUnionDatabaseConnector();
        // Test the connector here with various operations
    }
}

// We will need to create classes representing each table, e.g., 'Account', 'BankAccount', etc.
