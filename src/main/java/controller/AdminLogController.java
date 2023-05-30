package controller;

import java.io.IOException;

import dao.RegistrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AdminLogin;
import model.AdminRegistration;

/**
 * Servlet implementation class AdminLogController
 */
public class AdminLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		String adminID,adminPassword;
    		
    		adminID=request.getParameter("adminID");
    		adminPassword=request.getParameter("adminPassword");
    		
    		AdminLogin adlog=new AdminLogin(adminID, adminPassword);
    		
    		RegistrationDAO regDAO=new RegistrationDAO();
    		boolean b=regDAO.validateAdmin(adlog);
    		
    		if (b) {
    			AdminRegistration adreg=regDAO.getAdmin(adlog);
    			
    			HttpSession session=request.getSession();
    			session.setAttribute("adminName",adreg.getAdminName() );
    			session.setAttribute("adminID",adreg.getAdminID() );
    			
				response.sendRedirect("ApplicationListController");
			}else {
				response.sendRedirect("AdminLogin.jsp");
			}
    		
    		
    	}



    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
