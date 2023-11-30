package RCU;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class AccountSelectionView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSelectionView window = new AccountSelectionView(null, null);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	
	/*public AccountSelectionView() {
		initialize();
	}*/
	
	public AccountSelectionView(CreditUnionDatabaseConnector connector, Account account) {
		initialize(connector, account);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(CreditUnionDatabaseConnector connector, Account account) {
		setFrame(new JFrame("Account Selector"));
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getFrame().getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		// Assuming account object has a method to get personAccountID
	    int personAccountID = account.getAccountID();
		
		JButton btnNewButton_1 = new JButton("Teller Account");
		btnNewButton_1.setEnabled(connector.isTeller(personAccountID));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hide the login window
	            frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TellerView tellerView = new TellerView(connector);
							tellerView.frmTellerView.setVisible(true);
							// Close CustomerView
					        frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// Close CustomerView
		        frame.dispose();
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 52, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -42, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -220, SpringLayout.EAST, panel);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Customer Account");
		btnNewButton_2.setEnabled(connector.isCustomer(personAccountID));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerAccount customer = new CustomerAccount(account.getUsername(), account.getPassword(), account.getSSN(), account.getFirstName(), account.getMiddleName(), account.getLastName(), account.getStreetAddress(), account.getCity(), account.getState(), account.getZip(), account.getAccountID());
				// Hide the login window
	            frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CustomerView custView = new CustomerView(connector, customer);
							custView.frame.setVisible(true);
							// Close CustomerView
					        frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		        frame.dispose();
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 54, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, -52, SpringLayout.EAST, panel);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Manager Account");
		btnNewButton.setEnabled(connector.isManager(personAccountID));
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -6, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -116, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -42, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -52, SpringLayout.EAST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManagerView managerView = new ManagerView(connector);
							managerView.frmManagerView.setVisible(true);
							// Close CustomerView
					        frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// Close CustomerView
		        frame.dispose();
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Account Selection");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 72, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 38, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 73, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 154, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
