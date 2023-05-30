package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import dao.PassDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ApplicationData;
import model.StudentDocuments;

public class ViewApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String appID=request.getParameter("appID");
		System.out.println(appID);
		
		PassDAO passDAO=new PassDAO();
		
		List<ApplicationData> appList=new LinkedList<ApplicationData>();
		appList=passDAO.getAllApplications();
		
		if(appList.isEmpty()) {
			System.out.println("List is empty");
			response.sendRedirect("AdminDashboard.jsp");
		}
		
		ApplicationData appData=new ApplicationData();
		
		HttpSession session=request.getSession();
		
		for (ApplicationData applicationData : appList) {
			if (applicationData.getApplicationID().equals(appID)) {
				
				System.out.println("Application Found");
				
				appData.setApplicationID(applicationData.getApplicationID());
				appData.setUserName(applicationData.getUserName());
				appData.setDob(applicationData.getDob());
				appData.setUserAge(applicationData.getUserAge());
				appData.setUserMobile(applicationData.getUserMobile());
				appData.setUserMail(applicationData.getUserMail());
				appData.setUserVillage(applicationData.getUserVillage());
				appData.setUserPincode(applicationData.getUserPincode());
				appData.setCitizenType(applicationData.getCitizenType());
				appData.setPassRouteType(applicationData.getPassRouteType());
				appData.setPassType(applicationData.getPassType());
				appData.setPassFrom(applicationData.getPassFrom());
				appData.setPassTo(applicationData.getPassTo());
				appData.setBoarding(applicationData.getBoarding());
				appData.setDestination(applicationData.getDestination());
				appData.setInstiName(applicationData.getInstiName());
				appData.setInstiLocation(applicationData.getInstiLocation());
				appData.setInstiPincode(applicationData.getInstiPincode());
				appData.setCourseName(applicationData.getCourseName());
				appData.setCourseDuration(applicationData.getCourseDuration());
				appData.setApprovalNo(applicationData.getApprovalNo());
				appData.setStatus(applicationData.getStatus());
			
				session.setAttribute("ApplicantData", appData);
				
				break;
			}
		}
		
		
		
		
		List<StudentDocuments> docList=new LinkedList<StudentDocuments>();
		docList=passDAO.getApplicantDocs();
		
		if(docList.isEmpty()) {
			
			System.out.println("Document List empty");
			response.sendRedirect("AdminDashboard.jsp");
		}
		StudentDocuments applicant_docs=new StudentDocuments();
		
		for (StudentDocuments studentDocuments : docList) {
			if (studentDocuments.getApplication_id().equals(appID)) {
				
				System.out.println("Applicant documents found");
				
				applicant_docs.setApplication_id(studentDocuments.getApplication_id());
				applicant_docs.setFn_aadhaar(studentDocuments.getFn_aadhaar());
				applicant_docs.setFn_photo(studentDocuments.getFn_photo());
				applicant_docs.setFn_lightbill(studentDocuments.getFn_lightbill());
				applicant_docs.setFn_feeReceipt(studentDocuments.getFn_feeReceipt());
				applicant_docs.setFn_bonafide(studentDocuments.getFn_bonafide());

				session.setAttribute("ApplicantDocs", applicant_docs);

				break;
			}
			
		}
		
		
		response.sendRedirect("ViewApplication.jsp");
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
