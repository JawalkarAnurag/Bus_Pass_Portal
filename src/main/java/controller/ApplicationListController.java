package controller;

import java.io.IOException;
import java.util.List;

import dao.PassDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ApplicationData;

/**
 * Servlet implementation class ApplicationListController
 */
public class ApplicationListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PassDAO passDAO=new PassDAO();
		
		List<ApplicationData> appDataList=passDAO.getAllApplications();
		
		for (ApplicationData applicationData : appDataList) {
			System.out.println(applicationData.getUserName());
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("applications",appDataList);
		
		response.sendRedirect("AdminDashboard.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
