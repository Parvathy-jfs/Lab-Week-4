//CRUD
package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
	public static void main(String[] args) { //All methods kept static for ease
		dropTable();
		createTable();
		createProduct();
		createProduct(104, "Wings of Fire");
		updateProduct();
		updateProduct(104, "THE PLACEBO EFFECT");
		deleteProduct(104);
		insertRecordsUsingPreparedStatement();
		
	}

	
	public static void dropTable() {
		// Get ojdbc14.jar
		// Load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement= connection.createStatement();
			//Execute Query
			String dropTableQuery= "DROP TABLE PRODUCTS";
			System.out.println(dropTableQuery);
			statement.execute(dropTableQuery);
			System.out.println("Successfully DROPPED table ");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void createTable() {
		// Get ojdbc14.jar
				// Load the driver
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//System.out.println("Driver loaded successfully!");
					//Get the connection
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
					//System.out.println("Connection Established!");
					//Create the statement
					Statement statement= connection.createStatement();  //Interface
					//Execute Query
					String createTableQuery= "CREATE TABLE PRODUCTS";
					System.out.println(createTableQuery);
					statement.execute(createTableQuery);
					System.out.println("Successfully CREATED table ");
				} catch (ClassNotFoundException e) {
					System.out.println(e);
				} catch (SQLException e) {
					System.out.println(e);
				}
	}

	public static void createProduct() {                       //INSERT in SQL terminology
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement= connection.createStatement();  //Interface
			//Execute the query
			
			//Hard coded values=> Every time the code is executed these values are taken
			
			String insertQuery= "INSERT INTO PRODUCTS VALUES (102, 'CAN'T HURT ME')";
			int noOfRowsAffected = statement.executeUpdate(insertQuery);
			System.out.println("Successfully INSERTED " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	

	public static void createProduct(int productId, String productName) {    //INSERT in SQL terms
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement= connection.createStatement();  //Interface
			//Execute the query
			//Not hard coded. User inputs variables dynamically
			String insertQuery= "INSERT INTO PRODUCTS VALUES ("+productId+", '"+productName+ "')";
			System.out.println(insertQuery);
			int noOfRowsAffected = statement.executeUpdate(insertQuery);
			System.out.println("Successfully INSERTED " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void updateProduct() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement= connection.createStatement();  //Interface
			//Execute the query
			//Updates the productname field of all records to the same name specified.
			String updateQuery= "UPDATE PRODUCTS SET PRODUCTNAME= 'The Power of Positive Thinking'";
			System.out.println(updateQuery);
			int noOfRowsAffected = statement.executeUpdate(updateQuery);
			System.out.println("Successfully UPDATED " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}

	public static void updateProduct(int productId, String productName) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement= connection.createStatement();  //Interface
			//Execute the query
			//Updates the productname field of all records to the same name specified.
			String updateQuery= "UPDATE PRODUCTS SET PRODUCTNAME= '"+ productName +"' WHERE PRODUCTID= "+productId;
			System.out.println(updateQuery);
			int noOfRowsAffected = statement.executeUpdate(updateQuery);
			System.out.println("Successfully UPDATED " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	public static void deleteProduct(int productId) {
		// Get ojdbc14.jar
		// Load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			String updateQuery = "delete from products where productid= "+productId;
			System.out.println(updateQuery);
			int noOfRowsAffected = statement.executeUpdate(updateQuery);
			System.out.println("Successfully deleted " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		
	}

	public static void deleteAllProducts() {
		// Get ojdbc14.jar
				// Load the driver
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//System.out.println("Driver loaded successfully!");
					//Get the connection
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
					//System.out.println("Connection Established!");
					//Create the statement
					Statement statement = connection.createStatement();
					//Execute the query
					String updateQuery = "delete from products";
					System.out.println(updateQuery);
					int noOfRowsAffected = statement.executeUpdate(updateQuery);
					System.out.println("Successfully deleted " + noOfRowsAffected + "record(s)!");
				} catch (ClassNotFoundException e) {
					System.out.println(e);
				} catch (SQLException e) {
					System.out.println(e);
				}
		
	}
	public static void insertRecordsUsingPreparedStatement() {
		// Get ojdbc14.jar
		// Load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			
			String insertQuery = "insert into products values (?,?)";
			//Create the statement
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			//Execute the query
			preparedStatement.setInt(1,110);
			preparedStatement.setString(2, "The Alchemist");
			int noOfRowsAffected = preparedStatement.executeUpdate();
			System.out.println("Successfully inserted " + noOfRowsAffected + "record(s)!");
			preparedStatement.setInt(1,111);
			preparedStatement.setString(2, "The Monk Who Sold His Ferrari!");
			noOfRowsAffected = preparedStatement.executeUpdate();
			System.out.println("Successfully inserted " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}


