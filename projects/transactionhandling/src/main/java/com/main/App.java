package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App 
{
	
	private static final String URL="jdbc:mysql://127.0.0.1:3306/mydb";
	private static final String USERNAME="root";
	private static final String PASSWORD="admin1234";
	
    public static void main( String[] args )
    {
       
    	// Example for commit() & rollback()
    	
    	try {
    		// Connect with the DB 
    		
    		Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    		
    		String sqlString="INSERT INTO members_table (name,city,pincode)VALUES(?,?,?)";
    		connection.setAutoCommit(false);
    		
    		PreparedStatement person1=connection.prepareStatement(sqlString);
    		person1.setString(1, "Rohit");
    		person1.setString(2, "Dehli");
    		person1.setInt(3, 887766);
    		PreparedStatement person2=connection.prepareStatement(sqlString);
    		person2.setString(1, "Kiran");
    		person2.setString(2, "Mumbai");
    		person2.setInt(3, 998877);
    		PreparedStatement person3=connection.prepareStatement(sqlString);
    		person3.setString(1, "Sohel");
    		person3.setString(2, "Gujrat");
    		person3.setInt(3, 775566);
    		PreparedStatement person4=connection.prepareStatement(sqlString);
    		person4.setString(1, "Payal");
    		person4.setString(2, "Nagpur");
    		person4.setInt(3, 8888);
    		
    		PreparedStatement person5=connection.prepareStatement(sqlString);
    		person5.setString(1, "Mayur");
    		person5.setString(2, "Pune");
    		person5.setInt(3, 443321);
    		
    		
  		  	int rowsForP1Affected=person1.executeUpdate();
  		  	System.out.println( "Rows Affected "+rowsForP1Affected +" for person 1");
  		  	int rowsForP2Affected=person2.executeUpdate();
  		  	System.out.println( "Rows Affected "+rowsForP2Affected +"for person 2");

    		int rowsForP3Affected=person3.executeUpdate();
  		  	System.out.println( "Rows Affected "+rowsForP3Affected +" for person 3");

    		int rowsForP4Affected=person4.executeUpdate();
  		  	System.out.println( "Rows Affected "+rowsForP4Affected +" for person 4");

    		int rowsForP5Affected=person5.executeUpdate();
  		  	System.out.println( "Rows Affected "+rowsForP5Affected +" for person 5");

    		
    		if( 	rowsForP1Affected>0
    				&&rowsForP2Affected>0
    				&&rowsForP3Affected>0
    				&&rowsForP4Affected>0
    				&&rowsForP5Affected>0) {
    			connection.commit();
    			System.out.println("Transaction completed..!");
    		}else {
    			connection.rollback();
    			System.out.println("Transaction failed..!");
    		}

    	person1.close();
    	person2.close();
    	person3.close();
    	person4.close();
    	person5.close();
    	connection.close();
    	System.out.println("Connection closed...!");


    		
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	
    	
    }
}
