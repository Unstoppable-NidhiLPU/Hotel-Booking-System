package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


/**
 * Hello world!
 *
 */
public class App 
{
	private static final String URL="jdbc:mysql://127.0.0.1:3306/mydb";
	private static final String USERNAME="root";
	private static final String PASSWORD="admin1234";
    public static void main( String[] args )
    {
       // Connect to DB 
    	
    	// "E:\images\cat.jpg"
    	String path="E:\\images\\cat.jpg";
    	String dogImagePath= "E:\\images\\dog.webp";
    	
    	String animalImagePath="E:\\images\\image1.jpg";
    	
    	try {
    		
    		Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    		System.out.println("Connected to DB....");
    		
    		insertImage(connection, animalImagePath,"fox");
    		
    		// Retrieving data from db
    		retrieveImage(connection);
    		
			connection.close();
			System.out.println("Connection closed...");
		} catch (SQLException e) {
			System.out.println("failed to connect with DB.." + e.getMessage());
		}
    }
    
    // Method to insert the image into the table  animal_table
    
    private static void insertImage(Connection connection, String imagePath, String animalName) {
    	
    	String sql="INSERT INTO animal_table (image,time_stamp,name) VALUES(?,?,?)";
    	
    	try {
    		PreparedStatement preparedStatement=connection.prepareStatement(sql);
    		
    		
    		// convert image into binary form 
    		
    		FileInputStream inputStream = new FileInputStream(imagePath);
    		
    		//System.out.println(inputStream);
    		
    		preparedStatement.setBinaryStream(1, inputStream);
    		preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
    		preparedStatement.setString(3, animalName);

    		int rowsAffected =preparedStatement.executeUpdate();
    		
    		System.out.println("row(s) affected  : " + rowsAffected);
    		
    	preparedStatement.close();
    	
		} catch (SQLException | FileNotFoundException e) {
			
		System.out.println("failed to insert image into table  :  " + e.getMessage() );
		}
    	
    }
    
    // Method to retrieve images from table 
    
    private static void retrieveImage(Connection connection) {
    	
    	String  sql= "SELECT * FROM animal_table";
    	
    	try {
    		
    		PreparedStatement preparedStatement=connection.prepareStatement(sql);
    		ResultSet resultSet=preparedStatement.executeQuery();
    		
    		while (resultSet.next()) {
				
    			// retrieving id 
				int id = resultSet.getInt("id");
				// retrieving binaryStream 
				byte[]imageData = resultSet.getBytes("image");
				// retrieving Time stamp 
				
				Timestamp timestamp = resultSet.getTimestamp("time_stamp");
				// retrieving name 
				String name= resultSet.getString("name");
				writeImageToFIle(imageData,timestamp,name);
				
				
			}
			
		} catch (SQLException e) {
			System.out.println("failed to retrieve the image : "+ e.getMessage());
		}
    	
    }
    
    // Method to write image data into file
    
    private static void writeImageToFIle(byte[]imageData,Timestamp timestamp, String name) {
    	
    	String fileName="image_"+name+"_"+timestamp.getTime()+".jpg";
    	
    	try {
			FileOutputStream fos= new FileOutputStream(fileName);
			fos.write(imageData);
			System.out.println("image is saved to " + fileName);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	
    }
    
    
    
}
