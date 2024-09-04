package testjdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {
		System.out.println("Welcome to the JDBC course...");
		
		String url ="jdbc:mysql://127.0.0.1:3306/testdb";
		String username="root";
		String password="admin1234";
		
		
        try {
    		Connection connection = DriverManager.getConnection(url,username,password);
    		
    		System.out.println("Hurreyyy we have successfully connected to the DB..");
		} 
        catch (Exception e) {
			// TODO: handle exception
        	System.out.println("Exception "+ e.getMessage());
        	System.out.println("Failed to connect with the Database...");
		}
		
		
	}

}
