package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DayPass;

/**
 * Servlet implementation class DialyPassController
 */
public class DialyPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		  String govID,gender,area,amount="0",passId,date,time;
		  String pmcArea="PMC",pcmcArea="PCMC";
		  
		  govID=request.getParameter("govIdNo"); 
		  gender=request.getParameter("gender");
		  area=request.getParameter("area");
		  LocalDate localDate=LocalDate.now();
		  date=localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		  
		  LocalTime currentTime=LocalTime.now();
		  time=currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		  passId=generatePassId();
		  
		  if(area.equals(pmcArea)){
		  
		  amount="40"; 
		  }else if(area.equals(pcmcArea)){ 
			  amount="50"; }
		  
		  System.out.println("Gov ID :" +govID+" Gender :"+gender+" Area :"+area+" Pass ID :"+passId+" Amount :"+amount);
		  
		  DayPass dPass=new DayPass(govID, gender, area, amount, passId, date, time);
		  
		  HttpSession session=request.getSession();
		  session.setAttribute("DayPass", dPass);
		  
		  response.sendRedirect("DayPassConfirmation.jsp");
		  
		  		 
		  
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String generatePassId() {
        int length = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder passId = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            passId.append(characters.charAt(index));
        }

        return passId.toString();
    }


}
