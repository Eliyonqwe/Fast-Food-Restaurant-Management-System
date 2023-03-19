import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import Classes.Waiter;


public class WaiterProfilePage extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtGender;
	private JTextField txtAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaiterProfilePage frame = new WaiterProfilePage();
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
	public WaiterProfilePage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSidelbar = new JPanel();
		panelSidelbar.setLayout(null);
		panelSidelbar.setBackground(new Color(255, 204, 51));
		panelSidelbar.setBounds(0, 0, 184, 418);
		contentPane.add(panelSidelbar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(90, 0, 94, 32);
		panelSidelbar.add(panel_1);
		
		JLabel lblProfile_1 = new JLabel("Profile");
		lblProfile_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile_1.setForeground(Color.WHITE);
		lblProfile_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProfile_1.setBackground(new Color(51, 51, 51));
		lblProfile_1.setBounds(0, 0, 94, 32);
		panel_1.add(lblProfile_1);
		
		JButton btnProfile = new JButton("Home");						//Button that says "Home"
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WaiterMainPage wmp = new WaiterMainPage();
				wmp.setVisible(true);
			}
		});
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProfile.setBackground(Color.GRAY);
		btnProfile.setBounds(0, 0, 94, 32);
		panelSidelbar.add(btnProfile);
		
		JButton btnOrders_1 = new JButton("Orders");						//Button that says "Orders"
		btnOrders_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WaiterOrderPage wp = new WaiterOrderPage();
				wp.setVisible(true);
			}
		});
		btnOrders_1.setForeground(Color.WHITE);
		btnOrders_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOrders_1.setBackground(new Color(255, 204, 51));
		btnOrders_1.setBounds(0, 186, 184, 52);
		panelSidelbar.add(btnOrders_1);
		
		JButton btnLogOut_1 = new JButton("Log Out");						//Button that says "Log Out"
		btnLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to log-out?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if ( response == JOptionPane.YES_OPTION) {
					setVisible(false);
					WaiterLoginPage wl = new WaiterLoginPage();
					wl.setVisible(true);
				}
			}
		});
		btnLogOut_1.setForeground(Color.WHITE);
		btnLogOut_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogOut_1.setBackground(new Color(255, 204, 51));
		btnLogOut_1.setBounds(0, 235, 184, 52);
		panelSidelbar.add(btnLogOut_1);
		
		JLabel lblLogo = new JLabel("Fast Food Management System");
		lblLogo.setForeground(new Color(255, 204, 51));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(289, 0, 417, 58);
		contentPane.add(lblLogo);
		
		JLabel lblProfilePage = new JLabel("Profile Page");
		lblProfilePage.setForeground(new Color(255, 204, 51));
		lblProfilePage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProfilePage.setBounds(395, 50, 125, 35);
		contentPane.add(lblProfilePage);
		
		JLabel lblForm = new JLabel("Form");
		lblForm.setForeground(Color.WHITE);
		lblForm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblForm.setBounds(305, 102, 74, 21);
		contentPane.add(lblForm);
		
		JPanel panelRegistration = new JPanel();
		panelRegistration.setLayout(null);
		panelRegistration.setBounds(305, 122, 283, 156);
		contentPane.add(panelRegistration);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFirstName.setBounds(50, 20, 60, 16);
		panelRegistration.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLastName.setBounds(50, 40, 60, 16);
		panelRegistration.add(lblLastName);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(50, 60, 60, 16);
		panelRegistration.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(50, 80, 60, 16);
		panelRegistration.add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGender.setBounds(50, 100, 49, 16);
		panelRegistration.add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAge.setBounds(50, 120, 49, 16);
		panelRegistration.add(lblAge);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(130, 20, 110, 16);
		panelRegistration.add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(130, 40, 110, 16);
		panelRegistration.add(txtLastName);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(130, 60, 110, 16);
		panelRegistration.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(130, 80, 110, 16);
		panelRegistration.add(txtPassword);

		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(130, 100, 110, 16);
		panelRegistration.add(txtGender);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(130, 120, 110, 16);
		panelRegistration.add(txtAge);
		
		Waiter waiter = new Waiter();
		ResultSet result = waiter.searchWaiter(MainClass.loggedInWaiter);
		getValue(result);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( txtFirstName.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter First name!");
				else if ( txtLastName.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Last name!");
				else if ( txtUsername.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Username!");
				else if ( txtPassword.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Password!");
				else if ( txtGender.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Gender!");
				else if ( txtAge.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Age!");
				else {
					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to update your information?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if ( response == JOptionPane.YES_OPTION) {
						boolean valid = waiter.updateWaiter(txtFirstName.getText(), txtLastName.getText(), txtUsername.getText(), txtPassword.getText(), txtGender.getText(), Integer.parseInt(txtAge.getText()), MainClass.loggedInWaiter);
						if ( valid ) 
							JOptionPane.showMessageDialog(null, "Update Successful!");
						else
							JOptionPane.showMessageDialog(null, "Update Failed!");
					}
				}
				
			}
		});
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setBounds(401, 303, 86, 23);
		contentPane.add(btnUpdate);
	}
	
	private void getValue( ResultSet result ) {
		try {
			txtFirstName.setText(result.getString("firstName"));
			txtLastName.setText(result.getString("lastName"));
			txtUsername.setText(result.getString("username"));
			txtPassword.setText(result.getString("password"));
			txtGender.setText(result.getString("gender"));
			txtAge.setText(result.getString("age"));
		} 
		catch (Exception e1) {
			JOptionPane.showInternalMessageDialog(null, "Something went worng" + e1);
		}
	}

}
