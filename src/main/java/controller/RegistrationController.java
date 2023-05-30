 package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import dao.RegistrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.UserRegistration;

@MultipartConfig
/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 String userName,userMail,userMobile,userPassword;
	 String filename;
	 Part p;
	 
	 userName=request.getParameter("userName");
	 userMail=request.getParameter("userMail");
	 userMobile=request.getParameter("userMobile");
	 userPassword=request.getParameter("userPassword");
	 
	 
	 System.out.println(userName+" "+userMail+" "+userMobile+" "+userPassword);
	 
	 UserRegistration user =new UserRegistration();
	 user.setUserName(userName);
	 user.setUserMail(userMail);
	 user.setUserMobile(userMobile);
	 user.setUserPassword(userPassword);
	 
	 List<UserRegistration> userList=new ArrayList<UserRegistration>();
	 userList.add(user);
	 
	 RegistrationDAO regdao=new RegistrationDAO();
	 int i =regdao.register(userList);
	 
	 if(i>0){
		 
		 response.sendRedirect("UserLogin.jsp");
		 
	 }else {
		 System.out.println("error");
		 
	 }
	 
	 
	 
 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
