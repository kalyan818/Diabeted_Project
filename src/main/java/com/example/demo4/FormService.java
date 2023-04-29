package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FormService {

	

	public boolean InsertForm(FormModel formModel) {
		
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		 int rows = 0;
		 
		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			rows = stmt.executeUpdate("INSERT INTO diabetesData (UserName, Date, TimeBefore, BloodLevelBefore, TimeAfter, BloodLevelAfter, Breakfast, Lunch, Dinner)"
					+ "VALUES ('" + formModel.getUserName()+ "', '" + formModel.getDate()+ "','"
					+ formModel.getTimeBefore() + "', " + formModel.getBloodLevelBefore() + ", '"
					+ formModel.getTimeAfter() + "', " + formModel.getBloodLevelAfter() + ", '"
					+ formModel.getBreakfast() + "', '" + formModel.getLunch()+ "','"+ formModel.getDinner()+"');");
			
			
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

	public List<FormModel> GetDetails(String registerUser) {
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		 String userN = System.getenv("USER");
		 String pass = System.getenv("PASS");
		 boolean detailsExits = false;
		 
		 List<FormModel> Details = new ArrayList<>();
		 
		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM diabetesData where Username='"+registerUser+"';");
			 while (rs.next()) {
				 FormModel form = new FormModel();
				 form.setUserName(rs.getString("UserName"));
				 form.setDate(rs.getString("Date"));
				 form.setTimeBefore(rs.getString("TimeBefore"));
				 form.setBloodLevelBefore( rs.getString("BloodLevelBefore"));
				 form.setTimeAfter(rs.getString("TimeAfter"));
				 form.setBloodLevelAfter(rs.getString("BloodLevelAfter"));
				 form.setBreakfast(rs.getString("Breakfast"));
				 form.setLunch(rs.getString("Lunch"));
				 form.setDinner(rs.getString("Dinner"));
	        	 Details.add(form);		 
			 }	
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
			return Details;
		
		
	}

	
	

}
