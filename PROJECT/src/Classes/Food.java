package Classes;

import java.sql.*;
import javax.swing.*;

public class Food {
	
	//Fields
	private int foodId;
	private String foodName;
	private double foodPrice;
	private String foodType;
	private double[] recipe;
	private Recipe recipeObject ;
	
	//Setter and Getter Methods
	public int getFoodId() {
		return foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public void setRecipe(double [] recipe) {
		this.recipe = recipe;
		this.recipeObject = new Recipe(this.recipe);
	}
	public double[] getRecipe () {
		return this.recipe;
	}
	
	//Constructor
	public Food(){
		
	}
	
	public Food( int foodId, String foodName, double foodPrice, String foodType){
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodType = foodType;
	}
	
	/**
	 * 
	 * @param foodName
	 * @param foodPrice
	 * @param foodType
	 * @param recipe
	 */
	
	public Food(String foodName,double foodPrice,String foodType,double [] recipe){
		
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodType = foodType;
		this.recipe = recipe; 
		recipeObject = new Recipe(this.recipe);
		
	}
	
	//Methods
	
	/**
	 * 
	 * Returns the food in the database 
	 *
	 * */
	public static Food[] getAllFoodRecords() {
		
		try {
			
			String query = "SELECT * FROM food;";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(query);
			
			if (rs.last()) {
				int lastRow = rs.getRow();
				Food allFoods[] = new Food[rs.getRow()] ;
				 
				for ( int i=0; i<lastRow; i++ ){
					rs.absolute(i+1);
					allFoods[i] = new Food(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
					allFoods[i].recipe = Food.Recipe.searchRecipe(allFoods[i].getFoodId());
				}
				
				return allFoods;
			}
			else {
				JOptionPane.showMessageDialog( null, "There are no records in the database!\n" );
				return null;
			 }
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog( null, "Exception on method getAllFoodRecords!\n" + ex );
		}
		return null;

	}
	
	/**
	 * 
	 * Adds new food to database 
	 * 
	 * */
	public void addFood() {
		
		try {
			
			String query = "INSERT INTO food VALUES ( ? , ?, ? )";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			PreparedStatement ps =  con.prepareCall(query);
			ps.setString(1, foodName);
			ps.setDouble(2, foodPrice);
			ps.setString(3, foodType);
			
			if (!ps.execute())
				recipeObject.addToDatabase();
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog( null, "Exception on method addFoodToDatabase\n" + ex );
		}
	}
	
	/**
	 * 
	 * Searches food from database
	 * 
	 * */
	public static Food searchFood(int id) {
		
		Food foundFood;
		
		try {
			
			String query = "SELECT * FROM food WHERE foodid = " + id + ";"; 
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs= s.executeQuery(query);
			rs.absolute(1);
			 
			foundFood = new Food(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
			foundFood.setRecipe(Food.Recipe.searchRecipe(id));
		}
		catch(Exception ex) {

			JOptionPane.showMessageDialog( null, "Exception on method searchFood!\n" + ex );
			foundFood = null;
		}
		
		return foundFood;
	}
	
	//For returning food id based on the name, price and type
	public static int searchFood(String name, double price, String foodType) {
		
		int foodID;
		
		try {
			
			String query = "SELECT foodId FROM food WHERE name='" + name + "' AND " + "price=" + price + "AND foodtype='" + foodType + "';";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(query);
			rs.absolute(1);
			
			foodID = rs.getInt(1);
					 
		}
		catch(Exception ex) {

			JOptionPane.showMessageDialog( null, "Exception on method searchFood2\n" + ex );
			foodID = -1;
		}
		return foodID;
	}
	
	/**
	 * 
	 * Deletes food from database 
	 * 
	 * */
	public static void deleteFood(String foodId) {
		
		deleteFoodRecipe(foodId);
		
		try {
			
			String query = "DELETE FROM food WHERE foodId = ?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, foodId); 	
			
			pst.executeUpdate();										//Execute the statement
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog( null, "Exception on method deleteFoodFromDatabase!\n" + ex );
		}
	}
	public static void deleteFoodRecipe(String foodId) {
		
		try {
			
			String query = "DELETE FROM recipe WHERE foodIdRef = ?";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, foodId); 	
			
			pst.executeUpdate();										//Execute the statement
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog( null, "Exception on method deleteFoodRecipeFromDatabase!\n" + ex );
		}
	}
	/**
	 * 
	 * Updates food in database 
	 * 
	 * */
	public void updateFood() {
		
	    try {
	      
	      String query = "UPDATE FOOD SET Name =? , Price =?, foodType = ?  WHERE foodID = ?";
	      
	      Connection con = DBConnectionClass.ProjectDBConnector();
	      PreparedStatement ps =  con.prepareCall(query);
	      ps.setString(1, this.foodName);
	      ps.setDouble(2, this.foodPrice);
	      ps.setString(3, this.foodType);
	      ps.setInt(4, this.foodId);
	       
	      recipeObject.updateRecipe();
	       
	      if (ps.execute()) {
	        JOptionPane.showMessageDialog( null, "Sucessfully Updated"  );
	      }
	       
	    }
	    catch(Exception ex) {
	      JOptionPane.showMessageDialog( null, "Exception on method updateFoodInDatabase\n" + ex );
	    }
	  }
	
	public static Food[] getAllFoods() {
		
		Food [] allFoods = null;
		double [] recipe;
		
		try {
			
			String query = "SELECT * FROM Food LEFT JOIN recipe \r\n"
					+ "ON FOOD.foodId = recipe.foodIdRef;";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			rs.last();
			allFoods = new Food[rs.getRow()];

			for (int i=0; i<allFoods.length; i++) {
				
				rs.absolute(i+1);
				recipe = new double[rsmd.getColumnCount()-5];
			
				for (int j = 6; j < rsmd.getColumnCount(); j++) {
					recipe[j-6] = rs.getDouble(j); 
				}
				allFoods[i] = new Food(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
				allFoods[i].setRecipe(recipe);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog( null, "Exception on method getAllFoods\n" +e );
		}
		
		return allFoods;
	}
	
	public static String[][] getAllFoodsAs2D() {
		
		String [][] allFoods = null;
		
		try {
			
			String query = "SELECT * FROM Food LEFT JOIN recipe \r\n"
					+ "ON FOOD.foodId = recipe.foodIdRef;";
					
			Connection con = DBConnectionClass.ProjectDBConnector();		
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			rs.last();
			allFoods = new String[rs.getRow()][];
			
			for (int i = 0; i < allFoods.length; i++) {
				
				rs.absolute(i+1);
				allFoods[i] = new String[rsmd.getColumnCount()];
			
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					allFoods[i][j] = rs.getString(j+1);
				}
			}
			
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog( null, "Exception on method getAllFoodsAs2D\n" +e );
		}
		
		return allFoods;
		
	}
	
	public static String[] getColumnNames() {
		
		String [] columnNames = null;
		Connection con;
		Statement st;
		
		try {
			String query = "SELECT * FROM Food LEFT JOIN recipe ON FOOD.foodId = recipe.foodIdRef;";
			
			con = DBConnectionClass.ProjectDBConnector();
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			columnNames = new String[rsmd.getColumnCount()];

			for (int i = 0; i < columnNames.length; i++) {
				
				columnNames[i] = rsmd.getColumnName(i+1);
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog( null, "Exception on method getColumnNames\n" +e );
		}
		
		return columnNames;
		
	}
	
	public static int searchFoodID(String FoodName) {
		
		int searchResult = -1;
		
		try {
			
			String query = "SELECT foodId FROM Food WHERE name ='" + FoodName + "'";
			
			Connection con = DBConnectionClass.ProjectDBConnector();
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = s.executeQuery(query);
			
			rs.absolute(1);
			searchResult = rs.getInt(1);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog( null, "Exception on method searchFoodID\n" +ex );
		}
		return searchResult;
	}
	
	public ResultSet SearchFood(int foodId) {
		
		this.foodId = foodId;
		
		try {
			
			String query = "SELECT * FROM food WHERE foodId = " + foodId;
			
			Connection con = DBConnectionClass.ProjectDBConnector();	//Establishing the connection
			Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next())
				return rs;												//Returns the ResultSet
			else
				return null;
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Failed to search food!\n" + ex);
			return null;
		}
		
	}
	

	public class Recipe {
		
		double []recipe;
		
		Recipe(double []recipe){
			this.recipe = recipe;
		}
		
		public void setRecipe(double [] recipe) {
			this.recipe = recipe;
		}
		
		public void addToDatabase() {
			
			String query = "INSERT INTO recipe VALUES( " + searchFood(foodName,foodPrice,foodType) + ",";
			
			for (int i=0; i<this.recipe.length; i++  ) {
			
				if (i+1 < this.recipe.length) {	
				
					query += " " + this.recipe[i] + "," ;
					
				}
			
				else if (i+1 == this.recipe.length) {
				
					query += " " + this.recipe[i] + ")" ;
			
				}
			}
			
			try {
				
				Connection con = DBConnectionClass.ProjectDBConnector();
				Statement st = con.createStatement();
				if(st.execute(query)) 
					JOptionPane.showMessageDialog( null, "Successfully added!"  );
					
			} 
			catch (SQLException ex) {
				JOptionPane.showMessageDialog( null, "Exception on method addToDatabase!\n" + ex );
			}
		}
	
		public static double[] searchRecipe(int foodId) {
			
			double [] result = null;
			
			try {
				
				String query = "SELECT * FROM recipe WHERE foodIDRef = " + foodId;
			
				Connection con = DBConnectionClass.ProjectDBConnector();
				Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
			
					result = new double[rsmd.getColumnCount()-1];
					rs.absolute(1);
					for (int i=0; i<result.length; i++) {
						result[i] = rs.getDouble(i+2);
					}
				
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog( null, "Exception on method searchRecipe\n" + ex );
			}
			return result;
		}
		
		public void updateRecipe() {

			String query = "UPDATE recipe SET  ";
			Ingredient ing[] =  Ingredient.getAllIngredientsInDatabase();
			
			for (int i=0; i<this.recipe.length; i++  ) {
			
				if (i+1 < this.recipe.length) {	
				
					query +=ing[i].getItemName() + " = " + this.recipe[i] + "," ;
			
				}
			
				else if (i+1 == this.recipe.length) {
				
					query +=ing[i].getItemName() +  " = " + this.recipe[i] + " " ;
			
				}
			}
			query += "WHERE foodIdRef = " + searchFood(foodName,foodPrice,foodType);
			try {
				
				Connection con = DBConnectionClass.ProjectDBConnector();
				Statement s = con.createStatement();
				
				if(s.execute(query)) 
					JOptionPane.showMessageDialog( null, "Successfully updated!"  );
					
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog( null, "Exception on method UpdateRecipe\n" + ex );
			}
		}
		

		public static boolean deductRecipeFromInventory( int foodID, int amount ) {
			double [] recipe = searchRecipe(foodID);
			Ingredient [] ingredient = Ingredient.getAllIngredientsInDatabase();
			for (int i = 0; i < recipe.length; i++) {
				
				if (Double.parseDouble(ingredient[i].getQuantity()) - (amount * recipe[i]) <= 0.0) {
					return false;
				}
				double quantity = Double.parseDouble(ingredient[i].getQuantity()) - (amount * recipe[i]);
				ingredient[i].setQuantity(quantity + "");
				
			}
			for (int i = 0; i < ingredient.length; i++) {
				ingredient[i].updateIngredient(ingredient[i].getItemName(),ingredient[i].getQuantity(), ingredient[i].getPrice(), ingredient[i].getItemId());
			}
			return true;
		}

		
	}
	
	

	
}
