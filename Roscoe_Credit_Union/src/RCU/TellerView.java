package RCU;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

public class TellerView {

	public JFrame frmTellerView;
	private JTextField textField;
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
	private static final ImageIcon logo50 = new ImageIcon(CustomerView.class.getResource("/resources/Logo-50x50.png"));
	private static final ImageIcon logo100 = new ImageIcon(CustomerView.class.getResource("/resources/Logo-100x100.png"));




	/**
	 * Create the application.
	 */
	
	
	public TellerView(CreditUnionDatabaseConnector connector) {
		initialize(connector);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(CreditUnionDatabaseConnector connector) {
		setFrame(new JFrame("Account Selector"));
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getFrame().getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		
		JButton btnNewButton_1 = new JButton("<html>Add/Update/Remove<br/>Customer Accounts</html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TellerUpdateAccountView tellerUpdateView = new TellerUpdateAccountView(connector);
							tellerUpdateView.frame.setVisible(true);
							// Close CustomerView
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 52, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -42, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -220, SpringLayout.EAST, panel);
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Make Deposit");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 6, SpringLayout.EAST, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.SOUTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, -52, SpringLayout.EAST, panel);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String transactionSSN = textField.getText();
				Account mainaccount = connector.getAccountBySSN(transactionSSN);
				if (mainaccount != null) {
					
					CustomerAccount account = new CustomerAccount(mainaccount.getUsername(), mainaccount.getPassword(), mainaccount.getSSN(), mainaccount.getFirstName(), mainaccount.getMiddleName(), mainaccount.getLastName(), mainaccount.getStreetAddress(), mainaccount.getCity(), mainaccount.getState(), mainaccount.getZip(), mainaccount.getAccountID());
					ArrayList<BankAccount> bankAccounts = (ArrayList<BankAccount>) connector.getBankAccounts(account, account.getAccountID());
					System.out.println();
					for (BankAccount bank : bankAccounts) {
						account.addBankAccount(bank);
						System.out.println(bank);
					}
					
					
					
					Object[] bankAccounts1 = account.getBankAccounts().toArray();
				
					JComboBox<Object> firstList = new JComboBox<Object>(bankAccounts1);
					JTextField amountTxt = new JTextField(10);
					
					GridBagLayout gbl = new GridBagLayout();
					gbl.columnWidths = new int[]{0, 0, 0};
					gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
					gbl.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
					gbl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
					JPanel panel = new JPanel();
					panel.setLayout(gbl);
				
				
				
				
				
					GridBagConstraints gbcFirstLbl = new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
					GridBagConstraints gbcFirstList = new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 5), 0, 0);
					panel.add(new JLabel("Select the account to deposit to: "), gbcFirstLbl);
					panel.add(firstList, gbcFirstList);
				
				
					GridBagConstraints gbcAmountLbl = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
					GridBagConstraints gbcAmountTxt = new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
					panel.add(new JLabel("Enter the amount to deposit: $"), gbcAmountLbl);
					panel.add(amountTxt, gbcAmountTxt);
				
				
					int result = JOptionPane.showConfirmDialog(null, panel, "Make a Deposit", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE, logo100);
				
					if (result == JOptionPane.OK_OPTION) {
						double amount = 0;
						try {
							amount = Double.parseDouble(amountTxt.getText());
						} catch (NumberFormatException ex) {
						
						}
						BankAccount firstAccount = account.getBankAccounts().get(firstList.getSelectedIndex());
						int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to deposit " + formatter.format(amount) + " to " + firstAccount + "?",
								"Confirm Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logo50);
						if (confirm == JOptionPane.YES_OPTION) {
							firstAccount.deposit(amount);
						
							connector.updateBankAccountBalance(account.getAccountID(), firstAccount.getAccountName(), firstAccount.getBalance());
							//connector.updateBankAccountBalance(account.getAccountID(), secondAccount.getAccountName(), secondAccount.getBalance());
						}
					}
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Teller View");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 72, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 38, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 73, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 154, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -17, SpringLayout.NORTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -250, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Transaction SSN");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, textField);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Make Withdrawal");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 54, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnNewButton_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_2);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String transactionSSN = textField.getText();
				Account mainaccount = connector.getAccountBySSN(transactionSSN);
				if (mainaccount != null) {
					
					CustomerAccount account = new CustomerAccount(mainaccount.getUsername(), mainaccount.getPassword(), mainaccount.getSSN(), mainaccount.getFirstName(), mainaccount.getMiddleName(), mainaccount.getLastName(), mainaccount.getStreetAddress(), mainaccount.getCity(), mainaccount.getState(), mainaccount.getZip(), mainaccount.getAccountID());
					ArrayList<BankAccount> bankAccounts = (ArrayList<BankAccount>) connector.getBankAccounts(account, account.getAccountID());
					System.out.println();
					for (BankAccount bank : bankAccounts) {
						account.addBankAccount(bank);
						System.out.println(bank);
					}
					
					
					
					Object[] bankAccounts1 = account.getBankAccounts().toArray();
				
					JComboBox<Object> firstList = new JComboBox<Object>(bankAccounts1);
					JTextField amountTxt = new JTextField(10);
					
					GridBagLayout gbl = new GridBagLayout();
					gbl.columnWidths = new int[]{0, 0, 0};
					gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
					gbl.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
					gbl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
					JPanel panel = new JPanel();
					panel.setLayout(gbl);
				
				
				
				
				
					GridBagConstraints gbcFirstLbl = new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
					GridBagConstraints gbcFirstList = new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 5), 0, 0);
					panel.add(new JLabel("Select the account to withdraw from: "), gbcFirstLbl);
					panel.add(firstList, gbcFirstList);
				
					GridBagConstraints gbcAmountLbl = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
					GridBagConstraints gbcAmountTxt = new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0);
					panel.add(new JLabel("Enter the amount to withdraw: $"), gbcAmountLbl);
					panel.add(amountTxt, gbcAmountTxt);
				
				
					int result = JOptionPane.showConfirmDialog(null, panel, "Make a Withdrawal", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE, logo100);
				
					if (result == JOptionPane.OK_OPTION) {
						double amount = 0;
						try {
							amount = Double.parseDouble(amountTxt.getText());
						} catch (NumberFormatException ex) {
						
						}
						BankAccount firstAccount = account.getBankAccounts().get(firstList.getSelectedIndex());
					
						if (firstAccount.getBalance() >= amount) {
							int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to withdraw " + formatter.format(amount) + " from " + firstAccount + "?",
									"Confirm Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logo50);
							if (confirm == JOptionPane.YES_OPTION) {
								firstAccount.withdraw(amount);
							
								connector.updateBankAccountBalance(account.getAccountID(), firstAccount.getAccountName(), firstAccount.getBalance());
							}
						} else {
							JOptionPane.showMessageDialog(null, "Not Enough Funds");
						}
					}
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTellerView.setVisible(false);
				frmTellerView.dispose();
				// Show the singleton instance of LogInWindow
		        LogInWindow loginWindow = LogInWindow.getInstance(connector);
		        loginWindow.getFrame().setVisible(true);
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_3, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_3, -34, SpringLayout.EAST, panel);
		panel.add(btnNewButton_3);
	}

	/**
	 * getter for frame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frmTellerView;
	}

	/**
	 * setter for frame
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frmTellerView = frame;
		frmTellerView.setTitle("Teller View");
	}
}
