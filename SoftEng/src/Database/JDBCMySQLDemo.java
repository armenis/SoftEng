package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMySQLDemo {

	public static void main(String[] args) {
		 ResultSet rs = null;
	     Connection connection = null;
	     Statement statement = null; 
	     
	     String query = "SELECT * FROM perioxes";
	     
	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            statement = connection.createStatement();
	            
	            rs = statement.executeQuery(query);
	 
	            while(rs.next()) {
	                int aa = rs.getInt("id"); 
	                String ONOMA = rs.getString("пеяиовг");             
	                System.out.println("id: "+ aa +
	                				   " пеяиовг: "+ ONOMA);     
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	       
	    }
	
	


}


