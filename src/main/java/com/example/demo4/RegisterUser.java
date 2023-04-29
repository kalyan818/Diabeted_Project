package com.example.demo4;

import java.util.Date;

public class RegisterUser {	
	private String FullName;
	private String Email;
	private long PhoneNumber;
	private String DOB;
	private String Username;
	private String Password;
	
	private String SecondPasswordQuestion1;
	private String SecondPasswordQuestion2;
	private String SecondPasswordQuestion3;
	
	private String SecondPasswordAnswer1;
	private String SecondPasswordAnswer2;
	private String SecondPasswordAnswer3;
	
	private String ThirdPasswordCar;
	private String ThirdPasswordTraffic;
	private String ThirdPasswordTree;
	
	
	
	
	
	
	public String getSecondPasswordQuestion1() {
		return SecondPasswordQuestion1;
	}
	public void setSecondPasswordQuestion1(String secondPasswordQuestion1) {
		SecondPasswordQuestion1 = secondPasswordQuestion1;
	}
	public String getSecondPasswordQuestion2() {
		return SecondPasswordQuestion2;
	}
	public void setSecondPasswordQuestion2(String secondPasswordQuestion2) {
		SecondPasswordQuestion2 = secondPasswordQuestion2;
	}
	public String getSecondPasswordQuestion3() {
		return SecondPasswordQuestion3;
	}
	public void setSecondPasswordQuestion3(String secondPasswordQuestion3) {
		SecondPasswordQuestion3 = secondPasswordQuestion3;
	}
	public String getSecondPasswordAnswer1() {
		return SecondPasswordAnswer1;
	}
	public void setSecondPasswordAnswer1(String secondPasswordAnswer1) {
		SecondPasswordAnswer1 = secondPasswordAnswer1;
	}
	public String getSecondPasswordAnswer2() {
		return SecondPasswordAnswer2;
	}
	public void setSecondPasswordAnswer2(String secondPasswordAnswer2) {
		SecondPasswordAnswer2 = secondPasswordAnswer2;
	}
	public String getSecondPasswordAnswer3() {
		return SecondPasswordAnswer3;
	}
	public void setSecondPasswordAnswer3(String secondPasswordAnswer3) {
		SecondPasswordAnswer3 = secondPasswordAnswer3;
	}
	public String getThirdPasswordCar() {
		return ThirdPasswordCar;
	}
	public void setThirdPasswordCar(String thirdPasswordCar) {
		ThirdPasswordCar = thirdPasswordCar;
	}
	public String getThirdPasswordTraffic() {
		return ThirdPasswordTraffic;
	}
	public void setThirdPasswordTraffic(String thirdPasswordTraffic) {
		ThirdPasswordTraffic = thirdPasswordTraffic;
	}
	public String getThirdPasswordTree() {
		return ThirdPasswordTree;
	}
	public void setThirdPasswordTree(String thirdPasswordTree) {
		ThirdPasswordTree = thirdPasswordTree;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}


	public long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "RegisterUser [FullName=" + FullName + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", DOB="
				+ DOB + ", Username=" + Username + ", Password=" + Password + ", SecondPasswordQuestion1="
				+ SecondPasswordQuestion1 + ", SecondPasswordQuestion2=" + SecondPasswordQuestion2
				+ ", SecondPasswordQuestion3=" + SecondPasswordQuestion3 + ", SecondPasswordAnswer1="
				+ SecondPasswordAnswer1 + ", SecondPasswordAnswer2=" + SecondPasswordAnswer2
				+ ", SecondPasswordAnswer3=" + SecondPasswordAnswer3 + ", ThirdPasswordCar=" + ThirdPasswordCar
				+ ", ThirdPasswordTraffic=" + ThirdPasswordTraffic + ", ThirdPasswordTree=" + ThirdPasswordTree + "]";
	}

	

}
