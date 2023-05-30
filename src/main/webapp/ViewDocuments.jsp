
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
<style>
    .fullscreen-image {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.9);
      display: flex;
      align-items: center;
      justify-content: center;
      z-index: 9999;
    }

    .fullscreen-image img {
      max-width: 90%;
      max-height: 90%;
    }
  </style>
<%@ include file="include\head.jsp"%>
<title>Applicant Documents</title>
<%@ include file="include\NavCss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


</head>
<body>
	<%!String adminName = null;
	String single_route = "single_route", student = "Student";
	String adminID = null;
	ApplicationData appData = new ApplicationData();
	StudentDocuments appDocs = new StudentDocuments();%>

	<%@ include file="include\AdminNavbar.jsp"%>

	<%
	adminName = (String) session.getAttribute("adminName");
	adminID = (String) session.getAttribute("adminID");
	appData = (ApplicationData) session.getAttribute("ApplicantData");
	appDocs = (StudentDocuments) session.getAttribute("ApplicantDocs");
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
  <h3 id="personal_info" class="text-center bg-success text-light p-2">Applicant Documents</h3>
  <div class="row justify-content-center">
    <div class="col-md-8 mx-auto">
      <table class="table table-bordered table-striped">
        <tbody>
          <tr>
            <th scope="row">Applicant Photo</th>
            <td>
              <img alt="Applicant Photo" src="image/<%=appDocs.getFn_photo()%>" width=100px height=100px>
            </td>
            <td>
              <button class="btn btn-primary" onclick="openFullscreenImage('image/<%=appDocs.getFn_photo()%>')">View Document</button>
            </td>
          </tr>
          <tr>
            <th scope="row">Applicant Aadhaar</th>
            <td>
              <img alt="Applicant Aadhaar card" src="image/<%=appDocs.getFn_aadhaar()%>" width=100px height=100px>
            </td>
            <td>
              <button class="btn btn-primary" onclick="openFullscreenImage('image/<%=appDocs.getFn_aadhaar()%>')">View Document</button>
            </td>
          </tr>
          <tr>
            <th scope="row">Applicant Light Bill</th>
            <td>
              <img alt="Applicant LightBill" src="image/<%=appDocs.getFn_lightbill()%>" width=100px height=100px>
            </td>
            <td>
              <button class="btn btn-primary" onclick="openFullscreenImage('image/<%=appDocs.getFn_lightbill()%>')">View Document</button>
            </td>
          </tr>
          <%if(appData.getCitizenType().equals(student)){ %>
          <tr>
            <th scope="row">Applicant Bonafide</th>
            <td>
              <img alt="Applicant Bonafide" src="image/<%=appDocs.getFn_bonafide()%>" width=100px height=100px>
            </td>
            <td>
              <button class="btn btn-primary" onclick="openFullscreenImage('image/<%=appDocs.getFn_bonafide()%>')">View Document</button>
            </td>
          </tr>
          <tr>
            <th scope="row">Applicant Fee Receipt</th>
            <td>
              <img alt="Applicant Fee receipt" src="image/<%=appDocs.getFn_feeReceipt()%>" width=100px height=100px>
            </td>
            <td>
            <%} %>
              <button class="btn btn-primary" onclick="openFullscreenImage('image/<%=appDocs.getFn_feeReceipt()%>')">View Document</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  <div class="row justify-content-center">
				<div class="col-md-8 text-center">
					<button class="btn btn-success" onclick="approveApp('<%=appData.getApplicationID()%>')">Approve Application</button>
					<button class="btn btn-danger" onclick="rejectApp('<%=appData.getApplicationID()%>')">Reject Application</button>
					
				</div>
			</div>
</div>
	
	</div>
</body>
<script type="text/javascript">
	function appList() {
		location.href = "ApplicationListController";
	}
	function openFullscreenImage(imageUrl) {
	    var fullscreenContainer = document.createElement('div');
	    fullscreenContainer.className = 'fullscreen-image';

	    var imageElement = document.createElement('img');
	    imageElement.src = imageUrl;

	    fullscreenContainer.appendChild(imageElement);
	    document.body.appendChild(fullscreenContainer);

	    fullscreenContainer.addEventListener('click', closeFullscreenImage);
	  }

	  function closeFullscreenImage(event) {
	    event.target.remove();
	  }
	  
	  function approveApp(appID){
		  var encodedData = encodeURIComponent(appID);

		  // Append the encoded data to the servlet URL
		  var servletURL = 'ApproveAppController?appID=' + encodedData;

		  // Make a GET request to the servlet URL
		  window.location.href = servletURL ;
	  }
	  
	  function rejectApp(appID){
		  var encodedData = encodeURIComponent(appID);

		  // Append the encoded data to the servlet URL
		  var servletURL = 'RejectAppController?appID=' + encodedData;

		  // Make a GET request to the servlet URL
		  window.location.href = servletURL ;
		  
	  }
</script>
<%@ include file="include\foot.jsp"%>
</html>
