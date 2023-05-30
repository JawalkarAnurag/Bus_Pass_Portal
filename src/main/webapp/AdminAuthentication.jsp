<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include  file="include\head.jsp" %>
<meta charset="ISO-8859-1">
<title>Admin Authentication</title>
</head>
<body>
<div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
  <div class="card">
    <form action="AdminAuthController" method="get">
    
    <div class="card-body d-flex flex-column">
      <div class="mb-3">
      
        <label for="authcodeinput" class="form-label">Authentication code:</label>
        <input type="password" class="form-control" id="authcodeinput" name="authcodeinput" required placeholder="Enter your authentication code">
      </div>
      <button class="btn btn-primary" type="submit" id="verify-button">Verify</button>
    </div>
    </form>
  </div>
</div>


</body>

<%@ include  file="include\foot.jsp" %>
</html>