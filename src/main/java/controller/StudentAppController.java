package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dao.PassDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ApplicationData;

/**
 * Servlet implementation class StudentAppController
 */
public class StudentAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName,dob,userAge,userMobile,userMail,userVillage,userPincode,citizenType;
		String instiName,instiLocation,instiPincode,courseName,courseDuration,approvalNo;
		String passRouteType,passFrom,passTo,boarding,destination,applicationID,passType,status;
		
		String applied="Applied";
		userName=request.getParameter("userName");
		dob=request.getParameter("dob");
		userAge=request.getParameter("userAge");
		userMobile=request.getParameter("userMobile");
		userMail=request.getParameter("userMail");
		userVillage=request.getParameter("userVillage");
		userPincode=request.getParameter("userPincode");
		
		HttpSession session=request.getSession();
		citizenType=(String)session.getAttribute("citizenType");
		passType=(String)session.getAttribute("passType");
		
		System.out.println(passType);
		
		System.out.println(userName+dob+userAge+userMobile+userMail+userVillage+userPincode);
		
		instiName=request.getParameter("insti_name");
		instiLocation=request.getParameter("insti_location");
		instiPincode=request.getParameter("insti_pincode");
		courseName=request.getParameter("courseName");
		courseDuration=request.getParameter("courseDuration");
		approvalNo=request.getParameter("approvalNo");
		
		System.out.println(instiName+instiLocation+instiPincode+courseName+courseDuration+approvalNo);
		
		passRouteType=request.getParameter("passRouteType");
		passFrom=request.getParameter("passFrom");
		passTo=request.getParameter("passTo");
		boarding=request.getParameter("board");
		destination=request.getParameter("destination");
		applicationID= UUID.randomUUID().toString();
		status=applied;
		
		System.out.println(applicationID+passRouteType+passFrom+passTo+boarding+destination);
		
		ApplicationData appData=new ApplicationData(userName, dob, userAge, userMobile, userMail, userVillage, userPincode, citizenType, instiName, instiLocation, instiPincode, courseName, courseDuration, approvalNo, passRouteType, passFrom, passTo, boarding, destination, applicationID, passType, status);
		List<ApplicationData> appDataList=new ArrayList<ApplicationData>();
		appDataList.add(appData);
		
		PassDAO passDAO=new PassDAO();
		int i=passDAO.passApplication(appDataList);
		
		
		
		
		if(i>0) {
			
			session.setAttribute("applicationID", applicationID);
			response.sendRedirect("StudentDocuments.jsp");
		}else {
			response.sendRedirect("StudentApplicationForm.jsp");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
