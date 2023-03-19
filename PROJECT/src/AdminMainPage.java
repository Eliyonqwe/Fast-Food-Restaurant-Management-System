import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import Classes.Admin;


public class AdminMainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainPage frame = new AdminMainPage();
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
	public AdminMainPage() {
		
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
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(289, 0, 417, 58);
		contentPane.add(lblLogo);
		
		JLabel lblAdminPage = new JLabel("Admin Page");						//Label for "Admin Page"			
		lblAdminPage.setForeground(Color.WHITE);
		lblAdminPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdminPage.setBounds(395, 50, 125, 35);
		contentPane.add(lblAdminPage);
		
		JButton btnEmployee = new JButton("Employee");						//Button that says "Employee"
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
		panelSidebar.add(btnProfile);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 94, 32);
		panelSidebar.add(panel);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setBounds(0, 0, 94, 32);
		panel.add(lblHome);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHome.setBackground(new Color(51, 51, 51));
		
		JLabel lblPicture = new JLabel("");									//Label for a picture called RMS.jpg
		Image img = new ImageIcon(this.getClass().getResource("/RMS.jpg")).getImage();
		lblPicture.setIcon(new ImageIcon(img));
		lblPicture.setBounds(318, 156, 259, 202);
		contentPane.add(lblPicture);
		
		JLabel lblWelcome = new JLabel("Welcome back!");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(318, 115, 259, 20);
		contentPane.add(lblWelcome);
		
	}
}
