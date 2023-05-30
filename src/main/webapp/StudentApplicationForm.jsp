<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include\head.jsp"%>
<%@ include file="include\NavCss.jsp"%>
<style type="text/css">
.sub-menu {
	list-style: none; /* Remove the bullets */
}

.sub-menu-item {
	margin: 10px 0; /* Add some vertical spacing */
}

.sub-menu-item a {
	margin-left: 0px; /* Indent sub-menu items */
	margin-top: 10px;
	color: white; /* Set the text color to white */
	background-color: blue; /* Set the background color to blue */
	padding: 5px 10px; /* Add some padding */
	border-radius: 5px; /* Add some border radius */
}
</style>
<meta charset="ISO-8859-1">
<title>Student Pass Application</title>
</head>
<body>

<%! String passType=null; 
	String citizenType=null;
%>
<% passType=(String)session.getAttribute("passType"); 
	citizenType=(String)session.getAttribute("citizenType");
%>

	<%@ include file="include\navbar.jsp"%>

	<!-- Side Drawer -->
	<div class="drawer ">
		<h5>User Name</h5>

		<button class="btn btn-success btn-block">Apply for Pass</button>
		
		<!-- <ul class="sub-menu">
			<li class="sub-menu-item"><a href="#personal_info">Personal
					Information</a></li>
			<li class="sub-menu-item"><a href="#edu_info">Educational
					Information</a></li>
			<li class="sub-menu-item"><a href="#pass_info">Pass
					Information</a></li>

		</ul> -->
		
		<button class="btn btn-success btn-block">Documents</button>
		<button class="btn btn-success btn-block">Transactions</button>

	</div>

	<!-- Main Content -->
	<div class="content">
		<div class="container">
			<h1 class="text-center"><%=citizenType %> Pass Application</h1>
			<form action="StudentAppController" method="post">
				<h3 id="personal_info" class="text-center bg-success text-light p-2">Personal
					Information</h3>
				<div class="form-group">
					<label for="userName">Name</label> <input  required type="text"
						class="form-control" id="userName" name="userName"
						placeholder="Enter your name">
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="dob">Date of Birth</label> <input required  type="date"
								class="form-control" id="dob" name="dob">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="userAge">Age:</label> <input  readonly required type="text"
								class="form-control" id="userAge" name="userAge">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="userMobile">Mobile</label> <input  required type="tel"
								class="form-control" id="userMobile" name="userMobile">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="userMail">E-Mail</label> <input type="email"
								class="form-control" id="userMail" name="userMail">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="userVillage">Village/Town</label> <input required type="text"
								class="form-control" id="userVillage" name="userVillage">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="userPincode">Pincode</label> <input required type="number"
								class="form-control" id="userPincode" name="userPincode">
						</div>
					</div>
				</div>



				<h3 id="pass_info" class="text-center bg-success text-light p-2">Pass
					Information</h3>

				<label for="passRouteType">Pass Route Type</label> <select
					id="passRouteType" onchange="route()" required name="passRouteType">
					<option value="all_route">All route</option>
					<option value="single_route">Single Route</option>

				</select>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="passFrom">Pass From</label> <input required type="date"
								class="form-control" id="passFrom" name="passFrom"
								placeholder="Enter from which date you want pass">
						</div>

					</div>

					<div class="col-md-6">

						<div class="form-group">
							<label for="passTo">Pass To</label> <input readonly required type="date"
								class="form-control" id="passTo" name="passTo">
						</div>
					</div>
				</div>
				<div class="row">
				<div class="col-md-6">
				<div class="form-group">
							<label for="board">Boarding Location</label> <input disabled  type="text"
								class="form-control" id="board" name="board"
								placeholder="Enter from which location you will board bus">
						</div>
				</div>
				<div class="col-md-6">
				<div class="form-group">
							<label for="destination">Destination</label> <input disabled type="text"
								class="form-control" id="destination" name="destination"
								placeholder="Enter destination">
						</div>
				</div>
				</div>
				
<% if(citizenType=="Student"){ %>
				<h3 id="edu_info" class="text-center bg-success text-light p-2">Educational
					Information</h3>
				<div class="form-group">
					<label for="insti_name">Institution Name</label> <input  required type="text"
						class="form-control" id="insti_name" name="insti_name"
						placeholder="Enter your name">
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="insti_location">Institute Location</label> <input
								type="text" required class="form-control" id="insti_location"
								name="insti_location" placeholder=" Institute Village/Town name">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="insti_pincode">Pincode</label> <input required type="number"
								class="form-control" id="insti_pincode" name="insti_pincode"
								placeholder="Enter your Institute Pincode">
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="courseName">Course Name</label> <input required type="text"
								class="form-control" id="courseName" name="courseName"
								placeholder="Enter your Course Name">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="courseDuration">Course Duration(in years)</label> <input 
								type="number" required class="form-control" id="courseDuration"
								name="courseDuration" placeholder="Enter your Course Duration">
						</div>
					</div>

				</div>

				<div class="form-group">
					<label for="approvalNo">Institute Approved by Government
						Number</label> <input  type="text" class="form-control" id="approvalNo"
						name="approvalNo" required placeholder="Enter Approval Number">
				</div>

				<%} %>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>

</body>
<script type="text/javascript">

var firstDateElement = document.getElementById('passFrom');
var secondDateElement = document.getElementById('passTo');

var pass_type = '<%= passType %>';

if (pass_type === "Monthly") {
  firstDateElement.addEventListener('input', function() {
    secondDateElement.disabled = false;
    var firstDateValue = firstDateElement.value;
    var firstDate = new Date(firstDateValue);
    var secondDate = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, firstDate.getDate());
    var formattedSecondDate = secondDate.toISOString().split('T')[0];
    secondDateElement.value = formattedSecondDate;
  });
} else if (pass_type === "Yearly") {
  firstDateElement.addEventListener('input', function() {
    secondDateElement.disabled = false;
    var firstDateValue = firstDateElement.value;
    var firstDate = new Date(firstDateValue);
    var secondDate = new Date(firstDate.getFullYear() + 1, firstDate.getMonth(), firstDate.getDate());
    var formattedSecondDate = secondDate.toISOString().split('T')[0];
    secondDateElement.value = formattedSecondDate;
  });
}


function route() {
	
	var selectedValue=event.target.value;
	
	if(selectedValue=="single_route"){
		
		var boarding=document.getElementById("board");
		boarding.disabled=false;
		boarding.required=true;
		
		var destination=document.getElementById("destination");
		destination.disabled=false;
		destination.required=true;
		
	}
	
}

var dobElement = document.getElementById('dob');
var ageElement = document.getElementById('userAge');

dobElement.addEventListener('input', function() {
  var dobValue = dobElement.value;
  var dobDate = new Date(dobValue);
  var now = new Date();
  
  var age = now.getFullYear() - dobDate.getFullYear();
  
  // Adjust the age if the birthday hasn't occurred yet this year
  if (now.getMonth() < dobDate.getMonth() || (now.getMonth() === dobDate.getMonth() && now.getDate() < dobDate.getDate())) {
    age--;
  }
  
  ageElement.value = age;
});

</script>

<%@ include file="include\foot.jsp"%>
</html>