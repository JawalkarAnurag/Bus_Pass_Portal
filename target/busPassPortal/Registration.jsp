<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include\head.jsp"%>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<section class="vh-100" style="background-color: #90EE90;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Register</p>

									<form action="RegistrationController" method="post"
										enctype="multipart/form-data" class="mx-1 mx-md-4">

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="userName" name="userName"
													class="form-control" /> <label class="form-label"
													for="userName">Your Name</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="email" id="userMail" name="userMail"
													class="form-control" /> <label class="form-label"
													for="userMail">Your Email</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="tel" id="userMobile" name="userMobile"
													class="form-control" /> <label class="form-label"
													for="userMobile">Your Contact</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="userPassword" name="userPassword"
													class="form-control" /> <label class="form-label"
													for="userPassword">Password</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="userPassword2"
													name="userPassword2" class="form-control" /> <label
													class="form-label" for="userPassword2">Repeat your
													password</label>
											</div>
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Register</button>
										</div>
										<p>
											Already have an account?<a href="UserLogin.jsp"
												style="color: #393f81;">Login here</a>
												</p>
									</form>

								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img src="image/pmpml_bus_queue.webp" class="img-fluid"
										alt="Sample image">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="include\foot.jsp"%>
</body>
</html>