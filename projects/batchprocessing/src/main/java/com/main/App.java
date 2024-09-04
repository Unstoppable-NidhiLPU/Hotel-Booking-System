package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
	private static final String URL="jdbc:mysql://127.0.0.1:3306/mydb";
	private static final String USERNAME="root";
	private static final String PASSWORD="admin1234";
    public static void main( String[] args )
    {
        
    	try {
    		Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    		System.out.println("Connected to DB....");
    		
    		connection.setAutoCommit(false);
    		
    		// batch processing with help of Statement
    	
//    		Statement statement=connection.createStatement();
//    		statement.addBatch("INSERT INTO employees_table (name ,job_title,salary)"
//    				+ " VALUES('Parth','Sql Developer',65000.00)");
//    		
//    		statement.addBatch("INSERT INTO employees_table (name ,job_title,salary)"
//    				+ " VALUES('Shivam','Frontend develop',55000.00)");
//    		
//    		statement.addBatch("INSERT INTO employees_table (name ,job_title,salary)"
//    				+ " VALUES('Shraya','Backend developer',70000.00)");
//    		
//    		statement.addBatch("INSERT INTO employees_table (name ,job_title,salary)"
//    	    				+ " VALUES('Sakshi','Tester',65000.00)");
//    		
//    		statement.addBatch("INSERT INTO employees_table (name ,job_title,salary)"
//    	    	    				+ " VALUES('Riyansh','Hr manager',45000.00)");
//    		
//    		
//    		int [] rowsAffected =statement.executeBatch();
    		
    		
    		
    		
    		
    		
    		
//    		prepared statement
    		
    		Scanner scanner = new Scanner(System.in);
    		
    		String sqlString= "INSERT INTO employees_table (name,job_title,salary) VALUES (?,?,?)";
    		
         	PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
    	
    	while(true) {
    		System.out.print("Name : ");
    		String name=scanner.nextLine();
    		System.out.print("Job title : ");
    		String job_title=scanner.nextLine();
    		
    		System.out.print("Salary : ");
    		
    		Double salary=scanner.nextDouble();
    		
    		// setting inputs to preparedstatements
    		preparedStatement.setString(1, name);
    		preparedStatement.setString(2, job_title);
    		preparedStatement.setDouble(3, salary);
    		
    		// add these data into batch 
    		preparedStatement.addBatch();
    		System.out.println("Add New Employee : Y/N");
    		String userInput=scanner.nextLine();
    	
 
    		if(userInput.toUpperCase().equals("N")) {
    			break;
    		}
    		
    	}
    		
    		
    		
    		int[] rowsAffected =preparedStatement.executeBatch();
    		System.out.println("Batch processing completed....!");
    		connection.commit();
    		
    		preparedStatement.close();
    		
    		connection.close();
    		System.out.println("Connection closed....!");
    		
			
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
    	
    	
    }
}
