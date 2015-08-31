package poll.admin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataAccessAdmin {
	/*public static String testConnection() {
		String ret =" ";
		Connection cn = null;
		try
		{     
			//Dynamically load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			ret += "Driver Loaded";
			cn = DriverManager.getConnection(
					"jdbc:mysql://localhost/coursedb","root","PASSWORD123");
			ret += "\nConnected to database";
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error loading jdbc driver"+e);
		}
		catch (SQLException e) {
			System.out.println("Connection Error: " + e);
		}
		
		return ret;
		
	} */
	
	public static Connection getConnection() {
		String ret =" ";
		Connection cn = null;
		try
		{     
			//Dynamically load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			ret += "Driver Loaded";
			cn = DriverManager.getConnection(
					"jdbc:mysql://localhost/Poll","root","PASSWORD123");
			ret += "\nConnected to database";
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error loading jdbc driver"+e);
		}
		catch (SQLException e) {
			System.out.println("Connection Error: " + e);
		}
		
		return cn;
		
	}
	
	public static String getProducts(String categoryName) {
		String ret = "";
		try {
			Connection cn = getConnection();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Product WHERE category = '"+categoryName
					+"'");
			while(rs.next()) {
				ret += rs.getString(2) + " , " + rs.getString(3) 
						+ " , " + rs.getDouble(4) + "\n";
			}		
		} catch(SQLException e) {
			System.out.println("Ërror getting data");
		}
		return ret;
	}
	
	//prepared statement example
	public static int addProduct(String product,String category, double price, int stock) {
		int ret = 0;
		try {
			Connection cn = getConnection();
			PreparedStatement st = cn.prepareStatement("INSERT into PRODUCT VALUES(NULL,?,?,?,?)");
			st.setString(1, product);
			st.setString(2, category);
			st.setDouble(3, price);
			st.setInt(4, stock);
			ret = st.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Ërror adding data" + e);
		}
		return ret;
	}
	public static int editProduct(int id,String name) {
		int ret = 0;
		try {
			Connection cn =getConnection();
			PreparedStatement st = cn.prepareStatement("UPDATE product SET name = ? WHERE id = ?");
			st.setString(1,name);
			st.setInt(2,id);
			ret = st.executeUpdate();
		} catch(SQLException e) {
			System.out.println("error updating data"+e);
		}
		return ret;
	}
	
	public static String validateLogin(String userid, String password) {
		
		String ret = null;
		try{
				Connection cn =getConnection();
				System.out.println(userid + " " + password);
				PreparedStatement st = cn.prepareStatement("SELECT userid, password, type from Login WHERE UserID = ? AND Password = ?");
				st.setString(1, userid);
				st.setString(2, password);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
					ret = rs.getString(3);
					
				}
			}
		catch(SQLException e) {
			System.out.println("Error validating data"+e);
		}
		return ret;
	}
}
