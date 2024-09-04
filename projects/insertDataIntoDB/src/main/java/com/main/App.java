package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
	private static final String URL="jdbc:mysql://127.0.0.1:3306/customerdb";
	private static final String USERNAME="root";
	private static final String PASSWORD="admin1234";
	
	
    public static void main( String[] args )
    {
        System.out.println( "How to insert the Data the DB" );
        
        
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
        	System.out.println("Connected to DB...!");
        	
        	// inserting data into the table 
        	
        //	insertData(connection,"Parth","777888551","parth@gmail.com");
        //	insertData(connection, "Arun", "00000023", "arun@gmail.com");
        	
        	//insertData(connection, "John", "777884443", "john@gmail.com");
        	//insertData(connection, "Perry", "99900077", "perry@gmail.com");

        	
        	
        	// Updating the data into the table 
        	
        	//updateData(connection,1,"Rajesh" );
        	
        //	deleteData(connection, 4);
        	// Executing a query to fetch all the record from the Table
        	try{
        		Statement statement=connection.createStatement();
        		ResultSet resultSet=statement.executeQuery("SELECT * FROM customertable");
        		
        		// Processing the result 
        		while(resultSet.next()) {
        	int id = resultSet.getInt("id");
        	String name= resultSet.getString("name");
        	String phoneNumber = resultSet.getString("phone_number");
        	String emailAddress= resultSet.getString("email_address");
        	
        	System.out.println(".......................................................");
        	
        	System.out.println("Customer data : " 
        			+ " Id : " + id
        			+ " Name : "+ name 
        			+ " Phone Number : "+ phoneNumber
        			+ " Email Address : "+emailAddress			
        			);
        		}
        		resultSet.close();
        		System.out.println("Closed the resultset");
        		
        		statement.close();
        		
        		System.out.println("Closed the statement");
        		
        	
        
        		
        		
        	}catch(SQLException e) {
        		System.out.println("Failed to fetch the data from the table... Message : "+e.getMessage());
        		
        	}
        	
        	
        	connection.close();
        	
        	System.out.println("Connection has been closed....!");
			
		} catch (SQLException e) {
        	System.out.println("Failed to connect to DB...! message : " + e.getMessage());

		}
    }
    
    
    
    // Method to insert data into the table 
    
    private static void insertData(Connection connection,String name, String phoneNumber , String emailAddress) {
    
    	String sql="INSERT INTO customertable(name, phone_number,email_address)VALUES(?,?,?)";
    	
    	try {
    		PreparedStatement pStmt =connection.prepareStatement(sql);
    		
    		pStmt.setString(1, name);
    		pStmt.setString(2, phoneNumber);
    		pStmt.setString(3, emailAddress);
    		 
    	   int rowsAffected=pStmt.executeUpdate();
    		
    		System.out.println(rowsAffected +" row(s) inserted. ");
    		
		} catch (SQLException e) {
			System.out.println("Failed to update the data into table.. Message : "+e.getMessage());
		}
    	
    	
    }
    
    
    // Method to update the record into the table 
    private static void updateData(Connection connection,int id, String name) {
    	
    	
    	String sql="UPDATE customertable SET name = ?  WHERE id = ?";
    	
    	try {
    		
    	PreparedStatement preparedStatement	=connection.prepareStatement(sql);
    	preparedStatement.setString(1, name);
    	preparedStatement.setInt(2, id);
    	int rowsAffected=preparedStatement.executeUpdate();
    	
    	System.out.println(rowsAffected+ "  rows(s) affected...");
    	
			
		} catch (SQLException e) {
			System.out.println("Failed to execute the SQL query .... Message : "+ e.getMessage());
		}
    	
    }
    
    // Method to delete the record from table 
    
    private static void deleteData(Connection connection, int id) {
    	
    	String sql="DELETE FROM customertable WHERE id = ?";
    	
    	try {
    		
    		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
    		 
    		 preparedStatement.setInt(1, id);
    		 
    		 int rowsAffected= preparedStatement.executeUpdate();
    		 System.out.println(rowsAffected+" row(s) affected");
    		
    	}
    	catch (SQLException e) {
			System.out.println("Failed to delete the data from the table.... Message : " + e.getMessage());
		}
    	
    	
    }
}
