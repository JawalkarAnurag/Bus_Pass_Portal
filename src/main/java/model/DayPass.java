package model;

public class DayPass {

	 String govID,gender,area,amount,passId,date,time;

	public String getGovID() {
		return govID;
	}

	public void setGovID(String govID) {
		this.govID = govID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPassId() {
		return passId;
	}

	public void setPassId(String passId) {
		this.passId = passId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public DayPass(String govID, String gender, String area, String amount, String passId, String date, String time) {
		super();
		this.govID = govID;
		this.gender = gender;
		this.area = area;
		this.amount = amount;
		this.passId = passId;
		this.date = date;
		this.time = time;
	}

	public DayPass() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
