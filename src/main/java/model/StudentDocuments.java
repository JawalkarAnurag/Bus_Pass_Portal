package model;

public class StudentDocuments {

	String application_id, fn_photo,fn_bonafide,fn_lightbill,fn_feeReceipt,fn_aadhaar;

	public String getApplication_id() {
		return application_id;
	}

	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}

	public String getFn_photo() {
		return fn_photo;
	}

	public void setFn_photo(String fn_photo) {
		this.fn_photo = fn_photo;
	}

	public String getFn_bonafide() {
		return fn_bonafide;
	}

	public void setFn_bonafide(String fn_bonafide) {
		this.fn_bonafide = fn_bonafide;
	}

	public String getFn_lightbill() {
		return fn_lightbill;
	}

	public void setFn_lightbill(String fn_lightbill) {
		this.fn_lightbill = fn_lightbill;
	}

	public String getFn_feeReceipt() {
		return fn_feeReceipt;
	}

	public void setFn_feeReceipt(String fn_feeReceipt) {
		this.fn_feeReceipt = fn_feeReceipt;
	}

	public String getFn_aadhaar() {
		return fn_aadhaar;
	}

	public void setFn_aadhaar(String fn_aadhaar) {
		this.fn_aadhaar = fn_aadhaar;
	}

	public StudentDocuments(String application_id, String fn_photo, String fn_bonafide, String fn_lightbill,
			String fn_feeReceipt, String fn_aadhaar) {
		super();
		this.application_id = application_id;
		this.fn_photo = fn_photo;
		this.fn_bonafide = fn_bonafide;
		this.fn_lightbill = fn_lightbill;
		this.fn_feeReceipt = fn_feeReceipt;
		this.fn_aadhaar = fn_aadhaar;
	}

	public StudentDocuments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
