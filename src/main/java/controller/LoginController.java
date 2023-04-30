package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.RegistrationDAO;
import model.UserLogin;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String userMobile,userPassword;
		
		userMobile=request.getParameter("userMobile");
		userPassword=request.getParameter("userPassword");
		System.out.println(userMobile+userPassword);
		
		UserLogin user=new UserLogin(userMobile, userPassword);

		RegistrationDAO regDAO=new RegistrationDAO();
		
		boolean b= regDAO.validateUser(user);
		
		if(b) {
			
			response.sendRedirect("UserDashboard.jsp");
			
		}else {
			
			response.sendRedirect("UserLogin.jsp");
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
