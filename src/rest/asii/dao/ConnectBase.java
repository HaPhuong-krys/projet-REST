package rest.asii.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBase {
	
	    public static Connection getConnection(String dbURL, String userName, String password) {
	        Connection conn = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(dbURL, userName, password);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn;
	    }

		public static void main(String args[]) {
			String url = "jdbc:mysql://localhost/articles";
			 String user = "root";
			 String pass = "krystal141198";
	        try {
	           
	            Connection conn = getConnection(url, user, pass);
	          
	            Statement stmt = conn.createStatement();
	          
	            ResultSet rs = stmt.executeQuery("select * from articles");
	      
	            while (rs.next()) {
	                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
	                        + "  " + rs.getString(3));
	            }
	            
	            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	 

	}