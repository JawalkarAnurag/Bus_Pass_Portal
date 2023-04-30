package model;

public class UserLogin {
	
	String userMobile,userPassword;

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

	public UserLogin(String userMobile, String userPassword) {
		super();
		this.userMobile = userMobile;
		this.userPassword = userPassword;
	}

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
