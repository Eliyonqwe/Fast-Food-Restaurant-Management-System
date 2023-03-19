package Classes;

import java.sql.*;
import javax.swing.*;

public class DBConnectionClass {
	
	public static Connection con;
	
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String URL = "jdbc:sqlserver://Eliyon;databaseName=ProjectDB;integratedSecurity=true;encrypt=false";
			con = DriverManager.getConnection(URL);
			JOptionPane.showMessageDialog(null, "Connected successfully!");
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to connect!\n" + e);
		}
	
	}
	
	public static Connection ProjectDBConnector() {
		return con;
	}
	
}

