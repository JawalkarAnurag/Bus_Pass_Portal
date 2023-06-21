package controller;

import java.io.IOException;

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
import jakarta.servlet.http.HttpSession;
import model.DayPass;




/**
 * Servlet implementation class PaymentSuccessController
 */
public class PaymentSuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSuccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		//String amount=request.getParameter("amount");
		String pay_id=request.getParameter("pay_id");
		String order_id=request.getParameter("order_id");
		String rzp_sign=request.getParameter("rzp_sign");
		
		System.out.println(pay_id+"  "+order_id+"   "+rzp_sign );
		
		DayPass pass= (DayPass)session.getAttribute("DayPass");
		
		String filename=(pass.getPassId()+".pdf");
		
		
        try {
        	response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Day_Pass_" + filename);
            
            Document document = new Document();
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			 
			 Image image = Image.getInstance("C:/Users/Captain/Desktop/pmpml_logo.png"); // Specify the path to your image file
		        image.setAlignment(Element.ALIGN_CENTER);
		        image.scaleToFit(200, 200); // Adjust the image size as needed
		        document.add(image);

			
			 Paragraph header = new Paragraph("Pune Mahanagar Parivahan Mahamandal Limited (PMPML)",
	                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
	            header.setAlignment(Element.ALIGN_CENTER);
	            document.add(header);
	            
	            document.add(new Paragraph(" ")); 

	            // Create table for data
	            PdfPTable table = new PdfPTable(2);
	            table.setWidthPercentage(100);

	            // Add rows to the table
	            addTableRow(table, "Pass ID", pass.getPassId());
	            addTableRow(table, "Pass Type", "Day Pass");
	            addTableRow(table, "Date ", pass.getDate());
	            addTableRow(table, "Time ", pass.getTime());
	            addTableRow(table, "Government ID", pass.getGovID());
	            addTableRow(table, "Gender", pass.getGender());
	            addTableRow(table, "Pass Route Type", pass.getArea());
	            addTableRow(table, "Amount", pass.getAmount());
	            

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
	}
        private void addTableRow(PdfPTable table, String label, String value) {
            PdfPCell cellLabel = new PdfPCell(new Phrase(label));
            PdfPCell cellValue = new PdfPCell(new Phrase(value));
            table.addCell(cellLabel);
            table.addCell(cellValue);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
