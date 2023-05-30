package model;

import java.util.Date;

public class UserRegistration {
	
	String userName,userMail,userMobile,userPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserRegistration(String userName, String userMail, String userMobile, String userPassword) {
		super();
		this.userName = userName;
		this.userMail = userMail;
		this.userMobile = userMobile;
		this.userPassword = userPassword;
	}

	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	