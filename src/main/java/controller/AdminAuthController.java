package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminAuthController
 */
public class AdminAuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String authCode,adminCode;
		
		adminCode="pmpmladmin123";
		
		
		authCode=request.getParameter("authcodeinput");
		System.out.println(authCode);
		
		if (authCode.equals(adminCode)) {
			response.sendRedirect("AdminRegistration.jsp");
		}else {
			response.sendRedirect("AdminAuthentication.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
