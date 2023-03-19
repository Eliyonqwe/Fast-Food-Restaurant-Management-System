import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import Classes.Waiter;

public class WaiterLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtWaiterUsername;
	private JPasswordField txtWaiterPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaiterLoginPage frame = new WaiterLoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WaiterLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LogoPanel = new JPanel();									//Panel for the logo
		LogoPanel.setLayout(null);
		LogoPanel.setBackground(new Color(255, 204, 51));
		LogoPanel.setBounds(0, 0, 706, 58);
		contentPane.add(LogoPanel);
		
		JLabel lblLogo = new JLabel("Fast Food Management System");			//Label for "Fast Food Management System
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(190, 0, 323, 58);
		LogoPanel.add(lblLogo);
		
		JLabel lblWaiterTitle = new JLabel("Waiter Login Page");			//Label for "Waiter Login Page"
		lblWaiterTitle.setForeground(Color.WHITE);
		lblWaiterTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWaiterTitle.setBounds(273, 147, 129, 20);
		contentPane.add(lblWaiterTitle);
		
		JLabel lblWaiterUsername = new JLabel("Username");					//Label for "Username"
		lblWaiterUsername.setForeground(Color.WHITE);
		lblWaiterUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWaiterUsername.setBounds(224, 217, 69, 17);
		contentPane.add(lblWaiterUsername);
		
		JLabel lblWaiterPassword = new JLabel("Password");					//Label for "Password"
		lblWaiterPassword.setForeground(Color.WHITE);
		lblWaiterPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWaiterPassword.setBounds(224, 245, 69, 17);
		contentPane.add(lblWaiterPassword);
		
		txtWaiterUsername = new JTextField();								//Text field for waiters username
		txtWaiterUsername.setColumns(10);
		txtWaiterUsername.setBackground(Color.LIGHT_GRAY);
		txtWaiterUsername.setBounds(303, 216, 152, 20);
		contentPane.add(txtWaiterUsername);
		
		txtWaiterPassword = new JPasswordField();							//Text field for waiters password
		txtWaiterPassword.setBackground(Color.LIGHT_GRAY);
		txtWaiterPassword.setBounds(303, 244, 152, 20);
		contentPane.add(txtWaiterPassword);
		
		JButton btnSignIn = new JButton("Sign-In");							//Button that says "Sign-in"
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtWaiterUsername.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please enter your Username!");
				else if (txtWaiterPassword.getText().isBlank())
					JOptionPane.showMessageDialog(null, "Please enter your Password!");
				else {
					
					Waiter waiter = new Waiter();
					boolean valid = waiter.verifyUser( txtWaiterUsername.getText(), txtWaiterPassword.getText());

					if (valid) {
						JOptionPane.showMessageDialog(null, "Sign-In successful");
						setVisible(false);
						WaiterMainPage wp = new WaiterMainPage();
						wp.setVisible(true);
						
						ResultSet rs = waiter.getWaiterId(txtWaiterUsername.getText());		//Returns the id of logged in waiter
						try {
							MainClass.loggedInWaiter = rs.getString("waiterId");			//Stores the id in the "LoggedInWaiter" variable
						}
						catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Something went wrong \n" + e1);
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid username or password!");
				}
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignIn.setBackground(Color.LIGHT_GRAY);
		btnSignIn.setBounds(291, 295, 89, 30);
		contentPane.add(btnSignIn);
		
		JButton btnBack = new JButton("< Back");								//Button that says "< Back"
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CustomersPage cp = new CustomersPage();
				cp.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(51, 51, 51));
		btnBack.setBounds(0, 58, 89, 39);
		contentPane.add(btnBack);
	}

}
