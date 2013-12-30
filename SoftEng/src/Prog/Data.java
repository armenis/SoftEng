package Prog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Database.JDBCMySQLConnection;

public class Data {
	
/*	String[] getTime(){
		String	time[] =
			{	
				"03:00","08:00","09:00","10:00","15:50","20:00","22:00","23:00"	
			};
		return time;
	}
	
	Double[] getPrice(){
		Double	prices[] =
			{
				20.50,25.00,30.00,40.50
			};
		return prices;
	}*/
	
	public double calculateChange(String gp,double price){
		double change = 0.00;
	    double payment = Double.parseDouble(gp);
		change = payment - price;
		return change;
	}
	
	//Pernoume apo thn Vash tis Perioxes
	static final Vector getRoutes(){
		ResultSet rs = null;
	     Connection connection = null;
	     Statement statement = null; 
	     
	     String query = "SELECT * FROM perioxes ORDER BY пеяиовг";
	     Vector routes = new Vector();

	     
	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            statement = connection.createStatement(); 
	            rs = statement.executeQuery(query);

	            while(rs.next()) {
	            	
	                routes.addElement(rs.getString("пеяиовг"));

	            }
	            
	            statement.close();
	            connection.close();
	            
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
	     
	    //System.out.println("Initial size: " + routes.size());
	    //System.out.println(routes);
	    return routes;
		
	}
	//Pernoume apo thn Vash tis Times
	static final Double getPrice(String perioxh){
		 ResultSet rs = null;
	     Connection connection = null;
 	     Double price = null;
 	     PreparedStatement ps =null;

	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT тилг FROM test.times JOIN test.perioxes ON perioxes.pid=times.pid WHERE perioxes.пеяиовг= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();

	            while(rs.next()) {
	            	
	                price = rs.getDouble("тилг");

	            }
	            
	            //statement.close();
	            //connection.close();
	            
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
	     
	    //System.out.println("Initial size: " + routes.size());
	    //System.out.println(price);
	    
	    return price;
	}

	static final Vector getDays(String perioxh){
		
		 Vector days = new Vector();
		 int pid=0;
		 ResultSet rs = null;
		 ResultSet rs2 = null;
	     Connection connection = null;
	     PreparedStatement ps =null;
	     PreparedStatement ps2 =null;

	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT pid from test.perioxes WHERE пеяиовг= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();
	            
	            
	           

	            while(rs.next()) {
	            	
	            	
	                pid = rs.getInt("pid");
	                
	            }
	            
	            
	            
	            ps2 = connection.prepareStatement("SELECT глеяес FROM test.meres JOIN test.routes ON meres.mid=routes.mid WHERE pid= ?");
	            ps2.setInt(1,pid );
	            rs2 = ps2.executeQuery();
	            
	            while(rs2.next()) {
	            	
	            	days.addElement(rs2.getString("глеяес"));
	            	
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
	     
	    //System.out.println("Initial size: " + routes.size());
	    //System.out.println(pid);
	    //System.out.println(days);
		
		
		
		
		
		return days;
	}
	
	static final Vector getTimes(String perioxh){
		 Vector times = new Vector();
		 int pid=0;
		 ResultSet rs = null;
		 ResultSet rs2 = null;
	     Connection connection = null;
	     PreparedStatement ps =null;
	     PreparedStatement ps2 =null;

	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT pid from test.perioxes WHERE пеяиовг= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();
	            
	            
	           

	            while(rs.next()) {
	            	
	            	
	                pid = rs.getInt("pid");
	                
	            }
	            
	            
	            
	            ps2 = connection.prepareStatement("SELECT ыяес FROM test.wres JOIN test.combo ON wres.wid=combo.wid WHERE pid= ?");
	            ps2.setInt(1,pid );
	            rs2 = ps2.executeQuery();
	            
	            while(rs2.next()) {
	            	
	            	times.addElement(rs2.getString("ыяес"));
	            	
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
	     
	    //System.out.println("Initial size: " + routes.size());
	    //System.out.println(pid);
	    //System.out.println(days);
		
		
		
		
		
		return times;
	}
}
