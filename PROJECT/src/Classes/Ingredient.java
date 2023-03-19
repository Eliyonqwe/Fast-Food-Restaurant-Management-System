package Classes;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ingredient {
	
	//Fields
	private String itemId;
	private String itemName;
	private String quantity;
	private double price;
	
	//Constructor
	public Ingredient(){
		
	}
	
	public Ingredient (String itemId,String itemName,String quantity,double price){
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		
	}
	
	//Setter and Getter Methods
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//Methods
	public ResultSet searchIngredient(String itemId) {
		
		this.itemId = itemId;
		
		try {
			
			String query = "SELECT * FROM ingredients WHERE itemId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating the statement
			pst.setString(1, this.itemId);								//Setting placeholder values
			
			ResultSet rs = pst.executeQuery();							//Executing the statement
			
			if (rs.next())
				return rs;												//Returns the ResultSet
			else
				return null;
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Failed to search Ingredient!\n" + ex);
			return null;
		}
		
	}

	public boolean addIngredient ( String itemName, String quantity, double price ) {
		
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		
		try {
			
			String query = "INSERT INTO ingredients VALUES ( ?, ?, ? );";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating a statement
			pst.setString(1, this.itemName); 							//Setting placeholder values
			pst.setString(2,this.quantity);
			pst.setDouble(3,this.price);
			
			pst.executeUpdate();										//Execute the statement
			
			addIngredientToRecipeTable(this.itemName);					//Adds the ingredient to the recipe
			
			return true;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in addIngredient!\n" + ex );
			return false;
		}
	}
	
	public void listIngredients(JTable table) {
		
		try {
			
			String query = "SELECT * FROM ingredients";
			
			table.setModel( new DefaultTableModel() );				//For clearing the previous table 
			
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
			
			
			String id, itemName, quantity, price;
			while (rs.next()) {								//Reads data from database and loads each row on the table
				id = rs.getString(1);
				itemName = rs.getString(2);
				quantity = rs.getString(3);
				price = rs.getString(4);
				
				String[] row = {id,itemName,quantity,price};
				model.addRow(row);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong in listIngredients.\n" + ex);
		}
	}
	
	public boolean updateIngredient( String itemName, String quantity, double price, String itemId ) {
		
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		
		try {
			
			String query = "UPDATE ingredients SET itemName=?, quantity=?, price=? WHERE itemId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating a statement
			pst.setString(1, this.itemName);							//Setting placeholder values			
			pst.setString(2, this.quantity);
			pst.setDouble(3, this.price);
			pst.setString(4, this.itemId);
			
			pst.executeUpdate();										//Executing the statement
			
			return true;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in updateIngredients!\n" + ex );
			return false;
		}
	}
	
	public void deleteIngredient( String itemId ) {
		
		ResultSet rs = getIngredientName(itemId);						//a method that get and returns the name of the recipe by using the id
		try {
			this.itemName = rs.getString("itemName");					//Stores the id in the "itemName" variable
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in deleteIngredient when trying to get itemName!\n" + ex );
		}
		
		deleteIngredientFromRecipeTable(this.itemName);					//Deletes the ingredient from the recipe table
		
		this.itemId = itemId;
		
		try {
			
			String query = "DELETE FROM ingredients WHERE itemId=?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			PreparedStatement pst = con.prepareStatement(query);		//Creating a statement
			pst.setString(1, this.itemId);								//Setting placeholder values
			
			pst.executeUpdate();										//Executing the statement
			
			
			JOptionPane.showMessageDialog( null, "Deleted Successfully!" );

		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in deleteIngredient!\n" + ex );
		}
	}
	
	public static Ingredient[] getAllIngredientsInDatabase() {
		
		Ingredient[] ingredients = null;
		
		try {
			
			String query = "SELECT * FROM Ingredients";
			
			Connection con = DBConnectionClass.ProjectDBConnector();				//Establishing a connection
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		//Creating a statement
			
			ResultSet rs = s.executeQuery(query);									//Executing the statement
			rs.last();
			ingredients = new Ingredient[rs.getRow()];
		
			for (int i = 0; i < ingredients.length; i++ ) {
				rs.absolute(i+1);
				ingredients[i] = new Ingredient(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Something went wrong in gelAllIngredientsInDatabase!\n" + ex );
		}
		
		return ingredients;
		
	}
	
	public ResultSet getIngredientName (String itemId) {
		
		this.itemId = itemId;
		
		try {
			
			String query = "SELECT itemName FROM ingredients WHERE itemId = " + itemId;
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = st.executeQuery(query);
			
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

	public void addIngredientToRecipeTable(String ingredientName) {
		
		try {
			
			String query = "ALTER TABLE recipe ADD " + ingredientName + " float";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
	        Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	        ps.execute(query);
	        
	     }
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Exception on method addIngredientToRecipe\n" + ex );
		}
	}
	
	public void deleteIngredientFromRecipeTable(String ingredientName) {
		
		try {
			
			String query = "ALTER TABLE recipe DROP COLUMN " + ingredientName;
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ps.execute(query);
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Exception on method deleteIngredientFromRecipe\n" + ex );
		}
	}
	
}

