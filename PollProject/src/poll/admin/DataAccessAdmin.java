package poll.admin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.*;


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
	

	
	//prepared statement example
	
	
public static String validateLogin(int userid, String password) {
		
		String ret = null;
		try{
				Connection cn =getConnection();
				System.out.println(userid + " " + password);
				PreparedStatement st = cn.prepareStatement("SELECT userid, password, type from Login WHERE UserID = ? AND Password = ?");
				st.setInt(1, userid);
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
	
public static Users createUser(String type) {
		Users newUser = new Users();
		
		try{
				Connection cn =getConnection();
				
				PreparedStatement st = cn.prepareStatement("INSERT INTO login values (null,?,?)");
				String password = GeneratePassword.getPassword();
				st.setString(1, password);
				st.setString(2, type);
				
				st.executeUpdate();
				PreparedStatement st1 = cn.prepareStatement("Select * from login where password=?");
				st1.setString(1, password);
				ResultSet rs = st1.executeQuery();
				while(rs.next()){
				newUser.setUid(rs.getInt(1));
				newUser.setPwd(rs.getString(2));
				newUser.setUtype(rs.getString(3));
				}
		}
				
		catch(SQLException e) {
			System.out.println("Error creating user"+e);
			newUser=null;
		}
		return newUser;
		
	}

public static ArrayList<Users> getAllUsers() {
	
	ArrayList<Users> UserList = new ArrayList<Users>();
	try {
		Connection cn = getConnection();
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM login");
		while(rs.next()) {
			Users u = new Users();
			u.setUid(rs.getInt(1));
			u.setPwd(rs.getString(2));
			u.setUtype(rs.getString(3));
			UserList.add(u);
			
		}		
	} catch(SQLException e) {
		System.out.println("Ërror getting data");
	}
	return UserList;
}

public static ActiveQuestion activeQuestion() {
	
	HashMap<Character, String> opMap = new HashMap<>();
	ActiveQuestion temp = new ActiveQuestion();
	try{
			Connection cn =getConnection();
			
			PreparedStatement st = cn.prepareStatement("Select * from activequestion");
								
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			while(rs.next()){
			temp.setPollId(rs.getInt(1));
			temp.setQno(rs.getInt(2));
			temp.setQuestion(rs.getString(3));
			char c= 'A';
			for (int i=4 ; i<=columnsNumber;i++){
				opMap.put(c, rs.getString(i));
				c++;
				}
			temp.setHmapOptions(opMap);
			}
			
	}
			
	catch(SQLException e) {
		System.out.println("Error creating user"+e);
		temp=null;
	}
	return temp;
	
}


}	
 class GeneratePassword {
    /** Minimum length for a decent password */
    public static final int MIN_LENGTH = 10;

    /** The random number generator. */
    protected static java.util.Random r = new java.util.Random();
    protected static char[] goodChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
        'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
        'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','0','1',
        '2', '3', '4', '5', '6', '7', '8', '9', }; 
    /* Generate a Password object with a random password. */
    public static String getPassword() {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < MIN_LENGTH; i++) {
        sb.append(goodChar[r.nextInt(goodChar.length)]);
      }
      return sb.toString();
    }
 }
