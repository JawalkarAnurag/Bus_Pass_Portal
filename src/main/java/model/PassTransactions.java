package model;

public class PassTransactions {

	String passId,passType,userMob,date,passRouteType,amount,pay_id,order_id,rzp_sign;

	public String getPassId() {
		return passId;
	}

	public void setPassId(String passId) {
		this.passId = passId;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPassRouteType() {
		return passRouteType;
	}

	public void setPassRouteType(String passRouteType) {
		this.passRouteType = passRouteType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPay_id() {
		return pay_id;
	}

	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getRzp_sign() {
		return rzp_sign;
	}

	public void setRzp_sign(String rzp_sign) {
		this.rzp_sign = rzp_sign;
	}

	public PassTransactions(String passId, String passType, String userMob, String date, String passRouteType,
			String amount, String pay_id, String order_id, String rzp_sign) {
		super();
		this.passId = passId;
		this.passType = passType;
		this.userMob = userMob;
		this.date = date;
		this.passRouteType = passRouteType;
		this.amount = amount;
		this.pay_id = pay_id;
		this.order_id = order_id;
		this.rzp_sign = rzp_sign;
	}

	public PassTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
