<!DOCTYPE html>
<html>
<head>
<%@ include file="include\head.jsp" %>
	<title>Pass type</title>
<%@ include file="include\NavCss.jsp" %>
	
</head>
<body>
	
<%@ include file="include\navbar.jsp" %>
<%!	 String userMobile=null;
	 %>
	 <%
	 userMobile = (String) session.getAttribute("userMobile");
	 %>
<div class="drawer ">
		<h5>User :<%=userMobile %></h5>
		
			<button class="btn btn-success btn-block" onclick=pass()>Apply for Pass</button>
			<button class="btn btn-success btn-block">Documents</button>
			<button class="btn btn-success btn-block">Transactions</button>
			
	</div>


	

	<!-- Main Content -->
	<div class="content">
		<h1 class="text-center">Select Pass Type</h1>
		<div class="btn-group-vertical d-flex align-items-center">
		<button class="btn btn-success btn-lg m-2 " onclick="daily()"> Daily</button>
		<button class="btn btn-success btn-lg m-2" onclick="monthly()"> Monthly</button>
		<button class="btn btn-success btn-lg m-2" onclick="yearly()"> Yearly</button>
		
		</div>
		
</div>

</body>
<script type="text/javascript">

function daily(){
	location.href="DailyPass.jsp";
}
function monthly(){
	location.href="MonthlyPassController";
}
function yearly(){
	location.href="YearlyPassController";
}
</script>
<%@ include file="include\foot.jsp" %>
</html>
