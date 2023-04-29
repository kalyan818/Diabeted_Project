package com.example.demo4;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
    
    public boolean isValidEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

	public boolean checkEmailExists(String email) {
		String url = "jdbc:mysql://localhost:3306/diabetes";
		String username = "root";
		String password = "Kalyan@818";
		 boolean detailsExits = false;
		// TODO Auto-generated method stub
		
		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM users where Email='"+email+"';");

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
	

}
