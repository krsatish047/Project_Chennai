package poll.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

//import com.mysql.jdbc.Connection;


public class DataAccessNew {
	public static String testConnection() {
		String ret="";
		Connection cn=null;
		try {
			//Dynamically load the Driver class
			Class.forName("com.mysql.jdbc.Driver");		
			ret += "Driver Loaded";
			cn = DriverManager.getConnection("jdbc:mysql://localhost/poll","root","PASSWORD123");
			ret +="\n Connected to courseDB database";
		}
		catch(SQLException e) {
			System.out.println("Connection Error"+ e);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error loading JDBC Driver"+ e);	
		}
		return ret;
	}
	public static Connection getConnection() {
		Connection cn=null;
		try {
			//Dynamically load the Driver class
			Class.forName("com.mysql.jdbc.Driver");		
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost/poll","root","PASSWORD123");
		}
		catch(SQLException e) {
			System.out.println("Connection Error"+ e);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error loading JDBC Driver"+ e);	
		}
		return  cn;
	}
	public static String getProducts(String condition) { 
		String ret = "";
		try {
			Connection cn = getConnection();
			java.sql.Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select * from product where " + condition);
			while(rs.next()) {
				ret += rs.getString(1) +"\n"+","+ rs.getString(2) +"\n"; 
				
			}
			
		}
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return ret;
	}
	
	public static void addProducts(String product, String category, double price, int stock)  { 
		String ret = "";
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("insert into product values(NULL,?,?,?,?)");
			st.setString(1,product);
			st.setString(2,category);
			st.setDouble(3,price);
			st.setInt(4,stock);
			st.executeUpdate();
			
				
			}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
			}
	public static int editProducts(int id,String product)  { 
		int ret=0;
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("update product set name = ?"
					+ ""
					+ " where id=?");
			st.setString(1,product);
			
			st.setInt(2,id);
		
			ret= st.executeUpdate();
			
				
			}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return ret;
			}
	public static String demoSP(int low, int high) {
		String ret="";
		try {
			Connection cn = getConnection();
			java.sql.CallableStatement st = cn.prepareCall("call procname(?,?);");
			st.setDouble(1,low);
			
			st.setDouble(2,high);
		
			ResultSet rs= st.executeQuery();
			while(rs.next()) {
				ret += rs.getString(1) +"\n"+","+ rs.getString(2) +"\n";
				
			}
		}
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return ret;
	}
	public static void restinfo(Connection cn,String string1, String string2, String string3,
			String string4, String string5, String string6, String string7,
			String string8) {
		// TODO Auto-generated method stub
		//String ret = "";
		try {
			
			java.sql.PreparedStatement st = cn.prepareStatement("insert into resinfo values(?,?,?,?,?,?,?,?)");
			st.setString(1,string1);
			st.setString(2,string2);
			st.setString(3,string3);
			st.setString(4,string4);
			st.setString(5,string5);
			st.setString(6,string6);
			st.setString(7,string7);
			st.setString(8,string8);
			st.executeUpdate();
			
				
			}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		
		
	}
	public static void inspection(Connection cn,String string, String string2,
			String string3, String string4, String string5, String string6,
			String string7, String string8) {
		// TODO Auto-generated method stub
		try {
			//Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("insert into inspection values(?,?,?,?,?,?,?,?)");
			st.setString(1,string);
			st.setString(2,string2);
			st.setString(3,string3);
			st.setString(4,string4);
			st.setString(5,string5);
			st.setString(6,string6);
			st.setString(7,string7);
			st.setString(8,string8);
			st.executeUpdate();
			
				
			}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		
	}
	public static void violation(Connection cn, String string, String string2, String string3) {
		// TODO Auto-generated method stub
		try {
			//Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("insert into violation values(?,?,?)");
			st.setString(1,string);
			st.setString(2,string2);
			st.setString(3,string3);
	
			st.executeUpdate();
			
				
			}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		
	}
	public static int getNoOfPolls() {
		// TODO Auto-generated method stub
		int ret = 0;
		try {
			Connection cn = getConnection();
			java.sql.Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select count(pollid) from polling;");
			while(rs.next()) {
			ret = Integer.parseInt(rs.getString(1));
			}
		}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return ret;
	}
	public static void createTable(String string , String string2) {
		// TODO Auto-generated method stub
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("create table " + string + "( qno int primary key auto_increment , question varchar(200));");
			//st.setString(1,string);
			st.executeUpdate();
			
		
			st = cn.prepareStatement("create table " + string2 +   "( qno int , options varchar(200) , count int );");
			//st.setString(1,string2);
			st.executeUpdate();
		
		}
			
		catch(SQLException e) {
			System.out.println("Ërror creating tables" + e);
			
		}
		
	}
	public static void addPollingEntry(int newPollId) {
		// TODO Auto-generated method stub
	
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("insert into polling(pollid) values(?);");
			st.setLong(1,newPollId);
			st.executeUpdate();
			
				
		}
			
		catch(SQLException e) {
			System.out.println("Ërror adding data" + e);
			
		}
	}
	public static int addQuestion(String question, int pollid) {
		// TODO Auto-generated method stub
		String tableName="";
		int ret = 0;
		tableName += "poll" + pollid+ "Questions";
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("insert into " + tableName + "(question) values('" + question +  "');");
			
			st.executeUpdate();
			st = cn.prepareStatement("select qno from " + tableName + " where question = '" + question + "';");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
			ret = rs.getInt(1);
			}
				
		}
			
		catch(SQLException e) {
			System.out.println("Ërror adding data" + e);
			
		}
		return ret;
	}
	public static void addOption(String option, int quesNo, int newPollId) {
		// TODO Auto-generated method stub
		String tableName="";
		int ret = 0;
		tableName += "poll" + newPollId+ "Options";
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("insert into " + tableName+ " values(" + quesNo + ",'" + option +"',0);");
			
			st.executeUpdate();
			
				
		}
			
		catch(SQLException e) {
			System.out.println("Ërror adding data" + e);
			
		}
	
	}
	public static List<String> getPollMasters() {
		// TODO Auto-generated method stub
		List<String> masters = new ArrayList<>();
		try {
			Connection cn = getConnection();
			java.sql.Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select userId from login where type='pollmaster';");
			while(rs.next()) {
				masters.add(rs.getString(1));
			}
		}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return masters;
	}
	public static List<Integer> getPollIds() {
		// TODO Auto-generated method stub
		List<Integer> masters = new ArrayList<>();
		try {
			Connection cn = getConnection();
			java.sql.Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select pollid from polling;");
			while(rs.next()) {
				masters.add(rs.getInt(1));
			}
		}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return masters;
	}
	public static void updatePollMaster(int pollId, int pollMaster) {
		// TODO Auto-generated method stub
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("insert into polling(pollmaster) values(" + pollMaster + ") where pollid = "+ pollId +";");
			
			st.executeUpdate();
			
				
		}
			
		catch(SQLException e) {
			System.out.println("Ërror adding data" + e);
			
		}
		
	}
	public static void activatePoll(int pollMaster, int pollId) {
		// TODO Auto-generated method stub
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("insert into active values(" + pollMaster + "," + pollId + ");");
			
			st.executeUpdate();
			
				
		}
			
		catch(SQLException e) {
			System.out.println("Ërror adding data" + e);
			
		}
	}
	public static boolean isPollMasterActive(int userId) {
		// TODO Auto-generated method stub
		try {
			Connection cn = getConnection();
			java.sql.Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select userid from active;");
			while(rs.next()) {
				if(userId == rs.getInt(1)) {
					System.out.println("user id " + userId);
					System.out.println("from database "+ rs.getInt(1));
					return true;
				}
			}
			
		}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return false;
	}
	public static List<Questions> getQuestions() {
		// TODO Auto-generated method stub
		List<Questions> q=new ArrayList<Questions>();
		String tableName="";
		String tableName2="";
		try {
			Connection cn = getConnection();
			java.sql.Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select pollid from active;");
			System.out.println("got pollid");
			while(rs.next()) {
				tableName+= "poll" + rs.getInt(1) + "questions";
				tableName2 = "poll" + rs.getInt(1) + "options";
			}
			 ResultSet rq = st.executeQuery("Select question ,qno from " + tableName + ";");
			 System.out.println("got qno,q");
		
			
			while(rq.next()) {
				Questions qu = new Questions();
				qu.question = rq.getString(1);
				qu.qno = rq.getInt(2);
				System.out.println(qu.question + qu.qno);
				
				//qu.options = op;
				q.add(qu);
				System.out.println("q values " + qu.question + qu.qno);
			}
			for(Questions ques: q) {
				ResultSet rp = st.executeQuery("select options from " + tableName2 + " where qno =" + ques.qno + ";");
				System.out.println("got options");
				List<String> op = new ArrayList<String>();
				while(rp.next()) {
					System.out.println(rp.getString(1));
					op.add(rp.getString(1));
				}
				ques.options = op;
				System.out.println("out");
				}
			
			
		}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return q;
	}
	public static int getActivePollId() {
		// TODO Auto-generated method stub
		int id=0;
		try {
			Connection cn = getConnection();
			java.sql.Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select pollid from active;");
			while(rs.next()) {
				id = rs.getInt(1);
			}
			
		}
			
		catch(SQLException e) {
			System.out.println("Ërror getting data" + e);
			
		}
		return id;
	}
	public static void updateActiveQuestion(int pollId, int qno) {
		// TODO Auto-generated method stub
		try {
			Connection cn = getConnection();
			java.sql.PreparedStatement st = cn.prepareStatement("update activequestion set pollid = " + pollId + ",qno= " + qno + " where active=1;");
			
			st.executeUpdate();
			
				
		}
			
		catch(SQLException e) {
			System.out.println("Ërror adding data" + e);
			
		}
	}
}
	
	

