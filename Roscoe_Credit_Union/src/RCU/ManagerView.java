package RCU;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManagerView {

	public JFrame frmManagerView;


	/**
	 * Create the application.
	 */
	public ManagerView(CreditUnionDatabaseConnector connector) {
		initialize(connector);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(CreditUnionDatabaseConnector connector) {
		frmManagerView = new JFrame();
		frmManagerView.setTitle("Manager View");
		frmManagerView.setBounds(100, 100, 878, 417);
		frmManagerView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmManagerView.getContentPane().add(panel, BorderLayout.CENTER);
		
		// Call the method to get averages
	    Map<String, Double> averages = connector.getAverageAccountBalances();

	    // Update the labels with the fetched averages
	    String savingsAverage = String.format("%.2f", averages.getOrDefault("SAVINGS", 0.0));
	    String checkingAverage = String.format("%.2f", averages.getOrDefault("CHECKING", 0.0));
	    String creditAverage = String.format("%.2f", averages.getOrDefault("CREDIT", 0.0));
		
		JLabel lblNewLabel_2 = new JLabel("Savings Average");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel = new JLabel("Checking Average");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("Credit Average");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_savings = new JLabel(savingsAverage);
		lblNewLabel_savings.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_checking = new JLabel(checkingAverage);
		lblNewLabel_checking.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_credit = new JLabel(creditAverage);
		lblNewLabel_credit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmManagerView.setVisible(false);
				frmManagerView.dispose();
				// Show the singleton instance of LogInWindow
		        LogInWindow loginWindow = LogInWindow.getInstance(connector);
		        loginWindow.getFrame().setVisible(true);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Average Customer Data");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(83)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_savings, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(34)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(lblNewLabel_checking, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(52)
							.addComponent(lblNewLabel_credit, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(133)
					.addComponent(lblNewLabel_3)
					.addContainerGap(640, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(888, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(81))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addGap(78)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_savings)
						.addComponent(lblNewLabel_checking)
						.addComponent(lblNewLabel_credit)))
		);
		panel.setLayout(gl_panel);
	}

}
