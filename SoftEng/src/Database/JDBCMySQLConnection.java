package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCMySQLConnection { // NOPMD by Stam on 12/31/13 7:44 PM
	
	private static JDBCMySQLConnection instance = new JDBCMySQLConnection();
	public static final String URL = "jdbc:mysql://localhost/test";
    public static final String USER = "root";
    public static final String PASSWORD = "daggeras4ever";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    
    
    private JDBCMySQLConnection() {
        try {
            //Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
    	return instance.createConnection();
    }
    
    private Connection createConnection(){
    	Connection connection = null; // NOPMD by Stam on 12/31/13 7:52 PM
    	try{
    		//Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
    	}catch(SQLException e){
    		//System.out.println("ERROR: Unable to Connect to Database.");
    	}
    	return connection;
    
   
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    

}
