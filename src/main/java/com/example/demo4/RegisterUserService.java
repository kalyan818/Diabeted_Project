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

	public boolean checkUserDetailsExists(RegisterUser registerUser) {
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		 String userN = System.getenv("USER");
		 String pass = System.getenv("PASS");
		 System.out.println(userN);
		 System.out.println(pass);
		 boolean detailsExits = false;
		 
		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM users where Username='"+registerUser.getUsername()+
					 "' or Email = '"+registerUser.getEmail()+"';");

			 if(!rs.next()) {
				 detailsExits = false;
				} else {
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
		if(detailsExits) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean createUserDetails(RegisterUser registerUser) {
		
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		 String userN = System.getenv("USERNAME");
		 String pass = System.getenv("PASSWORD");
		 System.out.println(userN);
		 System.out.println(pass);
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
					+ "ThirdPasswordCar,ThirdPasswordTraffic,ThirdPasswordTree)"
					+ "VALUES ('" + registerUser.getFullName() + "', '" + registerUser.getEmail() + "',"
					+ registerUser.getPhoneNumber() + ", '" + registerUser.getDOB() + "', '"
					+ registerUser.getUsername() + "', '" + registerUser.getPassword() + "','"
					+registerUser.getSecondPasswordQuestion1()+"','"+registerUser.getSecondPasswordQuestion2()+ "','"
					+registerUser.getSecondPasswordQuestion3()+"','"+registerUser.getSecondPasswordAnswer1()+ "','"
					+registerUser.getSecondPasswordAnswer2()+"','"+registerUser.getSecondPasswordAnswer3()+ "','"
					+registerUser.getThirdPasswordCar()+"','"+registerUser.getThirdPasswordTraffic()+ "','"
					+registerUser.getThirdPasswordTree()+ "');");
			
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 if(rows==0) {
			 return false;
			}else {
				return true;
			}
		
	
	}

	public List<Images> getImages() {
		
		
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		 int rows = 0;
		 List<Images> images = new ArrayList<>();
		 
		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM Images");
			
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
		return images;
		 
	}
}
