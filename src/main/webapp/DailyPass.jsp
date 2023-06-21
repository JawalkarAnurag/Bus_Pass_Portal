<!DOCTYPE html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="model.ApplicationData"%>
<html>
<head>
<%@ include file="include\head.jsp"%>

<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<title>Daily Pass</title>
<%@ include file="include\NavCss.jsp"%>

</head>
<body>
	<%@ include file="include\navbar.jsp"%>

	<%!String userMobile = null;
	String stud_doc_uploaded = null;
%>



	<%
	stud_doc_uploaded = (String) session.getAttribute("stud_doc_uploaded");
	userMobile = (String) session.getAttribute("userMobile");
	%>

	<div class="drawer ">
		<h5>
			User :<%=userMobile%></h5>

		<button class="btn btn-success btn-block" onclick=pass()>Apply
			for Pass</button>
		<button class="btn btn-success btn-block">Documents</button>
		<button class="btn btn-success btn-block">Transactions</button>

	</div>


	<!-- Main Content -->
	<div class="content">
<div class="card">
  <div class="card-header text-center h3 bg-secondary text-light">
    Daily Pass
  </div>
  <div class="card-body">
  <form action="DialyPassController">
  <div class="form-group">
      <label for="govtIdNo">Government ID No.</label>
      <input type="text" class="form-control" id="govtIdNo" name="govIdNo" placeholder="Enter Government ID No.">
    </div>
    <div class="form-group">
      <label for="gender">Gender</label>
      <select class="form-control" id="gender" name="gender">
        <option value="MALE">Male</option>
        <option value="FEMALE">Female</option>
        <option value="OTHER">Other</option>
      </select>
    </div>
    <div class="form-group">
      <label for="area">Area</label>
      <select class="form-control" id="area" name="area">
        <option value="PMC">PMC</option>
        <option value="PCMC">PCMC</option>
      </select>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-primary ">Submit</button>
    </div>
  </form>
    
  </div>
</div>

	</div>

</body>
<script type="text/javascript">
function pass(){
	location.href="PassType.jsp";
}
</script>
<%@ include file="include\foot.jsp"%>
</html>
