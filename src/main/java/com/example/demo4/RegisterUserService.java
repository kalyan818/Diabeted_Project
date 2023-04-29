package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysql.cj.exceptions.RSAException;

@Service
public class RegisterUserService {

	// This method checks whether a user with the same username or email already
	// exists in the database
	// It takes a RegisterUser object as input, which contains the user's details to
	// be checked
	// It returns a boolean value: true if the details exist in the database, false
	// otherwise
	public boolean checkUserDetailsExists(RegisterUser registerUser) {
		// Set up the database connection information
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		// Initialize a variable to store whether or not the details exist in the
		// database
		boolean detailsExits = false;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			// Search for a user with the same username or email as the input RegisterUser
			// object
			ResultSet rs = stmt.executeQuery("SELECT * FROM users where Username='" + registerUser.getUsername()
					+ "' or Email = '" + registerUser.getEmail() + "';");

			if (!rs.next()) { // if ResultSet is empty, no details exist in the database
				detailsExits = false;
			} else { // if ResultSet is not empty, details exist in the database
				do {
					detailsExits = true;
					String name = rs.getString("Username");
				} while (rs.next());
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (detailsExits) { // return true if details exist in the database, false otherwise
			return true;
		} else {
			return false;
		}

	}

	/*
	 * This method creates a user account by inserting user details into a MySQL
	 * database table named "users". The method takes an object of RegisterUser
	 * class as input which contains user's personal details like name, email, phone
	 * number, date of birth, etc.
	 * 
	 * The method returns a boolean value that indicates whether the user account
	 * was created successfully or not. If the rows value is zero, then the method
	 * returns false, otherwise it returns true.
	 * 
	 */

	public boolean createUserDetails(RegisterUser registerUser) {
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		boolean detailsExits = false;
		int rows = 0;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			rows = stmt.executeUpdate("INSERT INTO users (FullName, Email, PhoneNumber, DOB, Username, Password,"
					+ "SecondPasswordQuestion1,SecondPasswordQuestion2,SecondPasswordQuestion3,"
					+ "SecondPasswordAnswer1,SecondPasswordAnswer2,SecondPasswordAnswer3,"
					+ "ThirdPasswordCar,ThirdPasswordTraffic,ThirdPasswordTree)" + "VALUES ('"
					+ registerUser.getFullName() + "', '" + registerUser.getEmail() + "',"
					+ registerUser.getPhoneNumber() + ", '" + registerUser.getDOB() + "', '"
					+ registerUser.getUsername() + "', '" + registerUser.getPassword() + "','"
					+ registerUser.getSecondPasswordQuestion1() + "','" + registerUser.getSecondPasswordQuestion2()
					+ "','" + registerUser.getSecondPasswordQuestion3() + "','"
					+ registerUser.getSecondPasswordAnswer1() + "','" + registerUser.getSecondPasswordAnswer2() + "','"
					+ registerUser.getSecondPasswordAnswer3() + "','" + registerUser.getThirdPasswordCar() + "','"
					+ registerUser.getThirdPasswordTraffic() + "','" + registerUser.getThirdPasswordTree() + "');");

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (rows == 0) {
			return false;
		} else {
			return true;
		}

	}

	// This method retrieves image details from the database and returns a list of
	// Images objects.
	public List<Images> getImages() {

		// Database connection parameters
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		int rows = 0;
		// Create an empty list to store Images objects
		List<Images> images = new ArrayList<>();

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query to select all records from the Images table
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Images");

			// Process each record returned by the query and create Images objects
			while (rs.next()) {
				Images image = new Images();
				image.setCar(rs.getBytes("car"));
				image.setCarName(rs.getString("carName"));
				image.setTraffic(rs.getBytes("traffic"));
				image.setTrafficName(rs.getString("trafficName"));
				image.setTree(rs.getBytes("tree"));
				image.setTreeName(rs.getString("treeName"));
				images.add(image);
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Return the list of Images objects
		return images;
	}
}
