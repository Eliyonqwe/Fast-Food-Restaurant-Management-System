import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import Classes.Admin;

public class AdminLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdminUsername;
	private JPasswordField txtAdminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginPage frame = new AdminLoginPage();
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
	public AdminLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LogoPanel = new JPanel();										//Panel for the logo
		LogoPanel.setLayout(null);
		LogoPanel.setBackground(new Color(255, 204, 51));
		LogoPanel.setBounds(0, 0, 706, 58);
		contentPane.add(LogoPanel);
		
		JLabel lblLogo = new JLabel("Fast Food Management System");				//Label for "Fast Food Management System"
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(190, 0, 323, 58);
		LogoPanel.add(lblLogo);
		
		JLabel lblAdminTitle = new JLabel("Admin Login Page");					//Label for "Admin Login Page"
		lblAdminTitle.setForeground(Color.WHITE);
		lblAdminTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminTitle.setBounds(278, 147, 129, 20);
		contentPane.add(lblAdminTitle);
		
		JLabel lblAdminUsername = new JLabel("Username");						//Label for "Username"
		lblAdminUsername.setForeground(Color.WHITE);
		lblAdminUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdminUsername.setBounds(229, 217, 69, 17);
		contentPane.add(lblAdminUsername);
		
		JLabel lblAdminPassword = new JLabel("Password");						//Label for "Password"
		lblAdminPassword.setForeground(Color.WHITE);
		lblAdminPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdminPassword.setBounds(229, 245, 69, 17);
		contentPane.add(lblAdminPassword);
		
		txtAdminUsername = new JTextField();									//Text field for admins username
		txtAdminUsername.setColumns(10);
		txtAdminUsername.setBackground(Color.LIGHT_GRAY);
		txtAdminUsername.setBounds(308, 216, 152, 20);
		contentPane.add(txtAdminUsername);
		
		txtAdminPassword = new JPasswordField();								//Text field for admins password
		txtAdminPassword.setBackground(Color.LIGHT_GRAY);
		txtAdminPassword.setBounds(308, 244, 152, 20);
		contentPane.add(txtAdminPassword);
		
		JButton btnSignIn = new JButton("Sign-In");								//Button that says "Sign-in"
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtAdminUsername.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please enter your Username!");
				else if (txtAdminPassword.getText().isBlank())
					JOptionPane.showMessageDialog(null, "Please enter your Password!");
				else {
					
					Admin admin = new Admin();
					boolean valid = admin.verifyUser( txtAdminUsername.getText(), txtAdminPassword.getText());
					
					if (valid) {
						JOptionPane.showMessageDialog(null, "Sign-In successful");
						setVisible(false);
						AdminMainPage ap = new AdminMainPage();
						ap.setVisible(true);

						ResultSet rs = admin.getAdminId(txtAdminUsername.getText());		//Returns the id of logged in admin
						try {
							MainClass.loggedInAdmin = rs.getString("adminId");				//Stores the id in the "LoggedInAdmin" variable
						}
						catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Something went wrong while getting adminId!\n" + e1);
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid username or password!");
				}
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignIn.setBackground(Color.LIGHT_GRAY);
		btnSignIn.setBounds(296, 295, 89, 30);
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
