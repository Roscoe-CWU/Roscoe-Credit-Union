package RCU;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class LogInWindow {

	private static LogInWindow instance;
	private JFrame frame;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditUnionDatabaseConnector connector = new CreditUnionDatabaseConnector();
					LogInWindow window = new LogInWindow(connector);
					instance = window;
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInWindow(CreditUnionDatabaseConnector connector) {
		initialize(connector);
	}
	
	public static LogInWindow getInstance(CreditUnionDatabaseConnector connector) {
        if (instance == null) {
            instance = new LogInWindow(connector);
        }
        return instance;
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(CreditUnionDatabaseConnector connector) {
		// Main frame
		frame = new JFrame("Roscoe Credit Union");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LogInWindow.class.getResource("/resources/Logo-50x50.png")));
		frame.setBounds(100, 100, 491, 467);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelUsername = new JPanel();
		JPanel panelPassword = new JPanel();
		
		// Password text field
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(0, 0, 128));
		panelPassword.add(lblPassword);
		textFieldPassword = new JPasswordField();
		textFieldPassword.setColumns(20);
		panelPassword.add(textFieldPassword);
		
		// Log in title
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setForeground(SystemColor.textHighlight);
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		// Log in button
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = textFieldUsername.getText();
				String password = String.valueOf(textFieldPassword.getPassword());
				
				Account account = connector.getAccountByUsernameAndPassword(username, password);
				
				if (account != null) {
		            // Hide the login window
		            frame.setVisible(false);

		            // Open the Account Selection View
		            EventQueue.invokeLater(new Runnable() {
		                public void run() {
		                    try {
		                        AccountSelectionView accountSelectionView = new AccountSelectionView(connector, account);
		                        accountSelectionView.getFrame().setVisible(true);
		                    } catch (Exception ex) {
		                        ex.printStackTrace();
		                    }
		                }
		            });
		        } else {
		            // Handle failed login
		            JOptionPane.showMessageDialog(frame, "Invalid username or password.");
		        }
				
			}
		});
		btnLogIn.setForeground(new Color(0, 0, 128));
		
		// Logo
		JLabel lblNewLabel = new JLabel();
		ImageIcon icon = new ImageIcon(LogInWindow.class.getResource("/resources/Logo-500x500.png"));
		lblNewLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPassword, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelUsername, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
					.addGap(54))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(392, Short.MAX_VALUE)
					.addComponent(btnLogIn)
					.addGap(29))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addComponent(lblLogIn)
					.addGap(179))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(148, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(136))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLogIn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelUsername, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelPassword, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogIn)
					.addGap(31))
		);
		
		// Username text field
		JLabel lblUsername = new JLabel(" Username:");
		lblUsername.setForeground(new Color(0, 0, 128));
		panelUsername.add(lblUsername);
		textFieldUsername = new JTextField();
		panelUsername.add(textFieldUsername);
		textFieldUsername.setColumns(20);
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
	 * setter for the frame
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
