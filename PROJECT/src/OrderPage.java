import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import Classes.Food;
import Classes.Orders;


public class OrderPage extends JFrame {

	private JPanel contentPane;
	private JTable tblOrders;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPage frame = new OrderPage();
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
	public OrderPage() {
		
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
		
		JLabel lblOrderPage = new JLabel("Order Page");								//Label for "Order Page"
		lblOrderPage.setForeground(new Color(255, 204, 51));
		lblOrderPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrderPage.setBounds(400, 50, 125, 35);
		contentPane.add(lblOrderPage);

		JPanel panel = new JPanel();												//Panel for storing the label that says "Orders"
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 260, 184, 52);
		panelSidebar.add(panel);
		
		JLabel lblOrders = new JLabel("Orders");									//Label for "Orders"
		lblOrders.setForeground(Color.WHITE);
		lblOrders.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrders.setBounds(72, 0, 112, 52);
		panel.add(lblOrders);

		JButton btnHome = new JButton("Home");									//Button that says "Home"
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
		
		JButton btnInventory = new JButton("Inventory");							//Button that says "Inventory"
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
		
		JLabel lblOrderList = new JLabel("Order Table");							//Label for "Order Table"
		lblOrderList.setForeground(Color.WHITE);
		lblOrderList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrderList.setBounds(216, 80, 110, 21);
		contentPane.add(lblOrderList);
		
		JButton btnLoad = new JButton("Load");										//Button that says "Load"
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders orders = new Orders();
				orders.listOrders(tblOrders);
			}
		});
		btnLoad.setBackground(Color.LIGHT_GRAY);
		btnLoad.setBounds(407, 385, 86, 23);
		contentPane.add(btnLoad);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(216, 100, 467, 275);
		contentPane.add(scrollPane);
		
		tblOrders = new JTable();
		tblOrders.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(tblOrders);
	}
}
