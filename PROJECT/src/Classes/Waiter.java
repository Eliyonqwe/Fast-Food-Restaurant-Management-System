package Classes;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Waiter extends Person{
	
	//Fields
	private String waiterId;
	private String gender;
	private int age;
	private double salary;
	private int experiance;
	
	
	//METHODS
	public boolean verifyUser( String username, String password ) {
		
		this.username = username;
		this.password = password;
		
		try {
			
			String query = "SELECT * FROM waiter WHERE username=? AND password=?";
			
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
			JOptionPane.showMessageDialog( null, "Something went wrong while verifying waiter!\n" + ex );
			return false;
		}
	}
	
	public boolean addWaiter ( String firstName, String lastName, String username, String password, String gender, int age, double salary, int experiance ) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.experiance = experiance;
		
		try {
			
			String query = "INSERT INTO waiter VALUES (?,?,?,?,?,?,?,?);";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating a statement
			pst.setString(1, this.firstName); 							//Setting placeholder values
			pst.setString(2,this.lastName);
			pst.setString(3,this.username);
			pst.setString(4,this.password);
			pst.setString(5,this.gender);
			pst.setInt(6,this.age);
			pst.setDouble(7,this.salary);
			pst.setInt(8,this.experiance);
			
			pst.executeUpdate();										//Execute the statement
			
			return true;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in addWaiter!\n" + ex );
			return false;
		}
	}
	
	public void listWaiter(JTable table) {
		
		try {
			
			String query = "SELECT * FROM waiter";
			
			table.setModel( new DefaultTableModel() );					//For clearing the previous table 
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			Statement stm = con.createStatement();						//Creating a statement
			ResultSet rs = stm.executeQuery(query);						//Executing a statement
			
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();				//For getting column size
			String[] colName = new String [cols];			//An array created for storing column name  
			
			for ( int i=0; i<cols; i++ ) {					//A loop for setting the name of columns in the array
				colName[i] = rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			
			
			String id, firstName, lastName, username, password, gender, age, salary, experiance;
			while (rs.next()) {								//Reads data from database and loads each row on the table
				id = rs.getString(1);
				firstName = rs.getString(2);
				lastName = rs.getString(3);
				username = rs.getString(4);
				password = rs.getString(5);
				gender = rs.getString(6);
				age = rs.getString(7);
				salary = rs.getString(8);
				experiance = rs.getString(9);
				
				String[] row = {id,firstName,lastName,username,password,gender,age,salary,experiance};
				model.addRow(row);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in listWaiter.\n" + ex);
		}
	}
	
	/*
	 * Update used by admin in the EmployeePage
	 */
	public boolean updateWaiter( String firstName, String lastName, String username, String password, String gender, int age, double salary, int experiance, String waiterId  ) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.experiance = experiance;
		this.waiterId = waiterId;
		
		try {
			
			String query = "UPDATE waiter SET firstName=?, lastName=?, username=?, password=?, gender=?, age=?, salary=?, experiance=? WHERE waiterId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating a statement
			pst.setString(1, this.firstName);							//Setting placeholder values			
			pst.setString(2, this.lastName);
			pst.setString(3, this.username);
			pst.setString(4, this.password);
			pst.setString(5, this.gender);
			pst.setInt(6, this.age);
			pst.setDouble(7, this.salary);
			pst.setInt(8, this.experiance);
			pst.setString(9, this.waiterId);
			
			pst.executeUpdate();										//Executing the statement
			
			return true;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in updateWaiter1!\n" + ex );
			return false;
		}
	}
	
	/*
	 * Update used by the waiter in the ProfilePage
	 */
	public boolean updateWaiter( String firstName, String lastName, String username, String password, String gender, int age, String waiterId ) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.waiterId = waiterId;
		
		try {
			
			String query = "UPDATE waiter SET firstName=?, lastName=?, username=?, password=?, gender=?, age=? WHERE waiterId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating a statement
			pst.setString(1, this.firstName);							//Setting placeholder values			
			pst.setString(2, this.lastName);
			pst.setString(3, this.username);
			pst.setString(4, this.password);
			pst.setString(5, this.gender);
			pst.setInt(6, this.age);
			pst.setString(7, this.waiterId);
			
			pst.executeUpdate();						//Executing the statement
			
			return true;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in updateWaiter2!\n" + ex );
			return false;
		}
	}
	
	public void deleteWaiter( String waiterId ) {
		
		this.waiterId = waiterId;
		
		try {
			
			String query = "DELETE FROM waiter WHERE waiterId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating a statement
			pst.setString(1, this.waiterId);							//Setting placeholder values
			
			pst.executeUpdate();										//Executing the statement
			
			JOptionPane.showMessageDialog( null, "Deleted Successfully!" );

		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in deleteWaiter!\n" + ex );
		}
	}
	
	public ResultSet searchWaiter(String waiterId) {
		
		this.waiterId = waiterId;
		
		try {
			
			String query = "SELECT * FROM waiter WHERE waiterId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating the statement
			pst.setString(1, this.waiterId);							//Setting placeholder values
			
			ResultSet rs = pst.executeQuery();							//Executing the statement
			
			if (rs.next())
				return rs;												//Returns the ResultSet
			else
				return null;
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in searchWaiter!\n" + ex);
			return null;
		}
	}
	
	/*
	 * Gets and returns the waiters Id by using the username
	 */
	public ResultSet getWaiterId (String username) {
		
		this.username = username;
		
		try {
			
			String query = "SELECT waiterId FROM waiter WHERE username=?";
			
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
			JOptionPane.showMessageDialog(null, "Something went wrong in getWaiterId!\n" + ex);
			return null;
		}
	}

	public static int getWaiterAt(int waiterCounter) {
		
		int waiterId = -1;
		
		try {
			
			String query = "SELECT TOP 1 waiterId FROM (SELECT TOP " + waiterCounter +" waiterId FROM waiter ORDER BY waiterId) AS sort ORDER BY waiterId DESC";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = s.executeQuery(query);
			rs.absolute(1);
			waiterId = rs.getInt(1);
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in getting waiter Id in that index!\n" + ex);
		}
		return waiterId;
	}
	
	public static int getWaiterCount() {
		
		int count = -1;
		
		try {
			
			String query = "SELECT COUNT(*) FROM waiter";
			
			Connection con  = DBConnectionClass.ProjectDBConnector();
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = s.executeQuery(query);
			rs.absolute(1);
			count = rs.getInt(1);
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in getting getWaiterCount!\n" + ex);
		}
		return count;
	}

	/**
	 * To get the first waiter id 
	 */
	static public int getFirstWaiterID() {

		int id;
		
		try {
			
			String query = "SELECT TOP 1 * FROM waiter ";
			
			Connection con = DBConnectionClass.ProjectDBConnector();		//Establishing the connection
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				//Creating the statement
			
			ResultSet rs = st.executeQuery(query);							//Executing the statement
			rs.absolute(1);
			id = rs.getInt(1);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in getFisrtWaiterID!\n" + ex);
			return -1;
		}
		return id;
	}

	static public int getLastWaiterID() {

		int id;
		
		try {
			
			String query = "SELECT TOP 1 * FROM waiter ORDER BY waiterId DESC";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				//Creating the statement
			
			ResultSet rs = st.executeQuery(query);						//Executing the statement
			rs.absolute(1);
			id = rs.getInt(1);
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in getLastWaiterID!\n" + ex);
			return -1;
		}
		return id;
	}
	
	
}
