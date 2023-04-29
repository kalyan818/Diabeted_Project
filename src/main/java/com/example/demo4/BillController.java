//import necessary libraries
package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//configure BillController as Controller 
@Controller
public class BillController {

	// inject RegisterUserService dependency
	@Autowired
	private RegisterUserService registerUserService;

	// inject LoginUserService dependency
	@Autowired
	private LoginUserService loginUserService;

	// inject EmailService dependency
	@Autowired
	private EmailService emailService;

	// inject FormService dependency
	@Autowired
	private FormService formService;

	// create random number object
	Random random = new Random();
	// generate a random number
	int randomNumber = random.nextInt(90000) + 10000;

	// handle GET request for RegisterUser page
	@RequestMapping(value = "/RegisterUser", method = RequestMethod.GET)
	public String RegisterUser(ModelMap model) {
		List<Images> images = new ArrayList<>();
		images = registerUserService.getImages();
		model.addAttribute("images", images);
		return "RegisterUser";
	}

	// handle POST request for RegisterUser page
	@RequestMapping(value = "/RegisterUser", method = RequestMethod.POST)
	public String RegisterUserPost(@ModelAttribute("RegisterUser") RegisterUser registerUser, ModelMap model) {
		// check if user details already exist
		if (registerUserService.checkUserDetailsExists(registerUser)) {
			model.put("message", "User Details Already Exists");
			List<Images> images = new ArrayList<>();
			images = registerUserService.getImages();
			model.addAttribute("images", images);
			return "RegisterUser";
		} else {
			// create user details if user details do not exist
			if (registerUserService.createUserDetails(registerUser)) {
				model.put("message", "Registered Sucessfully");
				List<Images> images = new ArrayList<>();
				images = registerUserService.getImages();
				model.addAttribute("images", images);
				return "LoginUser";
			} else {
				model.put("message", "Registration failed");
				List<Images> images = new ArrayList<>();
				images = registerUserService.getImages();
				model.addAttribute("images", images);
				return "RegisterUser";
			}

		}
	}

	// handle GET request for LoginUser page
	@RequestMapping(value = "/LoginUser", method = RequestMethod.GET)
	public String LoginUser(ModelMap model) {
		List<Images> images = new ArrayList<>();
		images = registerUserService.getImages();
		model.addAttribute("images", images);
		return "LoginUser";
	}

	// handle POST request for LoginUser page
	@RequestMapping(value = "/LoginUser", method = RequestMethod.POST)
	public String LoginUserPost(@ModelAttribute("LoginUser") LoginUser loginUser, ModelMap model) {

		System.out.println(loginUser.toString());
		// check if user details exist
		if (loginUserService.checkUserDetailsExists(loginUser)) {
			model.put("UserName", loginUser.getUsername());
			return "MainPage";
		} else {
			model.put("message", "User Details does not match");
			List<Images> images = new ArrayList<>();
			images = registerUserService.getImages();
			model.addAttribute("images", images);
			return "LoginUser";
		}
	}

	// handle GET request for ForgetPassword page
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.GET)
	public String ForgetPassword() {
		return "ForgetPassword";
	}

	// This method handles the forget password request and sends an email with an
	// OTP
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST)
	public String ForgetPasswordPost(@RequestParam(name = "Email", required = true) String Email, ModelMap model) {
		if (emailService.isValidEmail(Email) && emailService.checkEmailExists(Email)) {
			emailService.sendSimpleMessage(Email, "This mail contains OTP to reset the password",
					"OTP is " + randomNumber);
			model.put("Email", Email);
			List<Images> images = new ArrayList<>();
			images = registerUserService.getImages();
			model.addAttribute("images", images);
			return "OTPPage";
		} else {
			model.put("message", "Invalid Email Address \n" + " Email does not Exists");
			return "ForgetPassword";
		}
	}

	// This method returns the OTP page
	@RequestMapping(value = "/OTPPage", method = RequestMethod.GET)
	public String OTPPage(ModelMap model) {
		List<Images> images = new ArrayList<>();
		images = registerUserService.getImages();
		model.addAttribute("images", images);
		return "OTPPage";
	}

	// This method handles the OTP validation and password reset request
	@RequestMapping(value = "/OTPPage", method = RequestMethod.POST)
	public String OTPPagePost(@ModelAttribute("OTPModel") OTPModel OtpModel, ModelMap model) {
		if (Integer.parseInt(OtpModel.getOTP()) == randomNumber) {
			if (loginUserService.updatePassword(OtpModel)) {
				model.put("message", "Password reset successful");
				List<Images> images = new ArrayList<>();
				images = registerUserService.getImages();
				model.addAttribute("images", images);
				return "LoginUser";
			} else {
				model.put("message", "mail id not found");
				model.put("Email", OtpModel.getEmail());
				List<Images> images = new ArrayList<>();
				images = registerUserService.getImages();
				model.addAttribute("images", images);
				return "OTPPage";
			}
		} else {
			model.put("message", "Invalid OTP");
			model.put("Email", OtpModel.getEmail());
			List<Images> images = new ArrayList<>();
			images = registerUserService.getImages();
			model.addAttribute("images", images);
			return "OTPPage";
		}
	}

	// This method returns the form page
	@RequestMapping(value = "/FillForm", method = RequestMethod.GET)
	public String FillForm(@RequestParam(name = "UserName", required = true) String UserName, ModelMap model) {
		model.put("UserName", UserName);
		return "Form";
	}

	// This method handles the form submission
	@RequestMapping(value = "/FillForm", method = RequestMethod.POST)
	public String FillFormPost(@ModelAttribute("FormModel") FormModel Form, ModelMap model) {
		if (formService.InsertForm(Form)) {
			model.put("UserName", Form.getUserName());
			return "MainPage";
		} else {
			model.put("UserName", Form.getUserName());
			return "Form";
		}
	}

	// This method returns the details page for a given user
	@RequestMapping(value = "/PrintDetails", method = RequestMethod.GET)
	public String PrintDetails(@RequestParam(name = "UserName", required = true) String UserName, ModelMap model) {
		model.put("UserDetails", formService.GetDetails(UserName));
		return "PrintDetails";
	}

}