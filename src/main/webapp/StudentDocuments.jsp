<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.1/css/fontawesome.min.css" >
<%@ include file="include\head.jsp"%>
<title>Student Pass Documents</title>
<%@ include file="include\NavCss.jsp"%>

</head>
<body>
	<%!String appID = null;
	 String userName=null;
	 String citizenType=null;
	 %>
	 <%
	 userName=(String)session.getAttribute("userName");
	 citizenType=(String)session.getAttribute("citizenType");
	 %>
	 
	<%@ include file="include\navbar.jsp"%>
	<div class="drawer ">
		<h5><%=userName %></h5>
		
			<button class="btn btn-success btn-block" onclick=pass()>Apply for Pass</button>
			<button class="btn btn-success btn-block">Documents</button>
			<button class="btn btn-success btn-block">Transactions</button>
			
	</div>




	<!-- Main Content -->
	<div class="content">
		<button type="button" class="btn btn-primary">
			<i class="fas fa-arrow-left"></i> Back to Application
		</button>
		<h1 class="text-center bg-success text-light m-3 p-2">Upload Documents</h1>
		<h4 class="text-center bg-danger text-light m-3 p-2">**Note: All Documents should be in jpg or jpeg format.**</h4>
		<%
		appID = (String) session.getAttribute("applicationID");
		%>
		<div class="container ">
		
			<form action="StudentDocController" method="post"
				enctype="multipart/form-data">
				<div class="form-group row ">
					<label for="application_id" class="col-sm-6 col-form-label">Application
						ID :</label>
					<div class="col-sm-6">
						<input type="text" class="form-control-file" readonly
							value="<%=appID%>" name="application_id" id="application_id">
					</div>
				</div>

				<div class="form-group row ">
					<label for="user_photo" class="col-sm-6 col-form-label">Photo:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control-file" name="user_photo"
							id="user_photo">
					</div>
				</div>
				<div class="form-group row">
					<label for="lightBill" class="col-sm-6 col-form-label">Light
						Bill:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control-file" name="lightBill"
							id="lightBill">
					</div>
				</div>
				<div class="form-group row">
					<label for="aadhaarCard" class="col-sm-6 col-form-label">Aadhaar
						Card:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control-file" name="aadhaarCard"
							id="aadhaarCard">
					</div>
				</div>
				<% if(citizenType=="Student"){ %>
				<div class="form-group row">
					<label for="bonafide" class="col-sm-6 col-form-label">Bonafide:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control-file" name="bonafide"
							id="bonafide">
					</div>
				</div>
				<div class="form-group row">
					<label for="feeReceipt" class="col-sm-6 col-form-label">Fee
						Receipt:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control-file" name="feeReceipt"
							id="feeReceipt">
					</div>
				</div>
				<%} %>
				<div class="form-group row">
					<div class="col-sm-12">
						<input type="submit" class="btn btn-primary" value="Upload">
					</div>
				</div>
			</form>

		</div>

	</div>

</body>
<%@ include file="include\foot.jsp"%>
</html>
