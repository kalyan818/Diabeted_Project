package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class LoginUserService {

	public boolean checkUserDetailsExists(LoginUser loginUser) {
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
			 ResultSet rs = stmt.executeQuery("SELECT * FROM users where Username='"+loginUser.getUsername()+"' and "
			 		+ "Password = '"+loginUser.getPassword()+"' and "
			 		+ "SecondPasswordQuestion1 ='" +loginUser.getSecondPasswordQuestion1()+"' and "
			 		+ "SecondPasswordQuestion2 ='" +loginUser.getSecondPasswordQuestion2()+"' and "
			 		+ "SecondPasswordQuestion3 ='" +loginUser.getSecondPasswordQuestion3()+"' and "
			 		+ "SecondPasswordAnswer1 ='" +loginUser.getSecondPasswordAnswer1()+"' and "
			 		+ "SecondPasswordAnswer2 ='" +loginUser.getSecondPasswordAnswer2()+"' and "
			 		+ "SecondPasswordAnswer3 ='" +loginUser.getSecondPasswordAnswer3()+"' and "
			 		+ "ThirdPasswordCar ='" +loginUser.getThirdPasswordCar()+"' and "
			 		+ "ThirdPasswordTraffic ='" +loginUser.getThirdPasswordTraffic()+"' and "
			 		+ "ThirdPasswordTree ='" +loginUser.getThirdPasswordTree()+"';");

			 
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
			rows = stmt.executeUpdate("INSERT INTO users (FullName, Email, PhoneNumber, DOB, Username, Password)"
					+ "VALUES ('" + registerUser.getFullName() + "', '" + registerUser.getEmail() + "',"
					+ registerUser.getPhoneNumber() + ", '" + registerUser.getDOB() + "', '"
					+ registerUser.getUsername() + "', '" + registerUser.getPassword() + "');");
			
			
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

	public boolean updatePassword(OTPModel otpModel) {
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
			rows = stmt.executeUpdate("UPDATE users  SET Password = '"+otpModel.getPassword()+"',"
			 		+ "SecondPasswordQuestion1 ='" +otpModel.getSecondPasswordQuestion1()+"' , "
			 		+ "SecondPasswordQuestion2 ='" +otpModel.getSecondPasswordQuestion2()+"' , "
			 		+ "SecondPasswordQuestion3 ='" +otpModel.getSecondPasswordQuestion3()+"' , "
			 		+ "SecondPasswordAnswer1 ='" +otpModel.getSecondPasswordAnswer1()+"' , "
			 		+ "SecondPasswordAnswer2 ='" +otpModel.getSecondPasswordAnswer2()+"' , "
			 		+ "SecondPasswordAnswer3 ='" +otpModel.getSecondPasswordAnswer3()+"' , "
			 		+ "ThirdPasswordCar ='" +otpModel.getThirdPasswordCar()+"' , "
			 		+ "ThirdPasswordTraffic ='" +otpModel.getThirdPasswordTraffic()+"' , "
			 		+ "ThirdPasswordTree ='" +otpModel.getThirdPasswordTree()+"' "
			 				+  "WHERE Email = '"+otpModel.getEmail()+"';");

					
					
					System.out.println("UPDATE users  SET Password = '"+otpModel.getPassword()+"',"
			 		+ "SecondPasswordQuestion1 ='" +otpModel.getSecondPasswordQuestion1()+"' , "
			 		+ "SecondPasswordQuestion2 ='" +otpModel.getSecondPasswordQuestion2()+"' , "
			 		+ "SecondPasswordQuestion3 ='" +otpModel.getSecondPasswordQuestion3()+"' , "
			 		+ "SecondPasswordAnswer1 ='" +otpModel.getSecondPasswordAnswer1()+"' , "
			 		+ "SecondPasswordAnswer2 ='" +otpModel.getSecondPasswordAnswer2()+"' , "
			 		+ "SecondPasswordAnswer3 ='" +otpModel.getSecondPasswordAnswer3()+"' , "
			 		+ "ThirdPasswordCar ='" +otpModel.getThirdPasswordCar()+"' , "
			 		+ "ThirdPasswordTraffic ='" +otpModel.getThirdPasswordTraffic()+"' , "
			 		+ "ThirdPasswordTree ='" +otpModel.getThirdPasswordTree()+"' "
			 				+  "WHERE Email = '"+otpModel.getEmail()+"';");
					
				
			
			
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
	
	

}
