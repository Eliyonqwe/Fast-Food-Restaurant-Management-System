import java.sql.*;
import Classes.DBConnectionClass;

public class MainClass {
	
	public static String loggedInAdmin;			//For storing currently logged-in Admins
	public static String loggedInWaiter;		//For storing currently logged-in Waiters
	public static String loggedInCustomer;		//For storing currently logged-in Customer

	public static void main(String[] args) {
		
		Connection con = DBConnectionClass.ProjectDBConnector();	//Creates connection to the database
		
		WelcomePage wp = new WelcomePage();
		wp.setVisible(true);										//Makes the WelcomePage visible
		
	}

}
