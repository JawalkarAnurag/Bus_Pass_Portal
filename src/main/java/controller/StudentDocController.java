package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.PassDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.StudentDocuments;
@MultipartConfig
/**
 * Servlet implementation class StudentDocController
 */
public class StudentDocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Part userPhoto,bonafide,lightbill,feeReceipt,aadhaar;
		String application_id, fn_photo,fn_bonafide,fn_lightbill,fn_feeReceipt,fn_aadhaar;
		
		application_id=request.getParameter("application_id");
		
		userPhoto=request.getPart("user_photo");
		bonafide=request.getPart("bonafide");
		lightbill=request.getPart("lightBill");
		feeReceipt=request.getPart("feeReceipt");
		aadhaar=request.getPart("aadhaarCard");
		 HttpSession session= request.getSession();
		
		 String citizenType=(String)session.getAttribute("citizenType");
		System.out.println(citizenType);
		
		if(citizenType=="Student") {
			fn_bonafide=bonafide.getSubmittedFileName();
			fn_feeReceipt=feeReceipt.getSubmittedFileName();
				
		}else {
			fn_bonafide="N/A";
			fn_feeReceipt="N/A";
			
		}
		fn_photo=userPhoto.getSubmittedFileName();
		fn_lightbill=lightbill.getSubmittedFileName();
		fn_aadhaar=aadhaar.getSubmittedFileName();
		
		
		
		StudentDocuments sd=new StudentDocuments(application_id, fn_photo, fn_bonafide, fn_lightbill, fn_feeReceipt, fn_aadhaar);
		
		List<StudentDocuments> sdList=new ArrayList<StudentDocuments>();
		sdList.add(sd);
		
		PassDAO passDAO=new PassDAO();
		int i=passDAO.studentDocs(sdList);
		
		if(i>0) {
			
			
			 
			String path=getServletContext().getRealPath("")+"image";
			 File file=new File(path);
			 System.out.println(path);
			 userPhoto.write(path+File.separator+fn_photo);
			
			 if(citizenType=="Student") {
			
				 bonafide.write(path+File.separator+fn_bonafide);
				 feeReceipt.write(path+File.separator+fn_feeReceipt);
				 
			 }
			 
			 lightbill.write(path+File.separator+fn_lightbill);
			 aadhaar.write(path+File.separator+fn_aadhaar);
			 
			
			 session.setAttribute("stud_doc_uploaded", "true");
			 
			 response.sendRedirect("UserPassController");
			
			 
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
