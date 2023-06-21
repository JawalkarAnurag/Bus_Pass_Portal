package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PassDAO;
import jakarta.servlet.http.HttpSession;
import model.ApplicationData;

public class UserPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("IN userpassController");
		
		HttpSession session=request.getSession();
		String applied ="Applied",approved="Approved";
		
		String userMob=(String)session.getAttribute("userMobile");
		System.out.println("In userPassController");
		
		System.out.println(userMob);
		
		PassDAO passDAO=new PassDAO();
		
		List<ApplicationData> userAppList=new ArrayList<>();
		
		
		List<ApplicationData> appList=passDAO.getUserApplication();
		
		
		
		for (ApplicationData applicationData : appList) {
			
			System.out.println("Application Mob :"+applicationData.getUserMobile());
			System.out.println("User Mob :"+userMob);
			
			if(applicationData.getUserMobile().equals(userMob)) {
				
				userAppList.add(applicationData);
			}
		}
		
		
		session.setAttribute("UserApplications", userAppList);
		
		response.sendRedirect("UserDashboard.jsp");
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
