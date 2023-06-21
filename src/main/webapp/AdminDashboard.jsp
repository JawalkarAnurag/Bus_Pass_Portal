	
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
<title>Admin Dashboard</title>
<%@ include file="include\NavCss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


</head>
<body>
	<%!String adminName = null;
	String adminID = null;
	String adminAction=null,actionMsg=null;
	List<ApplicationData> appList=new ArrayList<ApplicationData>();
	%>

	<%@ include file="include\AdminNavbar.jsp"%>

	<%
	adminName = (String) session.getAttribute("adminName");
	adminID = (String) session.getAttribute("adminID");
	appList=(List<ApplicationData>)session.getAttribute("applications");
	adminAction=(String)session.getAttribute("AdminAction");
	
	%>

	<div class="drawer ">
		<h5>
			Admin ID:<%=adminID%></h5>

		<button class="btn btn-success btn-block" onclick="appList()">Application
			List</button>
		<button class="btn btn-success btn-block" onclick="logout()">Logout</button>


	</div>


	<!-- Main Content -->
	
	<div class="content">
<% if(adminAction==("Approved")){
		System.out.println("pass approved div");
		actionMsg="Pass Application Approved.";
	%>
	<div class="alert alert-success" role="alert"><%=actionMsg%></div>
		
	<%}else if(adminAction==("Rejected")){	
		System.out.println("pass rejected div");
		actionMsg="Pass Application Rejected";
	%>
	<div class="alert alert-danger" role="alert"><%=actionMsg%></div>
		
	<%}%>
		<h1>
			Welcome
			<%=adminName%></h1>
			
			
			<%for(ApplicationData appData:appList){ %>
			<div class="card">
    <div class="row">
  <div class="col-md-6">
    <div class="card-body">
      <h5 class="card-title">Application Information</h5>
      <div class="row">
        <div class="col-md-6">
          <p><strong>Application ID:</strong></p>
        </div>
        <div class="col-md-6">
          <p><span id="applicationID"><%=appData.getApplicationID() %></span></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <p><strong>Applicant Name:</strong></p>
        </div>
        <div class="col-md-6">
          <p><span id="userName"><%=appData.getUserName() %></span></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <p><strong>Pass Type:</strong></p>
        </div>
        <div class="col-md-6">
          <p><span id="passType"><%=appData.getPassType() %></span></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <p><strong>Citizen Type:</strong></p>
        </div>
        <div class="col-md-6">
          <p><span id="citizenType"><%=appData.getCitizenType() %></span></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <p><strong>Pass Route:</strong></p>
        </div>
        <div class="col-md-6">
          <p><span id="passRouteType"><%=appData.getPassRouteType() %></span></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <button class="btn btn-primary" onclick="viewApplication('<%=appData.getApplicationID() %>')">View</button>

        </div>
      </div>
    </div>
  </div>
</div>	
</div>
			<%} %>
		</div>	
		<%-- 	<c:forEach items="${applications}" var="applicant">
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">Applicant Information</h5>
      <p><strong>Applicant Name:</strong>${applicant.userName}</p>
      <p><strong>Pass Type:</strong> ${applicant.passType}</p>
      <p><strong>Citizen Type:</strong> ${applicant.citizenType}</p>
      <p><strong>Pass Route:</strong> ${applicant.passRouteType}</p>
      <button class="btn btn-primary" onclick="">View</button>
    </div>
  </div>
</c:forEach> --%>
	

</body>
<script type="text/javascript">
	function appList() {
		location.href = "ApplicationListController";
	}
	
	function logout(){
		
		location.href="AdminLogin.jsp";
		
	}
	function viewApplication(appID) {
		  // Encode the data
		  var encodedData = encodeURIComponent(appID);

		  // Append the encoded data to the servlet URL
		  var servletURL = 'ViewApplicationController?appID=' + encodedData;

		  // Make a GET request to the servlet URL
		  window.location.href = servletURL ;
		}


</script>
<%@ include file="include\foot.jsp"%>
</html>
