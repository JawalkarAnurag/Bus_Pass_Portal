package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import connector.DataSource;
import model.ApplicationData;
import model.PassTransactions;
import model.StudentDocuments;

public class PassDAO {

	static Connection con;
	ResultSet rs;
	boolean b;

	public int passApplication(List<ApplicationData> appDataList) {

		int i = 0;
		con = DataSource.getConnection();

		ApplicationData appData = appDataList.get(0);

		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into pass_applications values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, appData.getApplicationID());
			ps.setString(2, appData.getUserName());
			ps.setString(3, appData.getDob());
			ps.setString(4, appData.getUserAge());
			ps.setString(5, appData.getUserMobile());
			ps.setString(6, appData.getUserMail());
			ps.setString(7, appData.getUserVillage());
			ps.setString(8, appData.getUserPincode());
			ps.setString(9, appData.getCitizenType());
			ps.setString(10, appData.getPassRouteType());
			ps.setString(11, appData.getPassType());
			ps.setString(12, appData.getPassFrom());
			ps.setString(13, appData.getPassTo());
			ps.setString(14, appData.getBoarding());
			ps.setString(15, appData.getDestination());
			ps.setString(16, appData.getInstiName());
			ps.setString(17, appData.getInstiLocation());
			ps.setString(18, appData.getInstiPincode());
			ps.setString(19, appData.getCourseName());
			ps.setString(20, appData.getCourseDuration());
			ps.setString(21, appData.getApprovalNo());
			ps.setString(22, appData.getStatus());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public List<ApplicationData> getAllApplications() {

		System.out.println("In getAllApplication()");
		List<ApplicationData> appDataList = new LinkedList<ApplicationData>();

		if (con == null) {
			con = DataSource.getConnection();
		}

		try {
			Statement s = con.createStatement();
			rs = s.executeQuery("select * from pass_applications where status='Applied'");

			while (rs.next()) {

				ApplicationData appData = new ApplicationData();
				appData.setApplicationID(rs.getString("APPLICATION_ID"));
				appData.setUserName(rs.getString("USER_NAME"));
				appData.setDob(rs.getString("DOB"));
				appData.setUserAge(rs.getString("USER_AGE"));
				appData.setUserMobile(rs.getString("USER_MOBILE"));
				appData.setUserMail(rs.getString("USER_MAIL"));
				appData.setUserVillage(rs.getString("USER_VILLAGE"));
				appData.setUserPincode(rs.getString("USER_PINCODE"));
				appData.setCitizenType(rs.getString("CITIZEN_TYPE"));
				appData.setPassRouteType(rs.getString("PASS_ROUTE_TYPE"));
				appData.setPassType(rs.getString("PASS_TYPE"));
				appData.setPassFrom(rs.getString("PASS_FROM"));
				appData.setPassTo(rs.getString("PASS_TO"));
				appData.setBoarding(rs.getString("BOARDING"));
				appData.setDestination(rs.getString("DESTINATION"));
				appData.setInstiName(rs.getString("INSTI_NAME"));
				appData.setInstiLocation(rs.getString("INSTI_LOCATION"));
				appData.setInstiPincode(rs.getString("INSTI_PINCODE"));
				appData.setCourseName(rs.getString("COURSE_NAME"));
				appData.setCourseDuration(rs.getString("COURSE_DURATION"));
				appData.setApprovalNo(rs.getString("APPROVAL_NO"));
				appData.setStatus(rs.getString("STATUS"));

				appDataList.add(appData);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return appDataList;

	}

	public int studentDocs(List<StudentDocuments> sdList) {

		int i = 0;
		StudentDocuments sd = sdList.get(0);

		if (con == null) {
			con = DataSource.getConnection();
		}

		try {
			PreparedStatement ps = con.prepareStatement("insert into student_documents values(?,?,?,?,?,?)");
			ps.setString(2, sd.getFn_photo());
			ps.setString(3, sd.getFn_bonafide());
			ps.setString(4, sd.getFn_lightbill());
			ps.setString(5, sd.getFn_feeReceipt());
			ps.setString(6, sd.getFn_aadhaar());
			ps.setString(1, sd.getApplication_id());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public List<StudentDocuments> getApplicantDocs() {

		System.out.println("In getApplicantDocs()");

		List<StudentDocuments> docList = new LinkedList<StudentDocuments>();

		if (con == null) {

			con = DataSource.getConnection();
		}

		try {
			Statement s = con.createStatement();
			rs = s.executeQuery("select * from student_documents");

			while (rs.next()) {

				StudentDocuments docs = new StudentDocuments();
				docs.setApplication_id(rs.getString("APPLICATION_ID"));
				docs.setFn_photo(rs.getString("PHOTO"));
				docs.setFn_bonafide(rs.getString("BONAFIDE"));
				docs.setFn_lightbill(rs.getString("LIGHTBILL"));
				docs.setFn_feeReceipt(rs.getString("FEERECEIPT"));
				docs.setFn_aadhaar(rs.getString("AADHAAR"));

				docList.add(docs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return docList;
	}

	public int approveApplication(String appID) {
		int i = 0;

		if (con == null) {

			con = DataSource.getConnection();
		}

		try {
			PreparedStatement ps = con.prepareStatement("UPDATE pass_applications SET STATUS = 'Approved' WHERE APPLICATION_ID = ? ");
			ps.setString(1, appID);

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int rejectApplication(String appID) {
		int i = 0;

		if (con == null) {

			con = DataSource.getConnection();
		}
		
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE pass_applications SET STATUS = 'Rejected' WHERE APPLICATION_ID = ? ");
			ps.setString(1, appID);

			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return i;
	}
	
	public List<ApplicationData> getUserApplication() {

		System.out.println("In getUserApplication()");
		List<ApplicationData> appDataList = new LinkedList<ApplicationData>();

		if (con == null) {
			con = DataSource.getConnection();
		}

		try {
			Statement s = con.createStatement();
			rs = s.executeQuery("select * from pass_applications");

			while (rs.next()) {

				ApplicationData appData = new ApplicationData();
				appData.setApplicationID(rs.getString("APPLICATION_ID"));
				appData.setUserName(rs.getString("USER_NAME"));
				appData.setDob(rs.getString("DOB"));
				appData.setUserAge(rs.getString("USER_AGE"));
				appData.setUserMobile(rs.getString("USER_MOBILE"));
				appData.setUserMail(rs.getString("USER_MAIL"));
				appData.setUserVillage(rs.getString("USER_VILLAGE"));
				appData.setUserPincode(rs.getString("USER_PINCODE"));
				appData.setCitizenType(rs.getString("CITIZEN_TYPE"));
				appData.setPassRouteType(rs.getString("PASS_ROUTE_TYPE"));
				appData.setPassType(rs.getString("PASS_TYPE"));
				appData.setPassFrom(rs.getString("PASS_FROM"));
				appData.setPassTo(rs.getString("PASS_TO"));
				appData.setBoarding(rs.getString("BOARDING"));
				appData.setDestination(rs.getString("DESTINATION"));
				appData.setInstiName(rs.getString("INSTI_NAME"));
				appData.setInstiLocation(rs.getString("INSTI_LOCATION"));
				appData.setInstiPincode(rs.getString("INSTI_PINCODE"));
				appData.setCourseName(rs.getString("COURSE_NAME"));
				appData.setCourseDuration(rs.getString("COURSE_DURATION"));
				appData.setApprovalNo(rs.getString("APPROVAL_NO"));
				appData.setStatus(rs.getString("STATUS"));

				appDataList.add(appData);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return appDataList;
	}

	public int statusComplete(String appID) {

		int i=0;
		if(con==null) {
			con=DataSource.getConnection();
		}
		
		try {
			PreparedStatement ps=con.prepareStatement("update pass_applications set status='Completed' where APPLICATION_ID= ?");
			ps.setString(1, appID);
			i=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int passTransaction(List<PassTransactions> ptList) {

		int i=0;
		if(con.equals(null)) {
			con=DataSource.getConnection();
		}
		
		PassTransactions pt=ptList.get(0);
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into pass_transactions values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pt.getPassId());
			ps.setString(2, pt.getPassType());
			ps.setString(3, pt.getUserMob());
			ps.setString(4, pt.getDate());
			ps.setString(5,pt.getPassRouteType());
			ps.setString(6,pt.getAmount());
			ps.setString(7,pt.getPay_id());
			ps.setString(8,pt.getOrder_id());
			ps.setString(9, pt.getRzp_sign());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<PassTransactions> getTransactions(String userMobile) {

		List<PassTransactions> ptList=new ArrayList<>();
		
		int i=0;
		
		if(con==null) {
			con=DataSource.getConnection();
		}
		
		try {
			Statement s=con.createStatement();
			rs=s.executeQuery("select * from pass_transactions where user_mob="+userMobile);
			
			while(rs.next()) {
				PassTransactions pt=new PassTransactions();
				pt.setPassId(rs.getString("PASS_ID"));
				pt.setPassType(rs.getString("PASS_TYPE"));
				pt.setUserMob(rs.getString("USER_MOB"));
				pt.setDate(rs.getString("PASS_DATE"));
				pt.setPassRouteType(rs.getString("PASS_ROUTE_TYPE"));
				pt.setAmount(rs.getString("AMOUNT"));
				pt.setPay_id(rs.getString("PAY_ID"));
				pt.setOrder_id(rs.getString("ORDER_ID"));
				pt.setRzp_sign(rs.getString("RZP_SIGN"));
				
				ptList.add(pt);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ptList;
	}

	/*
	 * public ApplicationData getApplication(String userMobile) {
	 * 
	 * ApplicationData appData=new ApplicationData();
	 * 
	 * List<ApplicationData> appList=new LinkedList<ApplicationData>();
	 * 
	 * appList=getUserApplication();
	 * 
	 * if(appList.isEmpty()) { System.out.println("Application List Empty"); }
	 * 
	 * for (ApplicationData applicationData : appList) {
	 * 
	 * if(applicationData.getUserMobile().equals(userMobile)) {
	 * 
	 * System.out.println("Application Found");
	 * 
	 * appData.setApplicationID(applicationData.getApplicationID());
	 * appData.setUserName(applicationData.getUserName());
	 * appData.setDob(applicationData.getDob());
	 * appData.setUserAge(applicationData.getUserAge());
	 * appData.setUserMobile(applicationData.getUserMobile());
	 * appData.setUserMail(applicationData.getUserMail());
	 * appData.setUserVillage(applicationData.getUserVillage());
	 * appData.setUserPincode(applicationData.getUserPincode());
	 * appData.setCitizenType(applicationData.getCitizenType());
	 * appData.setPassRouteType(applicationData.getPassRouteType());
	 * appData.setPassType(applicationData.getPassType());
	 * appData.setPassFrom(applicationData.getPassFrom());
	 * appData.setPassTo(applicationData.getPassTo());
	 * appData.setBoarding(applicationData.getBoarding());
	 * appData.setDestination(applicationData.getDestination());
	 * appData.setInstiName(applicationData.getInstiName());
	 * appData.setInstiLocation(applicationData.getInstiLocation());
	 * appData.setInstiPincode(applicationData.getInstiPincode());
	 * appData.setCourseName(applicationData.getCourseName());
	 * appData.setCourseDuration(applicationData.getCourseDuration());
	 * appData.setApprovalNo(applicationData.getApprovalNo());
	 * appData.setStatus(applicationData.getStatus());
	 * 
	 * break; } }
	 * 
	 * return appData;
	 * 
	 * }
	 */
}
