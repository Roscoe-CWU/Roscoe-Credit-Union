package RCU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TellerUpdateAccountView {

	public JFrame frame;
	private JTextField firstName;
	private JTextField middleName;
	private JTextField lastName;
	private JTextField ssn;
	private JTextField streetAddress;
	private JTextField city;
	private JTextField zipCode;
	private JTextField username;
	private JTextField password;
	private JTextField state;

	/**
	 * Create the application.
	 */
	public TellerUpdateAccountView(CreditUnionDatabaseConnector connector) {
		initialize(connector);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(CreditUnionDatabaseConnector connector) {
		frame = new JFrame();
		frame.setTitle("Teller Create or Update Account");
		frame.setBounds(100, 100, 697, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][grow][grow][grow]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("First Name");
		panel.add(lblNewLabel, "cell 1 0");
		
		JLabel lblNewLabel_1 = new JLabel("Middle Name");
		panel.add(lblNewLabel_1, "cell 2 0");
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		panel.add(lblNewLabel_2, "cell 3 0");
		
		firstName = new JTextField();
		panel.add(firstName, "cell 1 1,growx");
		firstName.setColumns(10);
		
		
		middleName = new JTextField();
		panel.add(middleName, "cell 2 1,growx");
		middleName.setColumns(10);
		
		
		lastName = new JTextField();
		panel.add(lastName, "cell 3 1,growx");
		lastName.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("SSN");
		panel.add(lblNewLabel_3, "cell 1 2");
		
		JLabel lblNewLabel_4 = new JLabel("Street Address");
		panel.add(lblNewLabel_4, "cell 2 2");
		
		JLabel lblNewLabel_5 = new JLabel("City");
		panel.add(lblNewLabel_5, "cell 3 2");
		
		ssn = new JTextField();
		panel.add(ssn, "cell 1 3,growx");
		ssn.setColumns(10);
		
		
		streetAddress = new JTextField();
		panel.add(streetAddress, "cell 2 3,growx");
		streetAddress.setColumns(10);
		
		
		city = new JTextField();
		panel.add(city, "cell 3 3,growx");
		city.setColumns(10);
		
		
		JLabel lblNewLabel_6 = new JLabel("State");
		panel.add(lblNewLabel_6, "cell 1 4");
		
		JLabel lblNewLabel_7 = new JLabel("ZipCode");
		panel.add(lblNewLabel_7, "cell 2 4");
		
		state = new JTextField();
		panel.add(state, "cell 1 5,growx");
		state.setColumns(10);
		
		
		zipCode = new JTextField();
		panel.add(zipCode, "cell 2 5,growx");
		zipCode.setColumns(10);
		
		
		JLabel lblNewLabel_8 = new JLabel("Username");
		panel.add(lblNewLabel_8, "cell 1 6");
		
		JLabel lblNewLabel_9 = new JLabel("Password");
		panel.add(lblNewLabel_9, "cell 2 6");
		
		username = new JTextField();
		panel.add(username, "cell 1 7,growx");
		username.setColumns(10);
		
		
		password = new JTextField();
		panel.add(password, "cell 2 7,growx");
		password.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Create Customer Account");
		panel.add(btnNewButton, "cell 1 9");
		
		JButton btnNewButton_1 = new JButton("Close Window");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1, "cell 3 9");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstNameText = firstName.getText();
				String middleNameText = middleName.getText();
				String lastNameText = lastName.getText();
				String ssnText = ssn.getText();
				String streetAddressText = streetAddress.getText();
				String cityText = city.getText();
				String stateText = state.getText();
				String zipCodeText = zipCode.getText();
				String usernameText = username.getText();
				String passwordText = password.getText();
				
				if (ssnText.length() == 9 && ssnText.matches("\\d{9}")) {
					Account personAccount = connector.getAccountBySSN(ssnText);
					if (personAccount != null) {
						connector.updateAccount(personAccount.getAccountID(), firstNameText, middleNameText, lastNameText, ssnText, streetAddressText, cityText, stateText, zipCodeText, usernameText, passwordText);
						JOptionPane.showMessageDialog(null, "Sucess: Customer Account Updated", "Sucess", JOptionPane.INFORMATION_MESSAGE);
					} else {
						connector.addAccount(firstNameText, middleNameText, lastNameText, ssnText, streetAddressText, cityText, stateText, zipCodeText, usernameText, passwordText);
						
						Account personAccount2 = connector.getAccountBySSN(ssnText);
						
						connector.addCustomerAccount(personAccount2.getAccountID());
						
						JOptionPane.showMessageDialog(null, "Sucess: Customer Account Created", "Sucess", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Error: SSN not correct format" + ssnText, "Error", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Console output: " + firstNameText);
					System.out.println("Console output: " + middleNameText);
					System.out.println("Console output: " + lastNameText);
					System.out.println("Console output: " + ssnText);
					System.out.println("Console output: " + streetAddressText);
					System.out.println("Console output: " + cityText);
					System.out.println("Console output: " + stateText);
					System.out.println("Console output: " + zipCodeText);
					System.out.println("Console output: " + usernameText);
					System.out.println("Console output: " + passwordText);
				}
			}
		});
	}

}
