import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.border.EmptyBorder;
import Classes.Waiter;
import Classes.Customer;
import Classes.Food;
import Classes.Orders;

public class CustomersPage extends JFrame {

	private JPanel contentPane;
	private JScrollPane sp;
	private JTextField txtBeefBurgerPrice;
	private JTextField txtCheeseBurgerPrice;
	private JTextField txtDoubleBurgerPrice;
	private JTextField txtSpecialBurgerPrice;
	private JTextField txtCheesePizzaPrice;
	private JTextField txtSpecialPizzaPrice;
	private JTextField txtSoftDrinkPrice;
	private JTextField txtWaterPrice;
	private JTextField txtBeefBurgerAmount;
	private JTextField txtCheeseBurgerAmount;
	private JTextField txtDouleBurgerAmount;
	private JTextField txtSpecialBurgerAmount;
	private JTextField txtCheesePizzaAmount;
	private JTextField txtSpecialPizzaAmount;
	private JTextField txtSoftDrinkAmount;
	private JTextField textField_15txtWaterAmount;
	private JTextField txtTotal;
	private JTextField txtTax;
	private JTextField txtNetTotal;
	private int lastwaiterAssignedId = Waiter.getFirstWaiterID();
	private int lastWaiterId = Waiter.getLastWaiterID();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextArea txtArea;
	private int waiterCounter = 1;
	private int waiterCount = Waiter.getWaiterCount();
	private static final double DISCOUNT = 0.1;
	private static final double TAX = 0.15;
	
	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomersPage frame = new CustomersPage();
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
	public CustomersPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MainClass.loggedInCustomer = null;
		
		JLabel lblLogo = new JLabel("Fast Food Management System");
		lblLogo.setForeground(new Color(255, 204, 51));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(133, 0, 321, 58);
		contentPane.add(lblLogo);
		
		JButton btnAdminSignIn = new JButton("Admin Sign In");
		btnAdminSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminLoginPage al = new AdminLoginPage();
				al.setVisible(true);
			}
		});
		btnAdminSignIn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdminSignIn.setBackground(Color.LIGHT_GRAY);
		btnAdminSignIn.setBounds(578, 22, 105, 23);
		contentPane.add(btnAdminSignIn);
		
		JButton btnWaiterSignIn = new JButton("Waiter Sign In");
		btnWaiterSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WaiterLoginPage wl = new WaiterLoginPage();
				wl.setVisible(true);
			}
		});
		btnWaiterSignIn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnWaiterSignIn.setBackground(Color.LIGHT_GRAY);
		btnWaiterSignIn.setBounds(578, 56, 105, 23);
		contentPane.add(btnWaiterSignIn);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(403, 80, 40, 21);
		contentPane.add(lblPrice);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmount.setBounds(465, 80, 55, 21);
		contentPane.add(lblAmount);
		
		Food f[] = Food.getAllFoodRecords();
		
		displayMenu( f);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(543, 105, 153, 302);
		contentPane.add(panel);
		
		JLabel lblTotal = new JLabel("Total   ..........");
		lblTotal.setBounds(10, 240, 92, 14);
		panel.add(lblTotal);
		
		JLabel lblTax = new JLabel("Tax   .............");
		lblTax.setBounds(10, 260, 92, 14);
		panel.add(lblTax);
		
		JLabel lblNetTotal = new JLabel("Net Total   ......");
		lblNetTotal.setBounds(10, 280, 92, 14);
		panel.add(lblNetTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(87, 237, 56, 20);
		panel.add(txtTotal);
		
		txtTax = new JTextField();
		txtTax.setEditable(false);
		txtTax.setColumns(10);
		txtTax.setBounds(87, 257, 56, 20);
		panel.add(txtTax);
		
		txtNetTotal = new JTextField();
		txtNetTotal.setEditable(false);
		txtNetTotal.setColumns(10);
		txtNetTotal.setBounds(87, 277, 56, 20);
		panel.add(txtNetTotal);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(10, 55, 92, 16);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(10, 100, 92, 16);
		panel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(10, 74, 133, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(10, 120, 133, 20);
		panel.add(txtPassword);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CreateAccountPage cap = new CreateAccountPage();
				cap.setVisible(true);
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSignUp.setBackground(Color.LIGHT_GRAY);
		btnSignUp.setBounds(30, 186, 89, 20);
		panel.add(btnSignUp);
		
		JLabel lblReciept = new JLabel("Reciept");
		lblReciept.setForeground(Color.WHITE);
		lblReciept.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReciept.setBounds(543, 85, 63, 20);
		contentPane.add(lblReciept);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please enter your Username!");
				else if (txtPassword.getText().isBlank())
					JOptionPane.showMessageDialog(null, "Please enter your Password!");
				else {
					
					Customer customer = new Customer();
					boolean valid = customer.verifyUser(txtUsername.getText(), txtPassword.getText());
					
					if (valid) {
						JOptionPane.showMessageDialog(null, "Sign-In successful");
						panel.remove(lblUsername);
						panel.remove(lblPassword);
						panel.remove(txtUsername);
						panel.remove(txtPassword);
						panel.remove(btnSignIn);
						panel.remove(btnSignUp);
						
						txtArea = new JTextArea();
						txtArea.setBounds(10, 51, 135, 155);
						panel.add(txtArea);
						txtArea.setText("Welcome back! \n\nYou will have a 10% \ndiscount because you \nare signed in! ");
						txtArea.setEditable(false);
						txtArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
						
						ResultSet rs = customer.getCustomerId(txtUsername.getText());				//Returns the id of logged in customer
						try {
							MainClass.loggedInCustomer = rs.getString("customerId");				//Stores the id in the "LoggedInCustomer" variable
						}
						catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Something went wrong while getting customerId!\n" + e1);
						}
									
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid username or password!");
				}
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSignIn.setBackground(Color.LIGHT_GRAY);
		btnSignIn.setBounds(30, 155, 89, 20);
		panel.add(btnSignIn);
		
		JLabel lblNewLabel_2 = new JLabel("Reciept");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(30, 9, 89, 20);
		panel.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 40, 153, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 227, 153, 2);
		panel.add(separator_1);
		
	}
	
	void displayMenu(Food f[]) {
		
		int usedComponent = 0;
		int yCheckBox = 102;
		int yDotLabel = 105;
		int yPriceTxtField = 103;
		int heightFrame ;
		
		JCheckBox ch[] = new JCheckBox[f.length];
		JLabel lab[] = new JLabel[f.length];
		JTextField price[] = new JTextField[f.length];
		JTextField amount[] = new JTextField[f.length];
			
		JLabel lblBurgersList = new JLabel("Burgers");
		lblBurgersList.setForeground(Color.WHITE);
		lblBurgersList.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBurgersList.setBounds(30, 80, 74, 21);
		contentPane.add(lblBurgersList);
			
			
		/**
		 * Loop to display burger 
		 * 
		 * */
		for (int i = 0; i < f.length;i++) {
			
			if (f[i].getFoodType().equals("Burger")) {
				
				ch[usedComponent] = new JCheckBox(f[i].getFoodName());
				ch[usedComponent].setForeground(Color.WHITE);
				ch[usedComponent].setFont(new Font("Tahoma", Font.PLAIN, 11));
				ch[usedComponent].setBackground(new Color(51, 51, 51));
				ch[usedComponent].setBounds(50, yCheckBox, 83, 23);
				contentPane.add(ch[usedComponent]);
				
				
				 lab[usedComponent] = new JLabel("  .............................................................................");
				lab[usedComponent].setForeground(Color.WHITE);
				lab[usedComponent].setFont(new Font("Tahoma", Font.PLAIN, 11));
				lab[usedComponent].setBounds(139, yDotLabel, 251, 16);
				contentPane.add(lab[usedComponent]);
				
				price[usedComponent] = new JTextField(f[i].getFoodPrice()+"");
				price[usedComponent].setEditable(false);
				price[usedComponent].setColumns(10);
				price[usedComponent].setBounds(398, yPriceTxtField, 46, 20);
				contentPane.add(price[usedComponent]);
				
				amount[usedComponent] = new JTextField();
				amount[usedComponent].setColumns(10);
				amount[usedComponent].setBounds(465, yPriceTxtField, 50, 20);
				contentPane.add(amount[usedComponent]);
				
				yPriceTxtField += 20;
				yDotLabel += 20;
				yCheckBox += 20;
				usedComponent++;
			}
			
		}
		
		yCheckBox+=28;
		yPriceTxtField += 28;
		yDotLabel += 28;
			
		JLabel lblPizzaList = new JLabel("Pizza");
		lblPizzaList.setForeground(Color.WHITE);
		lblPizzaList.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPizzaList.setBounds(30, yCheckBox, 74, 21);
		contentPane.add(lblPizzaList);
			
		yCheckBox+=21;
		yPriceTxtField += 21;
		yDotLabel += 21;
			
		/**
		 * Loop to display pizza 
		 * 
		 * */
			
		for (int i = 0; i < f.length;i++) {
				
			if (f[i].getFoodType().equals("Pizza")) {
					
				ch[usedComponent] = new JCheckBox(f[i].getFoodName());
				ch[usedComponent].setForeground(Color.WHITE);
				ch[usedComponent].setFont(new Font("Tahoma", Font.PLAIN, 11));
				ch[usedComponent].setBackground(new Color(51, 51, 51));
				ch[usedComponent].setBounds(50, yCheckBox, 83, 23);
				contentPane.add(ch[usedComponent]);
				
				lab[usedComponent] = new JLabel("  .............................................................................");
				lab[usedComponent].setForeground(Color.WHITE);
				lab[usedComponent].setFont(new Font("Tahoma", Font.PLAIN, 11));
				lab[usedComponent].setBounds(139, yDotLabel, 251, 16);
				contentPane.add(lab[usedComponent]);
					
				price[usedComponent] = new JTextField(f[i].getFoodPrice()+"");
				price[usedComponent].setEditable(false);
				price[usedComponent].setColumns(10);
				price[usedComponent].setBounds(398, yPriceTxtField, 46, 20);
				contentPane.add(price[usedComponent]);
				
				amount[usedComponent] = new JTextField();
				amount[usedComponent].setColumns(10);
				amount[usedComponent].setBounds(465, yPriceTxtField, 50, 20);
				contentPane.add(amount[usedComponent]);
				
				yPriceTxtField += 20;
				yDotLabel += 20;
				yCheckBox += 20;
					
				usedComponent++;
			}
				
		}
		/**
		 * Loop to display drinks 
		 * 
		 * */
		yCheckBox+=28;
		yPriceTxtField += 28;
		yDotLabel += 28;
			
		JLabel lblDrinksList = new JLabel("Drinks");
		lblDrinksList.setForeground(Color.WHITE);
		lblDrinksList.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDrinksList.setBounds(30, yCheckBox, 74, 21);
		contentPane.add(lblDrinksList);
			
		yCheckBox+=21;
		yPriceTxtField += 21;
		yDotLabel += 21;
				
		for (int i = 0; i < f.length; i++) {
			if (f[i].getFoodType().equalsIgnoreCase("Drink")) {
					
				ch[usedComponent] = new JCheckBox(f[i].getFoodName());
				ch[usedComponent].setForeground(Color.WHITE);
				ch[usedComponent].setFont(new Font("Tahoma", Font.PLAIN, 11));
				ch[usedComponent].setBackground(new Color(51, 51, 51));
				ch[usedComponent].setBounds(50, yCheckBox, 83, 23);
				contentPane.add(ch[usedComponent]);
					
				lab[usedComponent] = new JLabel("  .............................................................................");
				lab[usedComponent].setForeground(Color.WHITE);
				lab[usedComponent].setFont(new Font("Tahoma", Font.PLAIN, 11));
				lab[usedComponent].setBounds(139, yDotLabel, 251, 16);
				contentPane.add(lab[usedComponent]);
					
				price[usedComponent] = new JTextField(f[i].getFoodPrice()+"");
				price[usedComponent].setEditable(false);
				price[usedComponent].setColumns(10);
				price[usedComponent].setBounds(398, yPriceTxtField, 46, 20);
				contentPane.add(price[usedComponent]);
					
				amount[usedComponent] = new JTextField();
				amount[usedComponent].setColumns(10);
				amount[usedComponent].setBounds(465, yPriceTxtField, 50, 20);
				contentPane.add(amount[usedComponent]);
				
				yPriceTxtField += 20;
				yDotLabel += 20;
				yCheckBox += 20;
					
				usedComponent++;
			}
		}
		/**
		 * 
		 *		For positioning the order button  
		 * */
			
		yCheckBox += 59; 
		
		JButton btnOrder = new JButton("Order");
			
		/**
		 * assign waiters                                     +++
		 * create orders object and save it into the database +++
		 *	check for discount and give it                    +++
		 *	create orders object and add it to database       +++
		 *	Subtract food recipe from ingredients             +++
		 *
		 */
				
		
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean valid = true;
				
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to order?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if ( response == JOptionPane.YES_OPTION) {
					
					int customerId = -1;
					int waiterId = -1;
					
					Customer customer = new Customer();
					
					if (waiterCount == waiterCounter ) {
						waiterId = Waiter.getWaiterAt(waiterCounter);
						waiterCounter = 1;
					}
					else if (waiterCount  >  waiterCounter) {
						waiterId = Waiter.getWaiterAt(waiterCounter++);
					}
					 
					//if (!MainClass.loggedInCustomer.equals("")) {
					//	customerId = (int) Double.parseDouble(MainClass.loggedInCustomer);
					//}
					
						
						
					 /**
					  * to display the receipt
					  */
							 
					double total = 0;
					double netTotal;
					for (int i = 0; i < f.length; i++) {
							
						if(ch[i].isSelected()) {
							int am;
							if (amount[i].getText().isBlank()) {
								amount[i].setText("1");
								am = 1;
								total += am * Double.parseDouble(price[i].getText());
							}
							else {
								am = (int) Double.parseDouble(amount[i].getText());
								total += am * Double.parseDouble(price[i].getText());
							}
							/**
							 * Deduct food recipe 
							 */
							valid = Food.Recipe.deductRecipeFromInventory(Food.searchFoodID(ch[i].getText()), am);
							
							if (!valid) {
								JOptionPane.showMessageDialog(null, "Sorry, but order can't be made because there aren't enough ingredients left to make the food. \n"
										+ "Please try another food until we get ingredients!");
								break;
							}
								
						}
							
						DecimalFormat df = new DecimalFormat("0.00");
						netTotal = ((total * TAX) + total);
						
						if ( MainClass.loggedInCustomer != null )
							netTotal = netTotal - (netTotal*DISCOUNT);
						
						txtTotal.setText(df.format(total) );
						txtTax.setText(df.format( (total*TAX) ));
						txtNetTotal.setText(df.format( netTotal ));
					}
						 
					 /**
					   * Creating orders object 
					   */
					if (valid) {	 
						Orders newOrder= new Orders (MainClass.loggedInCustomer,waiterId,total);
						newOrder.addOrder();
					}
				}
			}
		});
		btnOrder.setBackground(Color.LIGHT_GRAY);
		btnOrder.setBounds(226,yCheckBox-20, 89, 23);
		contentPane.add(btnOrder);
		/**
		 * to set the frame to the exact size we use the y of the last component 
		 *  455 - 361 = 94
		 */
		if (yCheckBox + 94 > 455) {
		heightFrame = yCheckBox + 94;
		
		contentPane.setBounds(250, 100, 720, heightFrame );
		setBounds(255, 0, 720, heightFrame );
		}
			
	}
}
