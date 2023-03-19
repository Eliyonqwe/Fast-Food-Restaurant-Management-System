import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import Classes.Customer;


public class CreateAccountPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtFirstName;
	private JTextField txtPassword;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountPage frame = new CreateAccountPage();
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
	public CreateAccountPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("< Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CustomersPage cp = new CustomersPage();
				cp.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBack.setBackground(new Color(51, 51, 51));
		btnBack.setBounds(0, 58, 89, 39);
		contentPane.add(btnBack);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setForeground(new Color(255, 204, 51));
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCreateAccount.setBounds(292, 93, 125, 35);
		contentPane.add(lblCreateAccount);
		
		JPanel panelRegistration = new JPanel();
		panelRegistration.setLayout(null);
		panelRegistration.setBounds(249, 149, 208, 143);
		contentPane.add(panelRegistration);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLastName.setBounds(20, 40, 60, 16);
		panelRegistration.add(lblLastName);
		
		JLabel lblSalary = new JLabel("Email");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSalary.setBounds(20, 100, 49, 16);
		panelRegistration.add(lblSalary);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(80, 40, 97, 16);
		panelRegistration.add(txtLastName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(80, 100, 97, 16);
		panelRegistration.add(txtEmail);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFirstName.setBounds(20, 20, 60, 16);
		panelRegistration.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(80, 20, 97, 16);
		panelRegistration.add(txtFirstName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(20, 80, 60, 16);
		panelRegistration.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(20, 60, 60, 16);
		panelRegistration.add(lblUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(80, 80, 97, 16);
		panelRegistration.add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(80, 60, 97, 16);
		panelRegistration.add(txtUsername);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( txtFirstName.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter First name!");
				else if ( txtLastName.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Last name!");
				else if ( txtUsername.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Username!");
				else if ( txtPassword.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Password!");
				else if ( txtEmail.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Email!");
				else {
					
					Customer customer = new Customer();
					boolean valid = customer.addCustomer(txtFirstName.getText(), txtLastName.getText(), txtUsername.getText(), txtPassword.getText(), txtEmail.getText());
					
					if (valid) {
						JOptionPane.showMessageDialog(null, "Added successfully!");
						setVisible(false);
						CustomersPage cp = new CustomersPage();
						cp.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Adding Failed!");
				}
			}
		});
		btnCreateAccount.setBackground(Color.LIGHT_GRAY);
		btnCreateAccount.setBounds(292, 326, 125, 23);
		contentPane.add(btnCreateAccount);
		
		JPanel LogoPanel = new JPanel();
		LogoPanel.setLayout(null);
		LogoPanel.setBackground(new Color(255, 204, 51));
		LogoPanel.setBounds(0, 0, 706, 58);
		contentPane.add(LogoPanel);
		
		JLabel lblLogo = new JLabel("Fast Food Management System");
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(190, 0, 323, 58);
		LogoPanel.add(lblLogo);
	}
}
