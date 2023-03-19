import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class WelcomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LogoPanel = new JPanel();											//Panel for the Logo
		LogoPanel.setLayout(null);
		LogoPanel.setBackground(new Color(255, 204, 51));
		LogoPanel.setBounds(0, 0, 706, 58);
		contentPane.add(LogoPanel);
		
		JLabel lblLogo = new JLabel("Fast Food Restaurant");						//Label for "Fast Food Restaurant"
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setBounds(246, 0, 242, 58);
		LogoPanel.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("Welcome to our fast food restaurant!");	//Label for "Welcome to our fast food restaurant
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(237, 163, 249, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Order Food  ");							//Button that says "Order food"
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CustomersPage cp = new CustomersPage();
				cp.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(311, 234, 100, 23);
		contentPane.add(btnNewButton);
	}
}
