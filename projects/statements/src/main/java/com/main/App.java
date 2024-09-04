package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 

{
	
	private static final String URL="jdbc:mysql://127.0.0.1:3306/customerdb";
	private static final String USERNAME="root";
	private static final String PASSWORD="admin1234";
	
    public static void main( String[] args )
    {
    
    	try{
    		Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
    		
    		System.out.println("Connected to DB...!");
    		
    		//String sql= "SELECT * FROM customertable";
    		
    		//String sqlforOne="SELECT * FROM customertable WHERE id=2" ;
    		
    		//String sqlforOne3="SELECT * FROM customertable WHERE id=3";
    		
    		String sqlString = "SELECT * FROM customertable WHERE id = ? AND name = ?";
    		
    		

    		// perform our op...
    		
    		// Statements  & preparedStatements 
    		
    		try {
    		//	Statement statement=connection.createStatement();
    			
        		
        	//	ResultSet resultSet =statement.executeQuery(sqlforOne3);
    			
    			PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
    			
    			Scanner scanner = new Scanner(System.in);
    			
    			System.out.print("Enter the ID : ");
    			int userInputId = scanner.nextInt();
    			System.out.print("Enter the name : ");
    			String inputName = scanner.next();
    			
    			
    			preparedStatement.setInt(1, userInputId);
    			preparedStatement.setString(2, inputName);
    			
    			
    			ResultSet resultSet =preparedStatement.executeQuery();
    			
        		while (resultSet.next()) {
					
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String phoneNumber= resultSet.getString("phone_number");
					String emailAddress=resultSet.getString("email_address");
					
					System.out.println("Customer data : "
							+ " id : "+ id 
							+ " Name : "+ name 
							+ "  phone  : "+ phoneNumber 
							+ " Email  : "+ emailAddress 
							);
				}
        		resultSet.close();
        		//statement.close();
        		preparedStatement.close();
        		System.out.println("close..");
        		
        		
			} catch (SQLException e) {

				System.out.println("Failed to execute the query on table.... Message : "+  e.getMessage());

			}
    		
    		
    		
    		
    		
    	// Closing the connection
    		
    		connection.close();
    		System.out.println("connection closed..");
    	}
    	catch (SQLException e) {
			System.out.println("Failed to connect with DB .... Message : "+  e.getMessage());
		}
    	
    	
    }
}
