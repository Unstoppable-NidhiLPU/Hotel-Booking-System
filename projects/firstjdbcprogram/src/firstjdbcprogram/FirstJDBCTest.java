package firstjdbcprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FirstJDBCTest {
 
	
	// connect with the Database and retrieve the Data from DB 
	
			// JDBC URL , USERNAME , PASSWORD of MYSQL DB
	
	private static final String URL="jdbc:mysql://127.0.0.1:3306/customerdb";
	private static final String USERNAME="root";
	private static final String PASSSWORD="admin1234";
	
	
	public static void main(String[] args)throws ClassNotFoundException {
		System.out.println("Welcome to JDBC course");
		
		// Establishing a connection the DB.
		
		
	try(Connection connection=	DriverManager.getConnection(URL,USERNAME,PASSSWORD)) {	
          System.out.println("Connected to DB .....!");
          
         try {
        	 
        	 // Execute SQL queries
        	 Statement stmt= connection.createStatement();
             
             ResultSet resultSet=stmt.executeQuery("SELECT * FROM customertable;");
             
             // Processsing the Data from DB 
           while(resultSet.next()) {
        	   
        	   // imp
        	   
        	   int id =  resultSet.getInt("id");
        	   String name = resultSet.getString("name");
        	   String phoneNumber= resultSet.getString("phone_number");
        	   String emailAddress=resultSet.getString("email_address");
        	   
        	   System.out.println();
        	   System.out.println("..................................");
        	   System.out.println("Customer data : "
        	   		+ " ID : "+id
        	   		+ " Name : " +name
        	   		+ " phone number :  "+phoneNumber
        	   		+ " email address : "+ emailAddress
        	   	);
        	
           }
              
		} catch (SQLException e) {
	        System.out.println("Failed to execute SQL queries on the DB .....! message :   "+e.getMessage() );

		}
		
	} catch (SQLException e) {
		
        System.out.println("Failed to Connect to DB .....! message : " +e.getMessage() );

	}
	
	
		
	}

}
