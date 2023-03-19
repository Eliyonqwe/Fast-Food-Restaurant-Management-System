import java.sql.*;
import java.text.DecimalFormat;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import Classes.Waiter;


public class EmployeePage extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmpId;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtGender;
	private JTextField txtAge;
	private JTextField txtSalary;
	private JTextField txtExperiance;
	private JTable tblEmployeeList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePage frame = new EmployeePage();
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
	public EmployeePage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSidebar = new JPanel();									//Panel for the side bar
		panelSidebar.setLayout(null);
		panelSidebar.setBackground(new Color(255, 204, 51));
		panelSidebar.setBounds(0, 0, 184, 418);
		contentPane.add(panelSidebar);
		

		JLabel lblLogo = new JLabel("Fast Food Management System");			//Label for "Fast Food Management System"
		lblLogo.setForeground(new Color(255, 204, 51));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(289, 0, 417, 58);
		contentPane.add(lblLogo);
		
		JLabel lblEmployeePage = new JLabel("Employee Page");				//Label for "Employee Page"
		lblEmployeePage.setForeground(new Color(255, 204, 51));
		lblEmployeePage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmployeePage.setBounds(385, 50, 125, 35);
		contentPane.add(lblEmployeePage);
		

		JPanel panel = new JPanel();										//Panel for storing the label that says "Employee"
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 110, 184, 52);
		panelSidebar.add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployee = new JLabel("Employee");						//Label for "Employee"
		lblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployee.setForeground(Color.WHITE);
		lblEmployee.setBounds(65, 0, 119, 52);
		panel.add(lblEmployee);
		
		JButton btnHome = new JButton("Home");								//Button that says "Home"
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminMainPage amp = new AdminMainPage();
				amp.setVisible(true);
			}
		});
		btnHome.setBounds(0, 0, 92, 32);
		panelSidebar.add(btnHome);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHome.setBackground(Color.GRAY);
		
		JButton btnProfile = new JButton("Profile");						//Button that says "Profile"
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminProfilePage app = new AdminProfilePage();
				app.setVisible(true);
			}
		});
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setBackground(Color.GRAY);
		btnProfile.setBounds(90, 0, 94, 32);
		panelSidebar.add(btnProfile);
		
		
		JButton btnMenu = new JButton("Menu");								//Button that says "Menu"
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
		btnMenu.setBounds(0, 160, 184, 52);
		panelSidebar.add(btnMenu);
		
		JButton btnInventory = new JButton("Inventory");					//Button that says "Inventory"
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
		btnInventory.setBounds(0, 210, 184, 52);
		panelSidebar.add(btnInventory);
		
		JButton btnOrders = new JButton("Orders");							//Button that says "Orders"
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
		btnOrders.setBounds(0, 260, 184, 52);
		panelSidebar.add(btnOrders);
		
		JButton btnLogOut = new JButton("Log Out");							//Button that says "Log Out"
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
		btnLogOut.setBounds(0, 310, 184, 52);
		panelSidebar.add(btnLogOut);
		
		JLabel lblRegistration = new JLabel("Registration");				//Label for "Registration"
		lblRegistration.setForeground(Color.WHITE);
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistration.setBounds(194, 85, 74, 21);
		contentPane.add(lblRegistration);
		
		JPanel panelRegistration = new JPanel();							//Panel for registration
		panelRegistration.setLayout(null);
		panelRegistration.setBounds(193, 102, 176, 172);
		contentPane.add(panelRegistration);

		JLabel lblFirstName = new JLabel("First Name");						//Label for "First Name"
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFirstName.setBounds(10, 10, 60, 16);
		panelRegistration.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");						//Label for "Last Name"
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLastName.setBounds(10, 30, 60, 16);
		panelRegistration.add(lblLastName);

		JLabel lblUsername = new JLabel("Username");						//Label for "Username"
		lblUsername.setBounds(10, 50, 60, 16);
		panelRegistration.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblPassword = new JLabel("Password");						//Label for "Password"
		lblPassword.setBounds(10, 70, 60, 16);
		panelRegistration.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblGender = new JLabel("Gender");							//Label for "Gender"
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGender.setBounds(10, 90, 49, 16);
		panelRegistration.add(lblGender);
		
		JLabel lblAge = new JLabel("Age");									//Label for "Age"
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAge.setBounds(10, 110, 49, 16);
		panelRegistration.add(lblAge);
		
		JLabel lblSalary = new JLabel("Salary");							//Label for "Salary"
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSalary.setBounds(10, 130, 49, 16);
		panelRegistration.add(lblSalary);
		
		JLabel lblExperiance = new JLabel("Experience");					//Label for "Experience"
		lblExperiance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExperiance.setBounds(10, 150, 60, 16);
		panelRegistration.add(lblExperiance);

		txtFirstName = new JTextField();									//Text field for First name
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(70, 10, 96, 16);
		panelRegistration.add(txtFirstName);
		
		txtLastName = new JTextField();										//Text field for last name
		txtLastName.setColumns(10);
		txtLastName.setBounds(69, 30, 97, 16);
		panelRegistration.add(txtLastName);

		txtUsername = new JTextField();										//Text field for Username
		txtUsername.setColumns(10);
		txtUsername.setBounds(69, 50, 97, 16);
		panelRegistration.add(txtUsername);

		txtPassword = new JTextField();										//Text field for Password
		txtPassword.setColumns(10);
		txtPassword.setBounds(69, 70, 97, 16);
		panelRegistration.add(txtPassword);

		txtGender = new JTextField();										//Text field for Gender
		txtGender.setColumns(10);
		txtGender.setBounds(69, 90, 97, 16);
		panelRegistration.add(txtGender);

		txtAge = new JTextField();											//Text field for Age
		txtAge.setColumns(10);
		txtAge.setBounds(69, 110, 97, 16);
		panelRegistration.add(txtAge);
		
		txtSalary = new JTextField();										//Text field for Salary
		txtSalary.setColumns(10);
		txtSalary.setBounds(69, 130, 97, 16);
		panelRegistration.add(txtSalary);

		txtExperiance = new JTextField();									//Text field for Experience
		txtExperiance.setColumns(10);
		txtExperiance.setBounds(69, 150, 97, 16);
		panelRegistration.add(txtExperiance);
		
		JLabel lblEmployeeList = new JLabel("Employee Table");				//Label for "Employee Table"
		lblEmployeeList.setForeground(Color.WHITE);
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmployeeList.setBounds(386, 85, 124, 21);
		contentPane.add(lblEmployeeList);
		
		JButton btnAdd = new JButton("Add");								//Button that says "Add"
		btnAdd.addActionListener(new ActionListener() {
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
				else if ( txtSalary.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Salary!");
				else if ( txtExperiance.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter years of experiance!");
				else {
					Waiter waiter = new Waiter();
					boolean valid = waiter.addWaiter(txtFirstName.getText(), txtLastName.getText(), txtUsername.getText(), txtPassword.getText(), txtGender.getText(), Integer.parseInt(txtAge.getText()), Double.parseDouble(txtSalary.getText()), Integer.parseInt(txtExperiance.getText()));
					if (valid) {
						JOptionPane.showMessageDialog(null, "Added successfully!");
						waiter.listWaiter(tblEmployeeList);
					}
					else
						JOptionPane.showMessageDialog(null, "Adding Failed!");
				}
			}
		});
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setBounds(206, 285, 72, 23);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");							//Button that says "Clear"
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFirstName.setText("");
				txtLastName.setText("");
				txtUsername.setText("");
				txtPassword.setText("");
				txtGender.setText("");
				txtAge.setText("");
				txtSalary.setText("");
				txtExperiance.setText("");
				txtEmpId.setText("");
			}
		});
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(282, 285, 72, 23);
		contentPane.add(btnClear);
		
		JButton btnSearch = new JButton("Search");							//Button that says "Search"
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( txtEmpId.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter Id!");
				else {
					Waiter waiter = new Waiter();
					ResultSet result = waiter.searchWaiter(txtEmpId.getText());
					
					if ( result != null )
						getValue(result);
					else
						JOptionPane.showMessageDialog(null, "No result found!");
				}
			}
		});
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setBounds(227, 384, 110, 23);
		contentPane.add(btnSearch);
		
		JButton btnLoad = new JButton("Load");								//Button that says "Load"
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiter waiter = new Waiter();
				waiter.listWaiter(tblEmployeeList);
			}
		});
		btnLoad.setBackground(Color.LIGHT_GRAY);
		btnLoad.setBounds(389, 384, 86, 23);
		contentPane.add(btnLoad);
		
		JButton btnUpdate = new JButton("Update");							//Button that says "Update"
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( txtEmpId.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter Id!");
				else if ( txtFirstName.getText().isEmpty() )
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
				else if ( txtSalary.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Salary!");
				else if ( txtExperiance.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter years of experiance!");
				else {
					
					Waiter waiter = new Waiter();
					boolean valid = waiter.updateWaiter(txtFirstName.getText(), txtLastName.getText(), txtUsername.getText(), txtPassword.getText(), txtGender.getText(), Integer.parseInt(txtAge.getText()), Double.parseDouble(txtSalary.getText()), Integer.parseInt(txtExperiance.getText()), txtEmpId.getText());
					
					if ( valid ) {
						JOptionPane.showMessageDialog(null, "Update Successful!");
						waiter.listWaiter(tblEmployeeList);
					}
					else
						JOptionPane.showMessageDialog(null, "Update Failed!");
				}
			}
		});
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setBounds(489, 384, 86, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");							//Button that says "Delete"
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( txtEmpId.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter Id!");
				else {
					Waiter waiter = new Waiter();
					waiter.deleteWaiter(txtEmpId.getText());
					waiter.listWaiter(tblEmployeeList);
				}
			}
		});
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setBounds(585, 384, 86, 23);
		contentPane.add(btnDelete);

		JLabel lblSearch = new JLabel("Search");							//Label that says "Search"
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearch.setBounds(194, 319, 74, 21);
		contentPane.add(lblSearch);
		
		JPanel panelSearch = new JPanel();									//Panel for search
		panelSearch.setLayout(null);
		panelSearch.setBounds(194, 336, 176, 37);
		contentPane.add(panelSearch);
		
		JLabel lblEmpId = new JLabel("Emp Id");								//Label that says "EmpId"
		lblEmpId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmpId.setBounds(10, 11, 49, 16);
		panelSearch.add(lblEmpId);
		
		txtEmpId = new JTextField();										//Text field for EmpId
		txtEmpId.setColumns(10);
		txtEmpId.setBounds(63, 11, 103, 16);
		panelSearch.add(txtEmpId);
		
		JScrollPane scrollPane_1 = new JScrollPane();					
		scrollPane_1.setBounds(380, 102, 317, 271);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblEmployeeList = new JTable();
		tblEmployeeList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(tblEmployeeList);
	}
	
	private void getValue( ResultSet result ) {								//Sets the text fields with the searched waiters info
		
		try {
			
			DecimalFormat df = new DecimalFormat("0.00");
			
			txtFirstName.setText(result.getString("firstName"));
			txtLastName.setText(result.getString("lastName"));
			txtUsername.setText(result.getString("username"));
			txtPassword.setText(result.getString("password"));
			txtGender.setText(result.getString("gender"));
			txtAge.setText(result.getString("age"));
			txtSalary.setText(df.format(result.getDouble("salary")));
			txtExperiance.setText(result.getString("experiance"));
		} 
		catch (SQLException e1) {
			JOptionPane.showInternalMessageDialog(null, "Something went worng" + e1);
		}
	}
}
