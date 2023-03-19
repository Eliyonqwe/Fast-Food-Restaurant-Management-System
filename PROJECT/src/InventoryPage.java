import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import Classes.Ingredient;


public class InventoryPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtItemName;
	private JTextField txtItemId;
	private JTable tblInventory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryPage frame = new InventoryPage();
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
	public InventoryPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSidebar = new JPanel();											//Panel for the side bar
		panelSidebar.setLayout(null);
		panelSidebar.setBackground(new Color(255, 204, 51));
		panelSidebar.setBounds(0, 0, 184, 418);
		contentPane.add(panelSidebar);

		JLabel lblLogo = new JLabel("Fast Food Management System");					//Label for "Fast Food Management System"
		lblLogo.setForeground(new Color(255, 204, 51));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(289, 0, 417, 58);
		contentPane.add(lblLogo);
		
		JLabel lblInventoryPage = new JLabel("Inventory Page");						//Label for "Inventory Page"
		lblInventoryPage.setForeground(new Color(255, 204, 51));
		lblInventoryPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInventoryPage.setBounds(385, 50, 125, 35);
		contentPane.add(lblInventoryPage);

		JPanel panel = new JPanel();												//Panel for storing the label that says "Inventory"
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 210, 184, 52);
		panelSidebar.add(panel);
		
		JLabel lblInventory = new JLabel("Inventory");								//Label for "Inventory"
		lblInventory.setForeground(Color.WHITE);
		lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInventory.setBounds(65, 0, 119, 52);
		panel.add(lblInventory);

		JButton btnHome = new JButton("Home");										//Button that says "Home"
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
		btnHome.setBounds(0, 0, 92, 32);
		panelSidebar.add(btnHome);

		JButton btnProfile = new JButton("Profile");								//Button that says "Profile"
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminProfilePage app = new AdminProfilePage();
				app.setVisible(true);
			}
		});
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProfile.setBackground(Color.GRAY);
		btnProfile.setBounds(90, 0, 94, 32);
		panelSidebar.add(btnProfile);
		
		JButton btnEmployee = new JButton("Employee");								//Button that says "Employee"
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EmployeePage ep = new EmployeePage();
				ep.setVisible(true);
			}
		});
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEmployee.setBackground(new Color(255, 204, 51));
		btnEmployee.setBounds(0, 110, 184, 52);
		panelSidebar.add(btnEmployee);
		
		JButton btnMenu = new JButton("Menu");										//Button that says "Menu"
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

		JButton btnOrders = new JButton("Orders");									//Button that says "Orders"
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
		
		JButton btnLogOut = new JButton("Log Out");									//Button that says "Log Out"
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
		
		JLabel lblRegistration = new JLabel("Registration");						//Label for "Registration"
		lblRegistration.setForeground(Color.WHITE);
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistration.setBounds(194, 85, 74, 21);
		contentPane.add(lblRegistration);
		
		JPanel panelRegistration = new JPanel();									//Panel for registration
		panelRegistration.setLayout(null);
		panelRegistration.setBounds(193, 102, 176, 79);
		contentPane.add(panelRegistration);

		JLabel lblItem = new JLabel("Item ");										//Label for "Item"
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblItem.setBounds(10, 11, 49, 14);
		panelRegistration.add(lblItem);
		
		JLabel lblQuantity = new JLabel("Quantity");								//Label for "Quantity"
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantity.setBounds(10, 32, 49, 14);
		panelRegistration.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");										//Label for "Price"
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrice.setBounds(10, 53, 49, 14);
		panelRegistration.add(lblPrice);

		txtItemName = new JTextField();											//Text field for item name
		txtItemName.setColumns(10);
		txtItemName.setBounds(63, 11, 103, 16);
		panelRegistration.add(txtItemName);
		
		txtQuantity = new JTextField();											//Text field for quantity
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(63, 32, 103, 16);
		panelRegistration.add(txtQuantity);
		
		txtPrice = new JTextField();											//Text field for price
		txtPrice.setColumns(10);
		txtPrice.setBounds(63, 53, 103, 16);
		panelRegistration.add(txtPrice);
		
		JButton btnAdd = new JButton("Add");										//Button that says "Add"
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( txtItemName.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter item name!");
				else if ( txtQuantity.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Quantity!");
				else if ( txtPrice.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Price!");
				else {
					Ingredient ingredient = new Ingredient();
					boolean valid = ingredient.addIngredient( txtItemName.getText(), txtQuantity.getText(), Double.parseDouble(txtPrice.getText()) );
					if (valid) {
						JOptionPane.showMessageDialog(null, "Added successfully!");
						ingredient.listIngredients(tblInventory);
					}
					else
						JOptionPane.showMessageDialog(null, "Adding Failed!");
				}
			}
		});
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setBounds(204, 188, 72, 23);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");									//Button that says "Clear"
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtItemName.setText("");
				txtQuantity.setText("");
				txtPrice.setText("");			
			}
		});
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(282, 188, 72, 23);
		contentPane.add(btnClear);
		
		JLabel lblSearch = new JLabel("Search");									//Label for "Search"
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearch.setBounds(194, 256, 74, 21);
		contentPane.add(lblSearch);
		
		JPanel panelSearch = new JPanel();											//Panel for search
		panelSearch.setLayout(null);
		panelSearch.setBounds(194, 275, 176, 37);
		contentPane.add(panelSearch);
		
		JLabel lblItemId = new JLabel("Item Id");									//Label for "Item Id"
		lblItemId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblItemId.setBounds(10, 11, 49, 14);
		panelSearch.add(lblItemId);
		
		txtItemId = new JTextField();											//Text field for Item Id
		txtItemId.setColumns(10);
		txtItemId.setBounds(63, 11, 103, 16);
		panelSearch.add(txtItemId);
		
		JButton btnSearch = new JButton("Search");									//Button that says "Search"
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( txtItemId.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter Id!");
				else {
					Ingredient ingredient = new Ingredient();
					ResultSet result = ingredient.searchIngredient(txtItemId.getText());
					
					if ( result != null )
						getValue(result);
					else
						JOptionPane.showMessageDialog(null, "No result found!");
				}
			}
		});
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setBounds(229, 323, 110, 23);
		contentPane.add(btnSearch);
		
		JLabel lblInventoryList = new JLabel("Inventory Table");					//Label for "Inventory Table"
		lblInventoryList.setForeground(Color.WHITE);
		lblInventoryList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInventoryList.setBounds(381, 81, 110, 21);
		contentPane.add(lblInventoryList);
		
		JButton btnLoad = new JButton("Load");										//Button that says "Load"
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingredient ingredient = new Ingredient();
				ingredient.listIngredients(tblInventory);
			}
		});
		btnLoad.setBackground(Color.LIGHT_GRAY);
		btnLoad.setBounds(400, 384, 86, 23);
		contentPane.add(btnLoad);
		
		JButton btnUpdate = new JButton("Update");									//Button that says "Update"
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( txtItemId.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter Id!");
				else if ( txtItemName.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Item name!");
				else if ( txtQuantity.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Quantity!");
				else if ( txtPrice.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please enter Price!");
				else {
					Ingredient ingredient = new Ingredient();
					boolean valid = ingredient.updateIngredient(txtItemName.getText(), txtQuantity.getText(), Double.parseDouble(txtPrice.getText()), txtItemId.getText());
					
					if ( valid ) {
						JOptionPane.showMessageDialog(null, "Update Successful!");
						ingredient.listIngredients(tblInventory);  
					}
					else
						JOptionPane.showMessageDialog(null, "Update Failed!");
				}
			}
		});
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setBounds(500, 384, 86, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");									//Button that says "Delete"
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( txtItemId.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter Id!");
				else {
					Ingredient ingredient = new Ingredient();
					ingredient.deleteIngredient(txtItemId.getText());
					ingredient.listIngredients(tblInventory);;
				}

			}
		});
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setBounds(596, 384, 86, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(382, 99, 311, 275);
		contentPane.add(scrollPane);
		
		tblInventory = new JTable();
		scrollPane.setViewportView(tblInventory);
	}
	
	private void getValue( ResultSet result ) {										//Sets the text fields with the searched ingredient info
		try {
			txtItemName.setText(result.getString("itemName"));
			txtQuantity.setText(result.getString("quantity"));
			txtPrice.setText(result.getString("price"));
		} 
		catch (SQLException e1) {
			JOptionPane.showInternalMessageDialog(null, "Something went worng on getValue of InventoryPage! \n" + e1);
		}
	}
}
