import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import Classes.Admin;

public class AdminProfilePage extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminProfilePage frame = new AdminProfilePage();
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
	public AdminProfilePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblForm.setBounds(306, 136, 74, 21);
		contentPane.add(lblForm);
		
		JPanel panelRegistration = new JPanel();
		panelRegistration.setLayout(null);
		panelRegistration.setBounds(306, 156, 283, 108);
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
		
		txtFirstName = new JTextField();
		txtFirstName.setText((String) null);
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(130, 20, 110, 16);
		panelRegistration.add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setText((String) null);
		txtLastName.setColumns(10);
		txtLastName.setBounds(130, 40, 110, 16);
		panelRegistration.add(txtLastName);
		
		txtUsername = new JTextField();
		txtUsername.setText((String) null);
		txtUsername.setColumns(10);
		txtUsername.setBounds(130, 60, 110, 16);
		panelRegistration.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setText((String) null);
		txtPassword.setColumns(10);
		txtPassword.setBounds(130, 80, 110, 16);
		panelRegistration.add(txtPassword);
		
		Admin admin = new Admin();
		ResultSet result = admin.searchAdmin(MainClass.loggedInAdmin);
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
				else {
					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to update your information?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if ( response == JOptionPane.YES_OPTION) {
						boolean valid = admin.updateAdmin(txtFirstName.getText(), txtLastName.getText(), txtUsername.getText(), txtPassword.getText(), MainClass.loggedInAdmin);
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
		
		JPanel panelSidebar = new JPanel();
		panelSidebar.setBackground(new Color(255, 204, 51));
		panelSidebar.setBounds(0, 0, 184, 418);
		contentPane.add(panelSidebar);

		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setBounds(0, 110, 184, 52);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EmployeePage ep = new EmployeePage();
				ep.setVisible(true);
			}
		});
		panelSidebar.setLayout(null);
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEmployee.setBackground(new Color(255, 204, 51));
		panelSidebar.add(btnEmployee);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(0, 160, 184, 52);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuPage mp = new MenuPage();
				mp.setVisible(true);
			}
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMenu.setBackground(new Color(255, 204, 51));
		panelSidebar.add(btnMenu);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBounds(0, 210, 184, 52);
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InventoryPage ip = new InventoryPage();
				ip.setVisible(true);
			}
		});
		btnInventory.setForeground(Color.WHITE);
		btnInventory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInventory.setBackground(new Color(255, 204, 51));
		panelSidebar.add(btnInventory);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.setBounds(0, 260, 184, 52);
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				OrderPage op = new OrderPage();
				op.setVisible(true);
			}
		});
		btnOrders.setForeground(Color.WHITE);
		btnOrders.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOrders.setBackground(new Color(255, 204, 51));
		panelSidebar.add(btnOrders);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(0, 310, 184, 52);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to log-out?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if ( response == JOptionPane.YES_OPTION) {
					setVisible(false);
					AdminLoginPage al = new AdminLoginPage();
					al.setVisible(true);
				}
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogOut.setBackground(new Color(255, 204, 51));
		panelSidebar.add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 0, 92, 32);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminMainPage amp = new AdminMainPage();
				amp.setVisible(true);
			}
		});
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHome.setBackground(Color.GRAY);
		panelSidebar.add(btnHome);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(90, 0, 94, 32);
		panelSidebar.add(panel);
		panel.setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(0, 0, 94, 32);
		panel.add(lblProfile);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProfile.setForeground(new Color(255, 255, 255));
		lblProfile.setBackground(new Color(51, 51, 51));
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
	
	private void getValue( ResultSet result ) {
		try {
			txtFirstName.setText(result.getString("firstName"));
			txtLastName.setText(result.getString("lastName"));
			txtUsername.setText(result.getString("username"));
			txtPassword.setText(result.getString("password"));
		} 
		catch (Exception e1) {
			JOptionPane.showInternalMessageDialog(null, "Something went worng" + e1);
		}
	}
	
}
