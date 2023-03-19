import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Orders;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class WaiterOrderPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaiterOrderPage frame = new WaiterOrderPage();
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
	public WaiterOrderPage() {
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
		
		JButton btnLogOut = new JButton("Log Out");
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
		panelAdminToolbar.add(btnLogOut);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 186, 184, 52);
		panelAdminToolbar.add(panel);
		
		JLabel lblOrders = new JLabel("Orders");
		lblOrders.setForeground(Color.WHITE);
		lblOrders.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrders.setBounds(73, 0, 111, 52);
		panel.add(lblOrders);
		
		JButton btnProfile_1 = new JButton("Home");
		btnProfile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WaiterMainPage wmp = new WaiterMainPage();
				wmp.setVisible(true);
			}
		});
		btnProfile_1.setForeground(Color.WHITE);
		btnProfile_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProfile_1.setBackground(Color.GRAY);
		btnProfile_1.setBounds(0, 0, 94, 32);
		panelAdminToolbar.add(btnProfile_1);
		
		JButton btnProfile_1_1 = new JButton("Profile");
		btnProfile_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WaiterProfilePage wp = new WaiterProfilePage();
				wp.setVisible(true);
			}
		});
		btnProfile_1_1.setForeground(Color.WHITE);
		btnProfile_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProfile_1_1.setBackground(Color.GRAY);
		btnProfile_1_1.setBounds(90, 0, 94, 32);
		panelAdminToolbar.add(btnProfile_1_1);
		
		JLabel lblLogo = new JLabel("Fast Food Management System");
		lblLogo.setForeground(new Color(255, 204, 51));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(289, 0, 417, 58);
		contentPane.add(lblLogo);
		
		JLabel lblOrderPage = new JLabel("Order Page");
		lblOrderPage.setForeground(new Color(255, 204, 51));
		lblOrderPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrderPage.setBounds(395, 50, 125, 35);
		contentPane.add(lblOrderPage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 100, 452, 275);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders orders = new Orders();
				orders.listWaitersOrder(table, MainClass.loggedInWaiter);
			}
		});
		btnLoad.setBackground(Color.LIGHT_GRAY);
		btnLoad.setBounds(407, 385, 86, 23);
		contentPane.add(btnLoad);
		
		JLabel lblOrderList = new JLabel("Order Table");
		lblOrderList.setForeground(Color.WHITE);
		lblOrderList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrderList.setBounds(225, 82, 110, 21);
		contentPane.add(lblOrderList);
	}
}
