import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.border.EmptyBorder;

import Classes.Admin;
import Classes.Waiter;


public class WaiterMainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaiterMainPage frame = new WaiterMainPage();
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
	public WaiterMainPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSidebar = new JPanel();									//Panel for the sidebar
		panelSidebar.setLayout(null);
		panelSidebar.setBackground(new Color(255, 204, 51));
		panelSidebar.setBounds(0, 0, 184, 418);
		contentPane.add(panelSidebar);
		
		JLabel lblLogo = new JLabel("Fast Food Management System");			//Label for "Fast Food Management System"
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(289, 0, 417, 58);
		contentPane.add(lblLogo);
		
		JLabel lblWaiterPage = new JLabel("Waiter Page");					//Label for "Waiter Page"
		lblWaiterPage.setForeground(Color.WHITE);
		lblWaiterPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWaiterPage.setBounds(395, 50, 125, 35);
		contentPane.add(lblWaiterPage);
		
		JButton btnOrders = new JButton("Orders");							//Button that says "Orders"
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WaiterOrderPage wp = new WaiterOrderPage();
				wp.setVisible(true);
			}
		});
		btnOrders.setForeground(Color.WHITE);
		btnOrders.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOrders.setBackground(new Color(255, 204, 51));
		btnOrders.setBounds(0, 186, 184, 52);
		panelSidebar.add(btnOrders);
		
		JButton btnLogOut = new JButton("Log Out");							//Button that says "Log Out"
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to log-out?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if ( response == JOptionPane.YES_OPTION) {
					setVisible(false);
					WaiterLoginPage wl = new WaiterLoginPage();
					wl.setVisible(true);
				}
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogOut.setBackground(new Color(255, 204, 51));
		btnLogOut.setBounds(0, 235, 184, 52);
		panelSidebar.add(btnLogOut);
		
		JButton btnProfile_1 = new JButton("Profile");						//Button that says "Profile"
		btnProfile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WaiterProfilePage wp = new WaiterProfilePage();
				wp.setVisible(true);
			}
		});
		btnProfile_1.setForeground(Color.WHITE);
		btnProfile_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProfile_1.setBackground(Color.GRAY);
		btnProfile_1.setBounds(90, 0, 94, 32);
		panelSidebar.add(btnProfile_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 94, 32);
		panelSidebar.add(panel);
		
		JLabel lblHome_1 = new JLabel("Home");
		lblHome_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome_1.setForeground(Color.WHITE);
		lblHome_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHome_1.setBackground(new Color(51, 51, 51));
		lblHome_1.setBounds(0, 0, 94, 32);
		panel.add(lblHome_1);
		
		JLabel lblPicture = new JLabel("");									//Label for a picture called FFMS.jpg
		Image img = new ImageIcon(this.getClass().getResource("/FFMS.jpg")).getImage();
		lblPicture.setIcon(new ImageIcon(img));
		lblPicture.setBounds(318, 156, 259, 202);
		contentPane.add(lblPicture);
		
		JLabel lblWelcome = new JLabel("Welcome back!");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(318, 115, 259, 20);
		contentPane.add(lblWelcome);
	}
}
