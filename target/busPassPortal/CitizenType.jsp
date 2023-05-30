<!DOCTYPE html>
<html>
<head>
<%@ include file="include\head.jsp" %>
	<title>Citizen type</title>
<%@ include file="include\NavCss.jsp" %>
	
</head>
<body>
<%! String pass_type=null;
	String monthly="for Monthly Pass";
	String yearly="for Yearly Pass";		
%>
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
	<button class="btn btn-primary" onclick=back()>Back
	
	</button>
	
	<% pass_type=(String)session.getAttribute("passType"); %>
	
		<h1 class="text-center">Select Citizen Type
		<% if(pass_type=="Monthly"){%>
			<%=monthly%>
		<%}else if(pass_type=="Yearly"){%>
			<%=yearly %>
			
		<%} %>
		
		</h1>
		<div class="btn-group-vertical d-flex align-items-center">
		<button class="btn btn-success btn-lg m-2 " onclick="student()"> Student (<25 Age Group)</button>
		<button class="btn btn-success btn-lg m-2" onclick="adult()"> Adult Citizen(25-60 Age Group)</button>
		<button class="btn btn-success btn-lg m-2" onclick="senior()"> Senior Citizen(>60 Age Group)</button>
		
		</div>
		
</div>

</body>
<script type="text/javascript">

function back(){
	location.href="PassType.jsp";
}
function student(){
	location.href="StudentPassController";
}
function adult(){
	location.href="AdultPassController";
}
function senior(){
	location.href="SeniorPassController";
}
</script>
<%@ include file="include\foot.jsp" %>
</html>
