package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.PassDAO;

public class ApproveAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String appID=request.getParameter("appID");
		String action="Approved";
		
		PassDAO passDAO=new PassDAO();
		
		HttpSession session=request.getSession();
		
		int i=passDAO.approveApplication(appID);
	
		if(i>0) {
			
			session.setAttribute("AdminAction", action);
			response.sendRedirect("ApplicationListController");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
