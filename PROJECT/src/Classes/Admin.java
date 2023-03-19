package Classes;

import java.sql.*;
import javax.swing.*;

public class Admin extends Person{
	
	//Fields
	private String adminId;
	
	//METHODS
	public boolean verifyUser( String username, String password ) {
		
		this.username = username;
		this.password = password;
		
		try {
			
			String query = "SELECT * FROM admin WHERE username=? AND password=?";
			
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
			JOptionPane.showMessageDialog( null, "Something went wrong while verifying admin!\n" + ex );
			return false;
		}
	}
	
	public boolean updateAdmin( String firstName, String lastName, String username, String password, String adminId ) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.adminId = adminId;
		
		try {
			
			String query = "UPDATE admin SET firstName=?, lastName=?, username=?, password=? WHERE adminId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating a statement
			pst.setString(1, this.firstName);							//Setting placeholder values			
			pst.setString(2, this.lastName);
			pst.setString(3, this.username);
			pst.setString(4, this.password);
			pst.setString(5, this.adminId);
			
			pst.executeUpdate();										//Executing the statement
			
			return true;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in updateAdmin!\n" + ex );
			return false;
		}
	}
	
	public ResultSet searchAdmin(String adminId) {
		
		this.adminId = adminId;
		
		try {
			
			String query = "SELECT * FROM admin WHERE adminId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating the statement
			pst.setString(1, this.adminId);								//Setting placeholder values
			
			ResultSet rs = pst.executeQuery();							//Executing the statement
			
			if (rs.next())
				return rs;												//Returns the ResultSet
			else
				return null;
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in searchAdmin!\n" + ex);
			return null;
		}
	}
	
	/*
	 * Gets and returns the admins Id by using the username
	 */
	public ResultSet getAdminId (String username) {
		
		this.username = username;
		
		try {
			
			String query = "SELECT adminId FROM admin WHERE username=?";
			
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
			JOptionPane.showMessageDialog(null, "Something went wrong in getAdminId!\n" + ex);
			return null;
		}
	}
	
}
