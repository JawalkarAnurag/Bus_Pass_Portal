
<%@page import="model.StudentDocuments"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ApplicationData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include\head.jsp"%>
<title>Pass Application</title>
<%@ include file="include\NavCss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


</head>
<body>
	<%!String adminName = null;
	String single_route = "single_route", student = "Student";
	String adminID = null;
	ApplicationData appData = new ApplicationData();
	StudentDocuments appDocs=new StudentDocuments();
	%>

	<%@ include file="include\AdminNavbar.jsp"%>

	<%
	adminName = (String) session.getAttribute("adminName");
	adminID = (String) session.getAttribute("adminID");
	appData = (ApplicationData) session.getAttribute("ApplicantData");
	appDocs=(StudentDocuments)session.getAttribute("ApplicantDocs");
	%>

	<div class="drawer ">
		<h5>
			Admin ID:<%=adminID%></h5>

		<button class="btn btn-success btn-block" onclick="appList()">Application
			List</button>
		<button class="btn btn-success btn-block">Logout</button>


	</div>


	<!-- Main Content -->
	<div class="content ">
		<div class="container mx-auto">
			<h3 id="personal_info" class="text-center bg-success text-light p-2">Pass
				Application</h3>
			<div class="text-center">
				<img alt="Applicant_img" src="image/<%=appDocs.getFn_photo() %>" width="100">
			</div>

			<div class="row justify-content-center">
				<div class="col-md-8 mx-auto">
					<table class="table table-bordered table-striped">
						<tbody>
							<tr>
								<th scope="row">Applicant Name</th>
								<td><%=appData.getUserName()%></td>
							</tr>
							<tr>
								<th scope="row">Applicant DOB</th>
								<td><%=appData.getDob()%></td>
							</tr>
							<tr>
								<th scope="row">Applicant Age</th>
								<td><%=appData.getUserAge()%></td>
							</tr>
							<tr>
								<th scope="row">Applicant Mobile</th>
								<td><%=appData.getUserMobile()%></td>
							</tr>
							<tr>
								<th scope="row">Applicant E-mail</th>
								<td><%=appData.getUserMail()%></td>
							</tr>
							<tr>
								<th scope="row">Applicant Location</th>
								<td><%=appData.getUserVillage()%></td>
							</tr>
							<tr>
								<th scope="row">Applicant Pincode</th>
								<td><%=appData.getUserPincode()%></td>
							</tr>
							<tr>
								<th scope="row">Citizen Type</th>
								<td><%=appData.getCitizenType()%></td>
							</tr>
							<tr>
								<th scope="row">Pass Route Type</th>
								<td><%=appData.getPassRouteType()%></td>
							</tr>
							<tr>
								<th scope="row">Pass From</th>
								<td><%=appData.getPassFrom()%></td>
							</tr>
							<tr>
								<th scope="row">Pass To</th>
								<td><%=appData.getPassTo()%></td>
							</tr>
							<%
							if (appData.getPassRouteType().equals(single_route)) {
							%>
							<tr>
								<th scope="row">Bus Boarding</th>
								<td><%=appData.getBoarding()%></td>
							</tr>
							<tr>
								<th scope="row">Bus Destination</th>
								<td><%=appData.getDestination()%></td>
							</tr>
							<%
							}
							%>
							<%
							if (appData.getCitizenType().equals(student)) {
							%>
							<tr>
								<th scope="row">Institute Name</th>
								<td><%=appData.getInstiName()%></td>
							</tr>
							<tr>
								<th scope="row">Institute Location</th>
								<td><%=appData.getInstiLocation()%></td>
							</tr>
							<tr>
								<th scope="row">Institute Pincode</th>
								<td><%=appData.getInstiPincode()%></td>
							</tr>
							<tr>
								<th scope="row">Course Name</th>
								<td><%=appData.getCourseName()%></td>
							</tr>
							<tr>
								<th scope="row">Institute Duration</th>
								<td><%=appData.getCourseDuration()%></td>
							</tr>
							<tr>
								<th scope="row">Institute Approval No.</th>
								<td><%=appData.getApprovalNo()%></td>
							</tr>
							<%
							}
							%>

						</tbody>
					</table>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-8 text-center">
					<button class="btn btn-primary" onclick="viewDocs()">Documents</button>
				</div>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	function appList() {
		location.href = "ApplicationListController";
	}
	function viewDocs(){
		location.href='ViewDocuments.jsp';
	}
</script>
<%@ include file="include\foot.jsp"%>
</html>
