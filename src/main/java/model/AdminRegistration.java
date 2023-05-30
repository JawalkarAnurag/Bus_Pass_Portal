package model;

public class AdminRegistration {
	
	String adminName,adminID,adminMobile,adminMail,adminPassword;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminMail() {
		return adminMail;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public AdminRegistration(String adminName, String adminID, String adminMobile, String adminMail,
			String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminID = adminID;
		this.adminMobile = adminMobile;
		this.adminMail = adminMail;
		this.adminPassword = adminPassword;
	}

	public AdminRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
