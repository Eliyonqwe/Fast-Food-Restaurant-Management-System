package Classes;

import java.sql.*;
import javax.swing.*;

/**
 * customer class
 * 
 */
public class Customer extends Person{
	//Fields
	private String customerId;
	private String email;
	
	//METHODS
	public boolean verifyUser( String username, String password ) {
		
		this.username = username;
		this.password = password;
		
		try {
			
			String query = "SELECT * FROM customer WHERE username=? AND password=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating the statement
			pst.setString(1, this.username);							//Setting placeholder values
			pst.setString(2, this.password);
			
			ResultSet rs = pst.executeQuery();							//Executing the statement
			
			if (rs.next())
				return true;
			else
				return false;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong while verifying the customer!\n" + ex );
			return false;
		}
	}
	
	public boolean addCustomer ( String firstName, String lastName,String username, String password, String email ) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		
		try {
			
			String query = "INSERT INTO customer VALUES (?,?,?,?,?)";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing a connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating the statement
			pst.setString(1, this.firstName); 							//Setting placeholder values
			pst.setString(2,this.lastName);
			pst.setString(3,this.username);
			pst.setString(4,this.password);
			pst.setString(5,this.email);
			
			pst.executeUpdate();										//Executing the statement
			
			JOptionPane.showMessageDialog( null, "Sucessfully added"  );
			return true;
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in addCustomer!\n" + ex );
			return false;
			
		}
		
	}
	
	public ResultSet getCustomerId (String username) {
		
		this.username = username;
		
		try {
			
			String query = "SELECT customerId FROM customer WHERE username=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating the statement
			pst.setString(1, this.username);							//Setting placeholder values
			
			ResultSet rs = pst.executeQuery();							//Executing the statement
			
			if (rs.next())
				return rs;												//Returns the waiterId
			else
				return null;
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in getCustomerId!\n" + ex);
			return null;
		}
	}
	
}
