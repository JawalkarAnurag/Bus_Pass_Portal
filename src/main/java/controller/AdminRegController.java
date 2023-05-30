package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.RegistrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminRegistration;



/**
 * Servlet implementation class AdminRegController
 */
public class AdminRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String adminName,adminID,adminMobile,adminMail,adminPassword;
		
		adminName=request.getParameter("adminName");
		adminID=request.getParameter("adminID");
		adminMobile=request.getParameter("adminMobile");
		adminMail=request.getParameter("adminMail");
		adminPassword=request.getParameter("adminPassword");
		
		AdminRegistration adReg=new AdminRegistration(adminName, adminID, adminMobile, adminMail, adminPassword);
		
		List<AdminRegistration> adRegList=new ArrayList<AdminRegistration>();
		adRegList.add(adReg);
		
		RegistrationDAO regDAO=new RegistrationDAO();
		int i=regDAO.registerAdmin(adRegList);
		
		if(i>0) {
			
			response.sendRedirect("AdminLogin.jsp");
			
		}else {
			response.sendRedirect("AdminRegistration.jsp");
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
