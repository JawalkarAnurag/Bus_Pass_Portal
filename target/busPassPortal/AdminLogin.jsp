<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="include\head.jsp" %>
<title>Admin Log in</title>
</head>
<body>
<section class="vh-100" style="background-color: #9A616D;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-none d-md-block">
              <img src="image/PMPML_logo.jpg"
                alt="login form" class="d-flex align-items-center m-5 p-5" style="border-radius: 1rem 0 0 1rem;" />
            </div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

                <form action="AdminLogController"  action="get">


                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into Admin Account</h5>

                  <div class="form-outline mb-4">
                    <input type="tel" id="adminID" name="adminID" class="form-control form-control-lg" />
                    <label class="form-label" for="adminMobile">Admin ID</label>
                  </div>

                  <div class="form-outline mb-4">
                    <input type="password" id="adminPassword" name="adminPassword" class="form-control form-control-lg" />
                    <label class="form-label" for="adminPassword">Password</label>
                  </div>

                  <div class="pt-1 mb-4">
                    <button class="btn btn-success btn-lg btn-block" type="submit">Login</button>
                  </div>

                  <a class="small text-muted" href="#!">Forgot password?</a>
                  
                  <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? 
                  <a href="AdminAuthentication.jsp" style="color: #393f81;">Register here</a>
                  <a href="UserLogin.jsp" style="color: #393f81;">User Login</a>
                  
                  </p>
                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>

<%@ include file="include\foot.jsp" %>
</html>