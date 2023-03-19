import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.EmptyBorder;
import Classes.Ingredient;
import Classes.Food;


public class MenuPage extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtFoodPrice;
	private JTextField txtFoodName;
	private JTextField txtFoodId;
	private JComboBox<String> FoodTypeBox;
	private JScrollPane scrollPane;
	private Ingredient ing[];
	private JTextField jt[]; 
	private JTable foodTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPage frame = new MenuPage();
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
	public MenuPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelAdminToolbar = new JPanel();
		panelAdminToolbar.setLayout(null);
		panelAdminToolbar.setBackground(new Color(255, 204, 51));
		panelAdminToolbar.setBounds(0, 0, 184, 418);
		contentPane.add(panelAdminToolbar);
		
		JButton btnInventory = new JButton("Inventory");
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
		panelAdminToolbar.add(btnInventory);
		
		JButton btnLogOut = new JButton("Log Out");
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
		panelAdminToolbar.add(btnLogOut);
		
		JButton btnEmployee = new JButton("Employee");
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
		panelAdminToolbar.add(btnEmployee);
		
		JButton btnOrders = new JButton("Orders");
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
		panelAdminToolbar.add(btnOrders);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 160, 184, 52);
		panelAdminToolbar.add(panel);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMenu.setBounds(75, 0, 109, 52);
		panel.add(lblMenu);
		
		JButton btnHome = new JButton("Home");
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
		panelAdminToolbar.add(btnHome);
		
		JButton btnProfile = new JButton("Profile");
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
		panelAdminToolbar.add(btnProfile);
		
		JLabel lblLogo = new JLabel("Fast Food Management System");
		lblLogo.setForeground(new Color(255, 204, 51));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(289, 0, 417, 58);
		contentPane.add(lblLogo);
		
		JLabel lblMenuPage = new JLabel("Menu Page");
		lblMenuPage.setForeground(new Color(255, 204, 51));
		lblMenuPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMenuPage.setBounds(405, 50, 90, 35);
		contentPane.add(lblMenuPage);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setForeground(Color.WHITE);
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistration.setBounds(194, 85, 74, 21);
		contentPane.add(lblRegistration);
		
		JPanel panelRegistration = new JPanel();
		panelRegistration.setLayout(null);
		panelRegistration.setBounds(193, 102, 176, 80);
		contentPane.add(panelRegistration);
		
		JLabel lblFoodPrice = new JLabel("Price");
		lblFoodPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFoodPrice.setBounds(10, 30, 49, 16);
		panelRegistration.add(lblFoodPrice);
		
		JLabel foodTypeLabel = new JLabel("Type");
		foodTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		foodTypeLabel.setBounds(10, 55, 49, 14);
		panelRegistration.add(foodTypeLabel);
		
		txtFoodPrice = new JTextField();
		txtFoodPrice.setColumns(10);
		txtFoodPrice.setBounds(69, 32, 97, 16);
		panelRegistration.add(txtFoodPrice);
		
		JLabel lblFoodName = new JLabel("Food Name");
		lblFoodName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFoodName.setBounds(10, 10, 64, 16);
		panelRegistration.add(lblFoodName);
		
		txtFoodName = new JTextField();
		txtFoodName.setColumns(10);
		txtFoodName.setBounds(70, 10, 96, 16);
		panelRegistration.add(txtFoodName);
		
		FoodTypeBox = new JComboBox();
		FoodTypeBox.setBounds(69, 56, 97, 16);
		FoodTypeBox.addItem("");
		FoodTypeBox.addItem("Burger");
		FoodTypeBox.addItem("Pizza");
		FoodTypeBox.addItem("Drink");
		panelRegistration.add(FoodTypeBox);
		
		JLabel lblMenuList = new JLabel("Menu");
		lblMenuList.setForeground(Color.WHITE);
		lblMenuList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMenuList.setBounds(379, 161, 110, 21);
		contentPane.add(lblMenuList);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(380, 180, 317, 196);
		contentPane.add(scrollPane);
		
		displayFood();
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearch.setBounds(379, 85, 74, 21);
		contentPane.add(lblSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFoodId.setText("");
				txtFoodName.setText("");
				txtFoodPrice.setText("");
				FoodTypeBox.setSelectedItem("");
				for (int i = 0; i < ing.length; i++) {
					jt[i].setText("");
				}
			}
		});
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(289, 343, 72, 23);
		contentPane.add(btnClear);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setBounds(203, 343, 72, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(this);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(null);
		panelSearch.setBounds(381, 103, 316, 37);
		contentPane.add(panelSearch);
		
		JLabel lblFoodId = new JLabel("Food Id");
		lblFoodId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFoodId.setBounds(10, 11, 49, 14);
		panelSearch.add(lblFoodId);
		
		txtFoodId = new JTextField();
		txtFoodId.setColumns(10);
		txtFoodId.setBounds(63, 11, 151, 17);
		panelSearch.add(txtFoodId);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(211, 11, 95, 17);
		panelSearch.add(btnSearch);
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.addActionListener(this);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(this);
		btnLoad.setBackground(Color.LIGHT_GRAY);
		btnLoad.setBounds(396, 384, 86, 23);
		contentPane.add(btnLoad);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setBounds(496, 384, 86, 23);
		btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( txtFoodId.getText().isEmpty() ) 
					JOptionPane.showMessageDialog(null, "Please enter Id!");
				else {
					Food.deleteFood(txtFoodId.getText());
					displayFood();
				}
			}
		});
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setBounds(592, 384, 86, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(194, 192, 175, 140);
		JPanel jp = new JPanel(new GridLayout(0,2,0,0));
		jp.setBounds(194, 123, 175, 128);
		
		contentPane.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		ing =  Ingredient.getAllIngredientsInDatabase(); 
		JLabel jl[] = new JLabel[ing.length];
		jt = new JTextField[ing.length];
		
		for (int i = 0; i < ing.length;i++ ) {
			jl[i] = new  JLabel();
			jt[i] = new JTextField();
			
			jl[i].setText(ing[i].getItemName());
			panel_1.add(jl[i]);
			panel_1.add(jt[i]);
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add")) {
			
			if (txtFoodName.getText().isBlank() || txtFoodPrice.getText().isBlank() || FoodTypeBox.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog( null, "Please enter a valid value!\n" );
			}
			
			else {
			
				double recipe[] = new double[ing.length]; 
				
				for (int i = 0; i < ing.length; i++) {
					
					if (jt[i].getText().isBlank()) {
						jt[i].setText("0");
					}
					
					recipe[i] = Double.parseDouble(jt[i].getText());
				}
				
				Food f = new Food(txtFoodName.getText(),Double.parseDouble(txtFoodPrice.getText()),(String)FoodTypeBox.getSelectedItem(),recipe );
				
				f.addFood();
			}
			displayFood();
		}
		else if (e.getActionCommand().equals("Load")) {
			displayFood();
		}
		else if (e.getActionCommand().equals("Search")) {
//			if (txtFoodId.getText().isBlank()) {
//				JOptionPane.showMessageDialog(null,"Please Enter a valid ID");
//			}
//			else {
//				
//				Food f = Food.searchFood((int)  Double.parseDouble(txtFoodId.getText()));
//
//				txtFoodName.setText(f.getFoodName());
//				txtFoodPrice.setText(f.getFoodPrice()+ "");
//				FoodTypeBox.setSelectedItem(f.getFoodType());
//				double [] recipe =f.getRecipe();
//				
//				for (int i=0; i<recipe.length; i++ ) {
//					jt[i].setText(recipe[i] +  "");
//				}
//				
//			}
			
			if (txtFoodId.getText().isBlank()) 
				JOptionPane.showMessageDialog(null, "Please enter Id!");
			else {
				Food food = new Food();
				ResultSet result = food.SearchFood(Integer.parseInt(txtFoodId.getText()));
				
				if ( result != null ) {
					getValue(result);
				}
				else
					JOptionPane.showMessageDialog(null, "No result found!");
			}
		}
		else if (e.getActionCommand().equals("Update")) {
			Food f = Food.searchFood( (int) Double.parseDouble(txtFoodId.getText()) );
			
			if (txtFoodName.getText().isBlank() || txtFoodPrice.getText().isBlank() || FoodTypeBox.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null,"Please Enter a valid Name, Price or Type");
			} 
			else {
			
					double recipe[] = new double[ing.length]; 
				
					for (int i = 0; i < ing.length; i++) {
					
						if (jt[i].getText().isBlank()) {
							jt[i].setText("0");
						}
					
						recipe[i] = Double.parseDouble(jt[i].getText());
						
					}
				f.setFoodName(txtFoodName.getText());
				f.setFoodPrice(Double.parseDouble( txtFoodPrice.getText()));
				f.setFoodType((String)  FoodTypeBox.getSelectedItem());
			
				f.setRecipe(recipe);
				f.updateFood();
				displayFood();
			}
		}
	
	}
	public void displayFood() {
		foodTable = new JTable (Food.getAllFoodsAs2D(),Food.getColumnNames());
		
		for (int i = 0; i < Food.getColumnNames().length;i++ ) {
			foodTable.getColumnModel().getColumn(i).setPreferredWidth(60);
		} 
		
		foodTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		foodTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(foodTable);
		
	}
	
	private void getValue( ResultSet result ) {										//Sets the text fields with the searched ingredient info
		
		Food f = Food.searchFood((int)  Double.parseDouble(txtFoodId.getText()));
		
		try {
			
			txtFoodName.setText(result.getString("name"));
			txtFoodPrice.setText(result.getString("price"));
			FoodTypeBox.setSelectedItem(result.getString("foodType"));
			double [] recipe = f.getRecipe();
			
			for (int i=0; i<recipe.length; i++ ) {
				jt[i].setText(recipe[i] +  "");
			}
		} 
		catch (SQLException e1) {
			JOptionPane.showInternalMessageDialog(null, "Something went worng on getValue of MenuPage! \n" + e1);
		}
	}
}



