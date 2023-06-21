package controller;

import java.io.IOException;
import java.util.List;

import dao.PassDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.PassTransactions;

/**
 * Servlet implementation class TransactionController
 */
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userMobile=request.getParameter("userMobile");
		
		PassDAO passDAO=new PassDAO();	
		
		List<PassTransactions> ptList=passDAO.getTransactions(userMobile);
		
		if(ptList.isEmpty()) {
			System.out.println("NO transactions Found");
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("Pass_Transactions",ptList);
		response.sendRedirect("ViewTransactions.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
