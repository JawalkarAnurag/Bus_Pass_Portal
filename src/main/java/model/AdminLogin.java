package model;

public class AdminLogin {
	
	String adminID,adminPassword;

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public AdminLogin(String adminID, String adminPassword) {
		super();
		this.adminID = adminID;
		this.adminPassword = adminPassword;
	}

	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
