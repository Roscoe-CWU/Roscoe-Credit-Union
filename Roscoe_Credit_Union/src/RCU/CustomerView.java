package RCU;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.*;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.text.NumberFormat;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

public class CustomerView {

	public JFrame frame;
	private JPanel panel;
	private JLabel lblRCU;
	private JButton btnLogOut;
	private JScrollPane scrollPane;
	private JLabel lblUser;
	private JLabel lblLoggedInAs;
	private GridBagLayout gbl_panel = new GridBagLayout();
	

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView window = new CustomerView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 */
	
	
	
	/**
	 * Create the application.
	 */
	public CustomerView(CustomerAccount account) {
		initialize(account);
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		ArrayList<BankAccount> bankAccounts = account.getBankAccounts();
		
		int gridy = 0;
		for (BankAccount bank : bankAccounts) {
			JTextPane textPaneL = new JTextPane();
			GridBagConstraints gbcL = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0);
			textPaneL.setText(bank.getAccountName() + "\nBalance:" + "\n");
			SimpleAttributeSet sasBold = new SimpleAttributeSet();
			StyleConstants.setBold(sasBold, true);
			StyleConstants.setForeground(sasBold, SystemColor.textHighlight);
			textPaneL.getStyledDocument().setCharacterAttributes(0, bank.getAccountName().length(), sasBold, false);
			textPaneL.setEditable(false);
			panel.add(textPaneL, gbcL);
			
			
			
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
			panel.add(textPaneR, gbcR);
			
			gridy++;
		}
		// filler textpanes
		if (bankAccounts.size() < 4) {
			for (int i = 0; i < (4 - bankAccounts.size()); i++) {
				JTextPane textPaneL = new JTextPane();
				GridBagConstraints gbcL = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0);
				textPaneL.setText("\n\n");
				textPaneL.setOpaque(false);
				textPaneL.setEditable(false);
				panel.add(textPaneL, gbcL);
				
				
				JTextPane textPaneR = new JTextPane();
				GridBagConstraints gbcR = new GridBagConstraints(1, gridy, 1, 1, 1, 1, GridBagConstraints.EAST,  GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0);
				textPaneR.setText("\n\n");
				textPaneR.setOpaque(false);
				textPaneR.setEditable(false);
				panel.add(textPaneR, gbcR);
				gridy++;
			}
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(CustomerAccount account) {
		frame = new JFrame("Roscoe Credit Union");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerView.class.getResource("/resources/Logo-50x50.png")));
		frame.setBounds(100, 100, 808, 525);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblRCU = new JLabel("Roscoe Credit Union");
		lblRCU.setForeground(new Color(0, 0, 128));
		lblRCU.setFont(new Font("Tahoma", Font.BOLD, 64));
		lblRCU.setIcon(new ImageIcon(CustomerView.class.getResource("/resources/Logo-100x100.png")));
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(new Color(0, 0, 255));
		
		scrollPane = new JScrollPane();
		
		lblLoggedInAs = new JLabel("Logged in as:");
		
		lblUser = new JLabel(account.getFirstName() + " " + account.getLastName());
		lblUser.setForeground(SystemColor.textHighlight);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRCU, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
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
					.addGap(18)
					.addComponent(lblRCU)
					.addGap(77)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
