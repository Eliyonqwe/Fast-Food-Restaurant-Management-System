package Classes;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Orders{
	
	private int orderId;
	private String customerId;
	private int waiterId;
	private double total;	
	private String dateOrdered ;

	/**
	 * 
	 * @param orderId
	 * @param customerId
	 * @param foodId
	 * @param waiterId
	 * @param dateOrdered
	 */
	
	public Orders() {
		
	}
	
	public Orders( int orderId, String customerId, int waiterId, double total, String dateOrdered) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.total = total;
		this.waiterId = waiterId;
		this.dateOrdered = dateOrdered;
	}
	
	public Orders(String customerId,int waiterId,double total) {
		this.customerId = customerId;
		this.total = total;
		this.waiterId = waiterId;
	}
	
	

	public String getDateOrdered() {
		return dateOrdered ;
	}
	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;  
	}
	public void setwaiterId(int waiterId) {
	
		this.waiterId = waiterId;
	}
     
	public int getWaiterId() {
		
		return waiterId;
	}
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public double getTotal() {
		return total;
	}
					
	public void settotal(double total) {
		this.total = total;
	}

	
	
	public void addOrder() {
		
		try {
			
			String query = "INSERT INTO orders VALUES ( " + this.customerId + ","+ this.waiterId + "," + this.total + ", GETDATE() )";

			Connection con = DBConnectionClass.ProjectDBConnector();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		      
		    if (st.execute(query))                                                                             
		        JOptionPane.showMessageDialog(null, "Succesfully added" );
		    
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong in addOrder! \n " + e );
		}
		
	}

//	public static Orders SearchOrder(int OrderId) {
//		
//		Orders searchResult = null;
//		
//		try {
//			
//			String query = "SELECT * FROM orders where orderid =" + OrderId;
//			
//			Connection con = DBConnectionClass.ProjectDBConnector();
//			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			ResultSet rs = st.executeQuery(query);
//			
//			rs.absolute(1);
//			
//			searchResult = new Orders ( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5) );
//			 
//			return searchResult;
//		
//		}
//		catch (SQLException e) {
//		
//			JOptionPane.showMessageDialog(null, "Something went wrong in SearchDatabase! \n " + e );
//		
//		}
//		return searchResult;
//	}
	
	public void listOrders(JTable table) {
		
		try {
			
			String query = "SELECT * FROM ordersView;";
			
			table.setModel( new DefaultTableModel() );						//For clearing the previous table 
			
			Connection con = DBConnectionClass.ProjectDBConnector();		//Establishing the connection
			Statement stm = con.createStatement();							//Creating a statement
			ResultSet rs = stm.executeQuery(query);							//Executing a statement
			
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();				//For getting column size
			String[] colName = new String [cols];			//An array created for storing column name  
			
			for ( int i=0; i<cols; i++ ) {					//A loop for setting the name of columns in the array
				colName[i] = rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			
			
			String Oid, total, date, Wid, Wfn, Wln, Cid, Cfn, Cln;
			while (rs.next()) {								//Reads data from database and loads each row on the table
				Oid = rs.getString(1);
				total = rs.getString(2);
				date = rs.getString(3);
				Wid = rs.getString(4);
				Wfn = rs.getString(5);
				Wln = rs.getString(6);
				Cid = rs.getString(7);
				Cfn = rs.getString(8);
				Cln = rs.getString(9);
				
				String[] row = {Oid, total, date, Wid, Wfn, Wln, Cid, Cfn, Cln};
				model.addRow(row);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in listOrders.\n" + ex);
		}
	}
	
	public void listWaitersOrder(JTable table, String waiterId) {
		
		try {
			
			String query = "SELECT * FROM ordersView WHERE waiterID = " + waiterId + ";";
			
			table.setModel( new DefaultTableModel() );						//For clearing the previous table 
			
			Connection con = DBConnectionClass.ProjectDBConnector();		//Establishing the connection
			Statement stm = con.createStatement();							//Creating a statement
			ResultSet rs = stm.executeQuery(query);							//Executing a statement
			
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();				//For getting column size
			String[] colName = new String [cols];			//An array created for storing column name  
			
			for ( int i=0; i<cols; i++ ) {					//A loop for setting the name of columns in the array
				colName[i] = rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			
			
			String Oid, total, date, Wid, Wfn, Wln, Cid, Cfn, Cln;
			while (rs.next()) {								//Reads data from database and loads each row on the table
				Oid = rs.getString(1);
				total = rs.getString(2);
				date = rs.getString(3);
				Wid = rs.getString(4);
				Wfn = rs.getString(5);
				Wln = rs.getString(6);
				Cid = rs.getString(7);
				Cfn = rs.getString(8);
				Cln = rs.getString(9);
				
				String[] row = {Oid, total, date, Wid, Wfn, Wln, Cid, Cfn, Cln};
				model.addRow(row);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in listWaitersOrder.\n" + ex);
		}
	}
	
}