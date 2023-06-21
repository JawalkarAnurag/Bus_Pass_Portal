package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PassDAO;
import jakarta.servlet.http.HttpSession;
import model.ApplicationData;
import model.PassTransactions;
import model.StudentDocuments;

/**
 * Servlet implementation class PassSuccessController
 */
public class PassSuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String appID = request.getParameter("appID");
		String date,single_route="single_route",student="Student";
		PassDAO passDAO = new PassDAO();

		int i = passDAO.statusComplete(appID);
		
		if(i>0) {
			System.out.println("Status Changed to completed");
		}

		String amount = request.getParameter("amount");

		LocalDate localDate = LocalDate.now();
		date = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		String pay_id = request.getParameter("pay_id");
		String order_id = request.getParameter("order_id");
		String rzp_sign = request.getParameter("rzp_sign");

		String passId = generatePassId();

		List<ApplicationData> appDataList = passDAO.getUserApplication();

		ApplicationData appData = new ApplicationData();

		for (ApplicationData applicationData : appDataList) {
			if (applicationData.getApplicationID().equals(appID)) {

				appData.setApplicationID(applicationData.getApplicationID());
				appData.setUserName(applicationData.getUserName());
				appData.setDob(applicationData.getDob());
				appData.setUserAge(applicationData.getUserAge());
				appData.setUserMobile(applicationData.getUserMobile());
				appData.setUserMail(applicationData.getUserMail());
				appData.setUserVillage(applicationData.getUserVillage());
				appData.setUserPincode(applicationData.getUserPincode());
				appData.setCitizenType(applicationData.getCitizenType());
				appData.setPassRouteType(applicationData.getPassRouteType());
				appData.setPassType(applicationData.getPassType());
				appData.setPassFrom(applicationData.getPassFrom());
				appData.setPassTo(applicationData.getPassTo());
				appData.setBoarding(applicationData.getBoarding());
				appData.setDestination(applicationData.getDestination());
				appData.setInstiName(applicationData.getInstiName());
				appData.setInstiLocation(applicationData.getInstiLocation());
				appData.setInstiPincode(applicationData.getInstiPincode());
				appData.setCourseName(applicationData.getCourseName());
				appData.setCourseDuration(applicationData.getCourseDuration());
				appData.setApprovalNo(applicationData.getApprovalNo());
				appData.setStatus(applicationData.getStatus());

				session.setAttribute("PassApplicantData", appData);
				break;
			}
		}

		PassTransactions pt = new PassTransactions(passId, appData.getPassType(), appData.getUserMobile(), date,
				appData.getPassRouteType(), amount, pay_id, order_id, rzp_sign);

		List<PassTransactions> ptList = new ArrayList<>();
		ptList.add(pt);

		int j = passDAO.passTransaction(ptList);

		if (j > 0) {
			System.out.println("Transaction Stored");
		} else {
			System.out.println("Failed to store in DB");
		}
		

		List<StudentDocuments> docList=new LinkedList<StudentDocuments>();
		docList=passDAO.getApplicantDocs();
		
		if(docList.isEmpty()) {
			
			System.out.println("Document List empty");
			response.sendRedirect("AdminDashboard.jsp");
		}
		StudentDocuments applicant_docs=new StudentDocuments();
		
		for (StudentDocuments studentDocuments : docList) {
			if (studentDocuments.getApplication_id().equals(appID)) {
				
				System.out.println("Applicant documents found");
				
				applicant_docs.setApplication_id(studentDocuments.getApplication_id());
				applicant_docs.setFn_aadhaar(studentDocuments.getFn_aadhaar());
				applicant_docs.setFn_photo(studentDocuments.getFn_photo());
				applicant_docs.setFn_lightbill(studentDocuments.getFn_lightbill());
				applicant_docs.setFn_feeReceipt(studentDocuments.getFn_feeReceipt());
				applicant_docs.setFn_bonafide(studentDocuments.getFn_bonafide());

				session.setAttribute("ApplicantDocs", applicant_docs);

				break;
			}
			
		}


		String filename = pt.getPassId() + ".pdf";

		try {
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=PMPML_Pass_" + filename);

			Document document = new Document();
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

			Image image = Image.getInstance("C:/Users/Captain/Desktop/pmpml_logo.png"); // Specify the path to your
																						// image file
			image.setAlignment(Element.ALIGN_CENTER);
			image.scaleToFit(100, 150); // Adjust the image size as needed
			document.add(image);

			Paragraph header = new Paragraph("Pune Mahanagar Parivahan Mahamandal Limited (PMPML)",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
			header.setAlignment(Element.ALIGN_CENTER);
			document.add(header);

			document.add(new Paragraph(" "));

			Image photo = Image.getInstance("C:/Users/Captain/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/busPassPortal/image/"+applicant_docs.getFn_photo()); 
			photo.setAlignment(Element.ALIGN_CENTER);
			photo.scaleToFit(100, 150); // Adjust the image size as needed
			document.add(photo);

			document.add(new Paragraph(" "));
			
			// Create table for data
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100);

			// Add rows to the table

			addTableRow(table, "Name", appData.getUserName());
			addTableRow(table, "Citizen Type", appData.getCitizenType());
			addTableRow(table, "Pass Type", appData.getPassType());
			addTableRow(table, "Age", appData.getUserAge());
			addTableRow(table, "Valid From ",appData.getPassFrom());
			addTableRow(table, "valid To ", appData.getPassTo());
			addTableRow(table, "Pass Route Type", appData.getPassRouteType());

			if(appData.getPassRouteType().equals(single_route)) {
				addTableRow(table,"Boarding",appData.getBoarding());
				addTableRow(table, "Destination ", appData.getDestination());
			}
			
			if(appData.getCitizenType().equals(student)) {
				addTableRow(table,"Institute Name",appData.getInstiName());
				addTableRow(table, "Course Name", appData.getCourseName());
				addTableRow(table, "Government Approval ", appData.getApprovalNo());
				
			}
			addTableRow(table, "Amount", pt.getAmount()+"INR");

			// Add the table to the document
			document.add(table);

			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		response.sendRedirect("UserPassController");

	}

	private void addTableRow(PdfPTable table, String label, String value) {
		PdfPCell cellLabel = new PdfPCell(new Phrase(label));
		PdfPCell cellValue = new PdfPCell(new Phrase(value));
		table.addCell(cellLabel);
		table.addCell(cellValue);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
