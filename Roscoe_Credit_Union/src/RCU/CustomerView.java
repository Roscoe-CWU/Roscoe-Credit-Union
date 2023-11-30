package RCU;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;


import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.*;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.text.NumberFormat;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerView {

	private CustomerAccount account;
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
	// different sizes of logo
	private static final ImageIcon logo50 = new ImageIcon(CustomerView.class.getResource("/resources/Logo-50x50.png"));
	private static final ImageIcon logo100 = new ImageIcon(CustomerView.class.getResource("/resources/Logo-100x100.png"));
	private static final ImageIcon logo500 = new ImageIcon(CustomerView.class.getResource("/resources/Logo-500x500.png"));
	
	
	public JFrame frame;
	private JPanel panelBanks;
	private JLabel lblRCU;
	private JButton btnLogOut;
	private JScrollPane scrollPane;
	private JLabel lblUser;
	private JLabel lblLoggedInAs;
	private GridBagLayout gbl_panelBanks;
	private JPanel panelBtns;
	private JButton btnChngAddress;
	private JButton btnTransfer;
	private JButton btnChngName;
	private JButton btnAddBank;
	private JButton btnChngBankName;
	private JButton btnRemoveBankAccount;
	

	/**
	 * Create the application.
	 */
	public CustomerView(CreditUnionDatabaseConnector connector, CustomerAccount account) {
		this.account = account;
		ArrayList<BankAccount> bankAccounts = (ArrayList<BankAccount>) connector.getBankAccounts(account, account.getAccountID());
		System.out.println();
		for (BankAccount bank : bankAccounts) {
			account.addBankAccount(bank);
			System.out.println(bank);
		}
		
		
		initialize(connector);
		
		updateBankList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(CreditUnionDatabaseConnector connector) {
		// Main JFrame
		frame = new JFrame("Roscoe Credit Union");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerView.class.getResource("/resources/Logo-50x50.png")));
		frame.setBounds(100, 100, 808, 473);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Title label
		lblRCU = new JLabel("Roscoe Credit Union");
		lblRCU.setForeground(new Color(0, 0, 128));
		lblRCU.setFont(new Font("Tahoma", Font.BOLD, 64));
		lblRCU.setIcon(logo100);
		
		// Log Out button
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(new Color(0, 0, 255));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Close CustomerView
		        frame.setVisible(false);
		        frame.dispose();
		        
		     // Show the singleton instance of LogInWindow
		        LogInWindow loginWindow = LogInWindow.getInstance(connector);
		        loginWindow.getFrame().setVisible(true);
			}
		});
		btnLogOut.setForeground(new Color(0, 0, 255));
		
		// Scroll Pane for bank accounts
		scrollPane = new JScrollPane();
		
		// Says who is logged in
		lblLoggedInAs = new JLabel("Logged in as:");
		
		lblUser = new JLabel(account.getFirstName() + " " + account.getLastName());
		lblUser.setForeground(SystemColor.textHighlight);
		
		// Panel to group buttons together
		panelBtns =  new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(panelBtns, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblRCU)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLoggedInAs)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUser)
							.addPreferredGap(ComponentPlacement.RELATED, 518, Short.MAX_VALUE)
							.addComponent(btnLogOut)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogOut)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLoggedInAs)
							.addComponent(lblUser)))
					.addGap(9)
					.addComponent(lblRCU)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(panelBtns, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		GridBagLayout gbl_panelBtns = new GridBagLayout();
		gbl_panelBtns.columnWidths = new int[] {0, 0};
		gbl_panelBtns.rowHeights = new int[] {30, 30, 30, 30};
		gbl_panelBtns.columnWeights = new double[]{1.0, 0.0};
		gbl_panelBtns.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		panelBtns.setLayout(gbl_panelBtns);
		
		// Button to transfer money between accounts
		btnTransfer = new JButton("Make a Transfer");
		btnTransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Object[] bankAccounts = account.getBankAccounts().toArray();
				
				// Dropdown menus
				JComboBox<Object> firstList = new JComboBox<Object>(bankAccounts);
				JComboBox<Object> secondList = new JComboBox<Object>(bankAccounts);
				JTextField amountTxt = new JTextField(10);
				
				GridBagLayout gbl = new GridBagLayout();
				gbl.columnWidths = new int[]{0, 0, 0};
				gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
				gbl.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
				JPanel panel = new JPanel();
				panel.setLayout(gbl);
				
				
				// Account to transfer from
				GridBagConstraints gbcFirstLbl = new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcFirstList = new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 5), 0, 0);
				panel.add(new JLabel("Select the account to transfer from: "), gbcFirstLbl);
				panel.add(firstList, gbcFirstList);
				
				// Account to transfer to
				GridBagConstraints gbcSecondLbl = new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcSecondList = new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 5), 0, 0);
				panel.add(new JLabel("Select the account to transfer to: "), gbcSecondLbl);
				panel.add(secondList, gbcSecondList);
				
				// AMmount to transfer
				GridBagConstraints gbcAmountLbl = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcAmountTxt = new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				panel.add(new JLabel("Enter the amount to transfer: $"), gbcAmountLbl);
				panel.add(amountTxt, gbcAmountTxt);
				
				// Check for valid input
				int result = JOptionPane.showConfirmDialog(null, panel, "Make a Transfer", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, logo100);
				
				if (result == JOptionPane.OK_OPTION) {
					double amount = 0;
					try {
						// Parse the amount
						amount = Double.parseDouble(amountTxt.getText());
					} catch (NumberFormatException ex) {
						
					}
					// Get the bank accounts from the list
					BankAccount firstAccount = account.getBankAccounts().get(firstList.getSelectedIndex());
					BankAccount secondAccount = account.getBankAccounts().get(secondList.getSelectedIndex());
					
					if (firstAccount.getBalance() >= amount) {
						// Confirmation pop up
						int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to transfer " + formatter.format(amount) + " from " + firstAccount + " to " + secondAccount + "?",
								"Confirm Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logo50);
						if (confirm == JOptionPane.YES_OPTION) {
							// Transfer the money
							firstAccount.transfer(amount, secondAccount);
							
							// Update the database
							connector.updateBankAccountBalance(account.getAccountID(), firstAccount.getAccountName(), firstAccount.getBalance());
							connector.updateBankAccountBalance(account.getAccountID(), secondAccount.getAccountName(), secondAccount.getBalance());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Not Enough Funds");
					}
				}
				// Update the bank list
				updateBankList();
			}
		});

		// Transfer button constraints
		btnTransfer.setForeground(new Color(0, 0, 128));
		GridBagConstraints gbc_btnTransfer = new GridBagConstraints();
		gbc_btnTransfer.insets = new Insets(0, 5, 5, 0);
		gbc_btnTransfer.gridx = 1;
		gbc_btnTransfer.gridy = 0;
		gbc_btnTransfer.fill = GridBagConstraints.HORIZONTAL;
		panelBtns.add(btnTransfer, gbc_btnTransfer);
		
		
		// Button to change account name
		btnChngBankName = new JButton("Change Account Name");
		btnChngBankName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] bankAccounts = account.getBankAccounts().toArray();
				
				// Drop down menu for accounts
				JComboBox<Object> accountList = new JComboBox<Object>(bankAccounts);
				// New account name field
				JTextField accountName = new JTextField(10);
				
				GridBagLayout gbl = new GridBagLayout();
				gbl.columnWidths = new int[]{0, 0, 0};
				gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
				gbl.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
				JPanel panel = new JPanel();
				panel.setLayout(gbl);
				
				
				
				
				// Account selection
				GridBagConstraints gbcAccountLbl = new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcAccountList = new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 5), 0, 0);
				panel.add(new JLabel("Select the account you want to change the name of: "), gbcAccountLbl);
				panel.add(accountList, gbcAccountList);
				
				// Name text field
				GridBagConstraints gbcNameLbl = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcNameTxt = new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				panel.add(new JLabel("Enter the name of the account: "), gbcNameLbl);
				panel.add(accountName, gbcNameTxt);
				
				
				// Check input
				int result = JOptionPane.showConfirmDialog(null, panel, "Change Account Name", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, logo100);
				
				boolean isUnique = true;
				
				
				for (BankAccount bank : account.getBankAccounts()) {
					if (bank.getAccountName().equals(accountName.getText())) {
						isUnique = false;
						JOptionPane.showMessageDialog(null, "Name Must Be Unique");
					}
				}
				
				if (result == JOptionPane.OK_OPTION) {
					if(!accountName.getText().isBlank()) {
						if (isUnique) {
							// Change name
							account.getBankAccounts().get(accountList.getSelectedIndex()).setAccountName(accountName.getText());
							// Update database
							connector.updateBankAccountName(account.getAccountID(), account.getBankAccounts().get(accountList.getSelectedIndex()).getAccountName(), accountName.getText());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Name Cannot be Blank");
					}
				}
				// Update bank list
				updateBankList();
			}
		});
		
		// Change bank name constraints
		btnChngBankName.setForeground(new Color(0, 0, 128));
		GridBagConstraints gbc_btnChngBankName = new GridBagConstraints();
		gbc_btnChngBankName.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChngBankName.insets = new Insets(0, 0, 5, 5);
		gbc_btnChngBankName.gridx = 0;
		gbc_btnChngBankName.gridy = 0;
		panelBtns.add(btnChngBankName, gbc_btnChngBankName);
		
		
		// Button to change customer name
		btnChngName = new JButton("Change Name");
		btnChngName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Text fields for password and name
				JTextField password = new JTextField(15);
				JTextField newFname = new JTextField(15);
				JTextField newLname = new JTextField(15);
				GridBagLayout gbl = new GridBagLayout();
				gbl.columnWidths = new int[]{0, 0, 0};
				gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
				gbl.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
				JPanel panel = new JPanel();
				panel.setLayout(gbl);
				
				// Password text field
				GridBagConstraints gbcPasswordLbl = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcPasswordTxt = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				panel.add(new JLabel("Enter password: "),  gbcPasswordLbl);
				panel.add(password, gbcPasswordTxt);
				
				// First name text field
				GridBagConstraints gbcFirstNameLbl = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(10, 5, 0, 5), 0, 0);
				GridBagConstraints gbcFirstNameTxt = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(10, 5, 0, 5), 0, 0);
				panel.add(new JLabel("Enter your new First Name: "), gbcFirstNameLbl);
				panel.add(newFname, gbcFirstNameTxt);
				
				// Last name text field
				GridBagConstraints gbcLastNameLbl = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcLastNameTxt = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				panel.add(new JLabel("Enter your new Last Name: "), gbcLastNameLbl);
				panel.add(newLname, gbcLastNameTxt);
				
				// Check input
				int result = JOptionPane.showConfirmDialog(null, panel, "Change Your Name", JOptionPane.OK_CANCEL_OPTION,
						 JOptionPane.PLAIN_MESSAGE, logo100);
				if (result == JOptionPane.OK_OPTION) {
					if (password.getText().equals(account.getPassword())) {
						if (!newFname.getText().isBlank() && !newLname.getText().isBlank()) {
							// Change name
							account.setFirstName(newFname.getText());
							account.setLastName(newLname.getText());
							
							// Update database
							connector.updateAccountFirstName(account.getAccountID(), newFname.getText());
							connector.updateAccountLastName(account.getAccountID(), newLname.getText());
							
							lblUser.setText(account.getFirstName() + " " + account.getLastName());
						} else {
							JOptionPane.showMessageDialog(null, "Field Cannot be Left Blank");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Password");
					}
				} 
			}
		});
		
		// Change name constraints
		btnChngName.setForeground(new Color(0, 0, 128));
		GridBagConstraints gbc_btnChngName = new GridBagConstraints();
		gbc_btnChngName.insets = new Insets(5, 0, 5, 5);
		gbc_btnChngName.gridx = 0;
		gbc_btnChngName.gridy = 2;
		gbc_btnChngName.fill = GridBagConstraints.HORIZONTAL;
		panelBtns.add(btnChngName, gbc_btnChngName);
		
		// Button to add a bank account
		btnAddBank = new JButton("Add Bank Account");
		btnAddBank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Text field for name of account
				JTextField name = new JTextField(15);
				
				// Drop down to select type of account
				String[] accountTypes = new String[3];
				accountTypes[0] = "CHECKING";
				accountTypes[1] = "SAVINGS";
				accountTypes[2] = "CREDIT";
				JComboBox<String> typeList = new JComboBox<String>(accountTypes);
				
				GridBagLayout gbl = new GridBagLayout();
				gbl.columnWidths = new int[]{0, 0, 0};
				gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
				gbl.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
				JPanel panel = new JPanel();
				panel.setLayout(gbl);

				// Name text field
				GridBagConstraints gbcNewStreetLbl = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(10, 5, 0, 5), 0, 0);
				GridBagConstraints gbcNewStreetTxt = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(10, 5, 0, 5), 0, 0);
				panel.add(new JLabel("Name of Account: "), gbcNewStreetLbl);
				panel.add(name, gbcNewStreetTxt);
				
				// Account type selection
				GridBagConstraints gbcTypeLbl = new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcTypeList = new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 5), 0, 0);
				panel.add(new JLabel("Select the account type: "), gbcTypeLbl);
				panel.add(typeList, gbcTypeList);
				
				
				// Check input
				boolean isUnique = true;
				
				int result = JOptionPane.showConfirmDialog(null, panel, "Add a Bank Account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
						logo100);
				for (BankAccount bank : account.getBankAccounts()) {
					if (bank.getAccountName().equals(name.getText())) {
						isUnique = false;
						JOptionPane.showMessageDialog(null, "Name Must Be Unique");
					}
				}
				if (result == JOptionPane.OK_OPTION) {
					if (!name.getText().isBlank()) {
						if (isUnique) {
							// Add bank account
							account.addBankAccount(new BankAccount(account.getAccountID(), name.getText(), 0, (String)typeList.getSelectedItem()));
							// Update data base
							connector.addBankAccount(account.getAccountID(), name.getText(), 0, (String)typeList.getSelectedItem());
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Name Cannot Be Blank");
					}
				}
				updateBankList();
			}
		});

		// Add bank constraints
		btnAddBank.setForeground(new Color(0, 0, 128));
		GridBagConstraints gbc_btnAddBank = new GridBagConstraints();
		gbc_btnAddBank.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddBank.insets = new Insets(5, 0, 5, 5);
		gbc_btnAddBank.gridx = 0;
		gbc_btnAddBank.gridy = 3;
		panelBtns.add(btnAddBank, gbc_btnAddBank);
		
		// Button to change address
		btnChngAddress = new JButton("Change Address");
		btnChngAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Field for current address
				JTextPane currAddress = new JTextPane();
				currAddress.setEditable(false);
				currAddress.setOpaque(false);
				
				// Text fields for password and address
				JTextField password = new JTextField(15);
				JTextField newStreet = new JTextField(15);
				JTextField newCity = new JTextField(15);
				JTextField newZip = new JTextField(15);
				JTextField newState = new JTextField(15);
				GridBagLayout gbl = new GridBagLayout();
				gbl.columnWidths = new int[]{0, 0, 0};
				gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
				gbl.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
				JPanel panel = new JPanel();
				panel.setLayout(gbl);
				
				// Show current address
				GridBagConstraints gbcCurAddressTxt = new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0);
				currAddress.setText("Your Current Address is:\n" + 
						account.getStreetAddress() + "\n" +
						account.getCity() + "\n" +
						account.getState() + " " + account.getZip());
				SimpleAttributeSet sasBold = new SimpleAttributeSet();
				StyleConstants.setBold(sasBold, true);
				StyleConstants.setForeground(sasBold, SystemColor.textHighlight);
				currAddress.getStyledDocument().setCharacterAttributes(0, 24, sasBold, false);
				panel.add(currAddress, gbcCurAddressTxt);
				
				// Password text field
				GridBagConstraints gbcPasswordLbl = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcPasswordTxt = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				panel.add(new JLabel("Enter password: "),  gbcPasswordLbl);
				panel.add(password, gbcPasswordTxt);
				
				// Street address text field
				GridBagConstraints gbcNewStreetLbl = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(10, 5, 0, 5), 0, 0);
				GridBagConstraints gbcNewStreetTxt = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(10, 5, 0, 5), 0, 0);
				panel.add(new JLabel("Street Address: "), gbcNewStreetLbl);
				panel.add(newStreet, gbcNewStreetTxt);
				
				// City text field
				GridBagConstraints gbcNewCityLbl = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0);
				GridBagConstraints gbcNewCityTxt = new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0);
				panel.add(new JLabel("City: "), gbcNewCityLbl);
				panel.add(newCity, gbcNewCityTxt);
				
				// State text field
				GridBagConstraints gbcNewStateLbl = new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcNewStateTxt = new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				panel.add(new JLabel("State: "), gbcNewStateLbl);
				panel.add(newState, gbcNewStateTxt);
				
				// Zip Code text field
				GridBagConstraints gbcNewZipLbl = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0);
				GridBagConstraints gbcNewZipTxt = new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0);
				panel.add(new JLabel("Zip Code: "), gbcNewZipLbl);
				panel.add(newZip, gbcNewZipTxt);
				
				
				// Check input
				int result = JOptionPane.showConfirmDialog(null, panel, "Change Your Address", JOptionPane.OK_CANCEL_OPTION,
						 JOptionPane.PLAIN_MESSAGE, logo50);
				if (result == JOptionPane.OK_OPTION) {
					if (password.getText().equals(account.getPassword())) {
						if (!newStreet.getText().isBlank() && !newCity.getText().isBlank() && !newZip.getText().isBlank() && !newState.getText().isBlank()) {
							// Update address
							account.setStreetAddress(newStreet.getText());
							account.setCity(newCity.getText());
							account.setZip(newZip.getText());
							account.setState(newState.getText());
							
							// Update date base
							connector.updateAccountAddress(account.getAccountID(), newStreet.getText(), newCity.getText(), newState.getText(), newZip.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Field Cannot be Left Blank");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Password");
					}
				} 
			}
			
		});
		btnChngAddress.setForeground(new Color(0, 0, 128));
		
		// Change address constraints
		GridBagConstraints gbc_btnChngAddress = new GridBagConstraints();
		gbc_btnChngAddress.insets = new Insets(5, 5, 5, 0);
		gbc_btnChngAddress.gridx = 1;
		gbc_btnChngAddress.gridy = 2;
		gbc_btnChngAddress.fill = GridBagConstraints.HORIZONTAL;
		panelBtns.add(btnChngAddress, gbc_btnChngAddress);
		
		
		// Button to remove bank account 
		btnRemoveBankAccount = new JButton("Remove Bank Account");
		btnRemoveBankAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] bankAccounts = account.getBankAccounts().toArray();
				
				// Drop down menus for bank accounts
				JComboBox<Object> removeList = new JComboBox<Object>(bankAccounts);
				JComboBox<Object> transferList = new JComboBox<Object>(bankAccounts);
				
				GridBagLayout gbl = new GridBagLayout();
				gbl.columnWidths = new int[]{0, 0, 0};
				gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
				gbl.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
				JPanel panel = new JPanel();
				panel.setLayout(gbl);
				
				
				// Bank account to be removed selection
				GridBagConstraints gbcRemoveLbl = new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcRemoveList = new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 5), 0, 0);
				panel.add(new JLabel("Select the account to remove: "), gbcRemoveLbl);
				panel.add(removeList, gbcRemoveList);
				
				// Account to transfer money to
				GridBagConstraints gbcTransferLbl = new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
				GridBagConstraints gbcTransferList = new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 5), 0, 0);
				panel.add(new JLabel("Select the account to transfer the remaining balance to: "), gbcTransferLbl);
				panel.add(transferList, gbcTransferList);
				
				
				// Check input
				int result = JOptionPane.showConfirmDialog(null, panel, "Remove a Bank Account", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, logo100);
				
				if (result == JOptionPane.OK_OPTION) {
					BankAccount removeBank = account.getBankAccounts().get(removeList.getSelectedIndex());
					BankAccount transferBank = account.getBankAccounts().get(transferList.getSelectedIndex());
					if (!removeBank.equals(transferBank)) {
						// Transfer money and remove bank account
						removeBank.transfer(removeBank.getBalance(), transferBank);
						account.getBankAccounts().remove(removeBank);
						
						// Update data base
						connector.updateBankAccountBalance(account.getAccountID(), transferBank.getAccountName(), transferBank.getBalance());
						connector.deleteBankAccount(account.getAccountID(), removeBank.getAccountName());
					} else {
						JOptionPane.showMessageDialog(null, "Cannot Transfer to Account Being Deleted");
					}
				}
				// Update bank account list
				updateBankList();
			}
		});
		
		// Remove bank constraints
		btnRemoveBankAccount.setForeground(new Color(0, 0, 128));
		GridBagConstraints gbc_btnRemoveBankAccount = new GridBagConstraints();
		gbc_btnRemoveBankAccount.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemoveBankAccount.insets = new Insets(5, 5, 5, 0);
		gbc_btnRemoveBankAccount.gridx = 1;
		gbc_btnRemoveBankAccount.gridy = 3;
		panelBtns.add(btnRemoveBankAccount, gbc_btnRemoveBankAccount);
		
		
		
		
		frame.getContentPane().setLayout(groupLayout);
	}

	/**
	 * getter for the frame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Update the bank list view whenever changes happen
	 * by recreating the view entirely
	 */
	public void updateBankList() {
		// Panel that goes inside of scroll pane
		panelBanks = new JPanel();
		scrollPane.setViewportView(panelBanks);
		gbl_panelBanks = new GridBagLayout();
		gbl_panelBanks.columnWidths = new int[]{0};
		gbl_panelBanks.rowHeights = new int[]{0};
		gbl_panelBanks.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelBanks.rowWeights = new double[]{Double.MIN_VALUE};
		panelBanks.setLayout(gbl_panelBanks);

		// Get bank accounts
		ArrayList<BankAccount> bankAccounts = account.getBankAccounts();
		
		// Print each account onto the panel as a textpane
		int gridy = 0;
		for (BankAccount bank : bankAccounts) {
			JTextPane textPaneL = new JTextPane();
			GridBagConstraints gbcL = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0);
			textPaneL.setText(bank.getAccountName() + " (" + bank.getAccountType() + ")\nBalance:" + "\n");
			SimpleAttributeSet sasBold = new SimpleAttributeSet();
			StyleConstants.setBold(sasBold, true);
			StyleConstants.setForeground(sasBold, SystemColor.textHighlight);
			textPaneL.getStyledDocument().setCharacterAttributes(0, bank.getAccountName().length() + bank.getAccountType().length() + 3, sasBold, false);
			textPaneL.setEditable(false);
			panelBanks.add(textPaneL, gbcL);
			
			
			
			StyleContext context = new StyleContext();
		    StyledDocument document = new DefaultStyledDocument(context);

		    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
		    StyleConstants.setAlignment(style, StyleConstants.ALIGN_RIGHT);

		    try {
				document.insertString(document.getLength(), "\n" + formatter.format(bank.getBalance()) + "\n", style);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			
			
		    JTextPane textPaneR = new JTextPane(document);
			GridBagConstraints gbcR = new GridBagConstraints(1, gridy, 1, 1, 1, 1, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0);
			
			textPaneR.setText("\n" + formatter.format(bank.getBalance()) + "\n");
			textPaneR.setEditable(false);
			panelBanks.add(textPaneR, gbcR);
			
			gridy++;
		}
		// filler text panes for formatting
		if (bankAccounts.size() < 4) {
			for (int i = 0; i < (4 - bankAccounts.size()); i++) {
				JTextPane textPaneL = new JTextPane();
				GridBagConstraints gbcL = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0);
				textPaneL.setText("\n\n");
				textPaneL.setOpaque(false);
				textPaneL.setEditable(false);
				panelBanks.add(textPaneL, gbcL);
				
				
				JTextPane textPaneR = new JTextPane();
				GridBagConstraints gbcR = new GridBagConstraints(1, gridy, 1, 1, 1, 1, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0);
				textPaneR.setText("\n\n");
				textPaneR.setOpaque(false);
				textPaneR.setEditable(false);
				panelBanks.add(textPaneR, gbcR);
				gridy++;
			}
		}
	}
}