   package controller;

import java.io.IOException;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentController
 */
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 System.out.println(" IN payment Controller");
			 int amount=Integer.parseInt(request.getParameter("amount"));
	            
			 RazorpayClient razorpayClient = new RazorpayClient("rzp_test_rk7RvIPUGSCeip", "x8pIbULR1OUqF3LBWwJCcZlE");

	            // Create a Map of payment parameters
			 JSONObject orderRequest = new JSONObject();
			 orderRequest.put("amount", amount*100); // amount in the smallest currency unit
			 orderRequest.put("currency", "INR");
			 orderRequest.put("receipt", "order_rcptid_11");

			 // Create a Razorpay order
			 Order order = razorpayClient.orders.create(orderRequest);

	          

	            // Get the order ID
	            String orderId = order.get("id");

	            // Send the order ID back to the client-side
	            response.getWriter().write(orderId);
	        } catch (RazorpayException e) {
	            // Handle Razorpay API exception
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        }
	}

}
