package program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import database.JDBCMySQLConnection;

public class Data { // NOPMD by Stam on 12/31/13 7:49 PM
	
	
	public double calculateChange(String gp,double price){
		double change = 0.00;
	    double payment = Double.parseDouble(gp);
		change = payment - price;
		return change;
	}
	
	//Pernoume apo thn Vash tis Perioxes
	static final Vector getRoutes(){
		 ResultSet rs;
	     Connection connection = null;
	     Statement statement; 
	     
	     String query = "SELECT * FROM perioxes ORDER BY �������";
	     Vector routes = new Vector();

	     
	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            statement = connection.createStatement(); 
	            rs = statement.executeQuery(query);

	            while(rs.next()) {
	            	
	                routes.addElement(rs.getString("�������"));

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
	     
	   
	    return routes;
		
	}
	//Pernoume apo thn Vash tis Times
	public static final Double getPrice(String perioxh){
		 ResultSet rs;
	     Connection connection = null;
 	     Double price = 0.0;
 	     PreparedStatement ps;

	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT ���� FROM test.times JOIN test.perioxes ON perioxes.pid=times.pid WHERE perioxes.�������= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();

	            while(rs.next()) {
	            	
	                price = rs.getDouble("����");

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

	public static final Vector getDays(String perioxh){
		
		 Vector days = new Vector();
		 int pid=0;
		 ResultSet rs;
		 ResultSet rs2;
	     Connection connection = null;
	     PreparedStatement ps;
	     PreparedStatement ps2;

	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT pid from test.perioxes WHERE �������= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();
	            
	            
	           

	            while(rs.next()) {
	            	
	            	
	                pid = rs.getInt("pid");
	                
	            }
	            
	            
	            
	            ps2 = connection.prepareStatement("SELECT ������ FROM test.meres JOIN test.routes ON meres.mid=routes.mid WHERE pid= ?");
	            ps2.setInt(1,pid );
	            rs2 = ps2.executeQuery();
	            
	            while(rs2.next()) {
	            	
	            	days.addElement(rs2.getString("������"));
	            	
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

		return days;
	}
	
	public static final Vector getTimes(String perioxh){
		 Vector times = new Vector();
		 int pid=0;
		 ResultSet rs;
		 ResultSet rs2;
	     Connection connection = null;
	     PreparedStatement ps;
	     PreparedStatement ps2;

	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT pid from test.perioxes WHERE �������= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();
	            
	            
	           

	            while(rs.next()) {
	            	
	            	
	                pid = rs.getInt("pid");
	                
	            }
	            
	            
	            
	            ps2 = connection.prepareStatement("SELECT ���� FROM test.wres JOIN test.combo ON wres.wid=combo.wid WHERE pid= ?");
	            ps2.setInt(1,pid );
	            rs2 = ps2.executeQuery();
	            
	            while(rs2.next()) {
	            	
	            	times.addElement(rs2.getString("����"));
	            	
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

	public static final void insertPerioxes(String perioxh){
		
		 //ResultSet rs = null;
	     Connection connection = null;
	     PreparedStatement ps =null;


	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("INSERT INTO test.perioxes_test (�������) VALUES ( ? )");
	            ps.setString(1, perioxh);
	            ps.executeUpdate();

	         
   
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

	static final void insertRoutes(String perioxh,String hmera){
		
		 int pid=0;
		 int mid=0;
		 ResultSet rs;
		 ResultSet rs2;
		 ResultSet rs3;
	     Connection connection = null;
	     PreparedStatement ps;
	     PreparedStatement ps2;
	     PreparedStatement ps3;
	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT pid from test.perioxes_test WHERE �������= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();
	            
	            
	           

	            while(rs.next()) {
	            	
	            	
	                pid = rs.getInt("pid");
	                
	            }
	            
	            
	            
	            ps2 = connection.prepareStatement("SELECT mid from test.meres WHERE ������= ? ");
	            ps2.setString(1,hmera );
	            rs2 = ps2.executeQuery();
	            
	            while(rs2.next()) {
	            	
	            	mid = rs2.getInt("mid");
	            	
	            }
	            
	            ps3 = connection.prepareStatement("INSERT INTO test.routes_test (pid, mid) VALUES (? , ?)");
	            ps3.setInt(1,pid );
	            ps3.setInt(2,mid );
	            ps3.executeUpdate();
	            
	            
	           
	            
	            
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
	}

	static final void insertTimes(String perioxh,Double price){

		
		int pid=0;
		 ResultSet rs;
	     Connection connection = null;
	     PreparedStatement ps;
	     PreparedStatement ps2;
	     
	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT pid from test.perioxes_test WHERE �������= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();

	            while(rs.next()) {
	            	
	            	
	                pid = rs.getInt("pid");
	                
	            }

	            ps2 = connection.prepareStatement("INSERT INTO test.times_test (����, pid) VALUES (? , ?) ");
	            ps2.setDouble(1, price);
	            ps2.setInt(2,pid);
	            ps2.executeUpdate();
	            

	            
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
	}
	
	static final void insertWres(String perioxh,String wra){
		 int pid=0;
		 int wid=0;
		 ResultSet rs;
		 ResultSet rs2;
		 ResultSet rs3;
	     Connection connection = null;
	     PreparedStatement ps;
	     PreparedStatement ps2;
	     PreparedStatement ps3;
	     try {
	            connection = JDBCMySQLConnection.getConnection();
	            
	            ps = connection.prepareStatement("SELECT pid from test.perioxes_test WHERE �������= ? ");
	            ps.setString(1, perioxh);
	            rs = ps.executeQuery();
	            
	            
	           

	            while(rs.next()) {
	            	
	            	
	                pid = rs.getInt("pid");
	                
	            }
	            
	            
	            
	            ps2 = connection.prepareStatement("SELECT wid from test.wres WHERE ����= ? ");
	            ps2.setString(1,wra );
	            rs2 = ps2.executeQuery();
	            
	            while(rs2.next()) {
	            	
	            	wid = rs2.getInt("wid");
	            	
	            }
	            
	            ps3 = connection.prepareStatement("INSERT INTO test.combo_test (pid, wid) VALUES (? , ?)");
	            ps3.setInt(1,pid );
	            ps3.setInt(2,wid );
	            ps3.executeUpdate();
	            
	            
	           
	            
	            
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
		
	}

}
