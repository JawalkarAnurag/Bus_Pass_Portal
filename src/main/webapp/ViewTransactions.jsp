<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PassTransactions"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="model.ApplicationData"%>
<html>
<head>
<%@ include file="include\head.jsp"%>

<script src="https://checkout.razorpay.com/v1/checkout.js"></script> 
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">

function pass(){
	location.href="PassType.jsp";
}

function getTransactions(userMobile){
	console.log("in transactions");
	console.log(userMobile);
	window.location.href='TransactionController?userMobile='+userMobile;
	
}

function initiatePayment(amount,appID){
	
	console.log("payment Started");
	console.log(amount+"(in paise)");
	 $.ajax({
	        url: 'PaymentController',
	        method: 'POST',
	        data: {
	            amount: amount
	        },
	        success: function(orderId) {
	            createPayment(orderId, amount,appID);
	        },
	        error: function(xhr, status, error) {
	            console.error("Error: " + error);
	        }
	    });
	 
}
	

function createPayment(orderId, amount,appID) {
   
	var options = {
        "key": "rzp_test_rk7RvIPUGSCeip", // Replace with your actual Key ID
        "amount": amount , // Payment amount in paise
        "currency": "INR", // Currency code
        "name": "PMPML", // Displayed on the payment popup
        "description": "Pass Payment",// Displayed on the payment popup
//         "image":"image/PMPML_logo.jpg",
        "order_id": orderId, // Razorpay order ID
        "handler": function (response) {
        	swal("Payment Successful!", "Your Pass will be mailed to you!", "success");
        	console.log(response.razorpay_payment_id);
        	console.log(response.razorpay_order_id);
        	console.log(response.razorpay_signature);
            // Callback function executed after successful payment
            console.log(response);
            // You can perform further actions here, such as updating the payment status on the server
            
             var pay_id=response.razorpay_payment_id;
        	var order_id=response.razorpay_order_id;
        	var rzp_sign=response.razorpay_signature;
            
            var encoded_pay_id = encodeURIComponent(pay_id);
              var encoded_order_id = encodeURIComponent(order_id);
              var encoded_rzp_sign = encodeURIComponent(rzp_sign);

              console.log(pay_id);
              console.log(order_id);
              console.log(rzp_sign);

              var encoded_pay_id = encodeURIComponent(pay_id);
              var encoded_order_id = encodeURIComponent(order_id);
              var encoded_rzp_sign = encodeURIComponent(rzp_sign);


  		  // Append the encoded data to the servlet URL
  		  var servletURL = 'PassSuccessController?pay_id='+encoded_pay_id+'&order_id='+encoded_order_id+'&rzp_sign='+encoded_rzp_sign+'&appID='+appID +'&amount='+amount;

  		  // Make a GET request to the servlet URL
  		  window.location.href = servletURL ;
        },
        "prefill": {
            "name": "", // Pre-filled customer name
            "email": "" // Pre-filled customer email
        },
        "notes": {
            "address": "Pune Muncipal Corporation" // Additional notes to be sent to the server
        },
        "theme": {
            "color": "#007500" // Customize the color of the payment popup
        }
    };
    var rzp = new Razorpay(options);
    rzp.on('payment.failed', function (response){
       console.log(response.error.code);
       console.log(response.error.description);
       console.log(response.error.source);
       console.log(response.error.step);
       console.log(response.error.reason);
       console.log(response.error.metadata.order_id);
       console.log(response.error.metadata.payment_id);
       swal("Failed!!", "Oops Something went wrong!!", "error");
});
    rzp.open();
}
</script>

<title>User Dashboard</title>
<%@ include file="include\NavCss.jsp"%>

</head>
<body>
	<%!String userMobile = null;
	String stud_doc_uploaded = null;
	String doc_status = null, approvedStatus = "Approved", student = "Student", adult = "Adult Citizen",
			senior = "Senior Citizen",applied="Applied", reject="Rejected";
	String allRoute = "all_route", singleRoute = "single_route", amount = null, monthly = "Monthly", yearly = "Yearly";

	List<PassTransactions> ptList=new ArrayList<>();
%>

	<%@ include file="include\navbar.jsp"%>


	<%
	stud_doc_uploaded = (String) session.getAttribute("stud_doc_uploaded");
	userMobile = (String) session.getAttribute("userMobile");
	ptList=(List<PassTransactions>)session.getAttribute("Pass_Transactions");	
	%>

	<div class="drawer ">
		<h5>
			User :<%=userMobile%></h5>

		<button class="btn btn-success btn-block" onclick=pass()>Apply
			for Pass</button>
		<button class="btn btn-success btn-block" onclick="getTransactions('<%=userMobile%>')">Transactions</button>

	</div>


	<!-- Main Content -->
	<div class="content">
	<%for(PassTransactions pt : ptList){ %>

	<div class="card rounded">
			<div class="card-body">
				<h5 class="card-title">Pass Transactions</h5>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="passID">Pass ID</label> <input
								type="text" class="form-control" id="passID"
								value="<%=pt.getPassId()%>" readonly>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="passType">Pass Type</label> <input type="text"
								class="form-control" id="passType"
								value="<%=pt.getPassType()%>" readonly>
						</div>
					</div>
				</div>
				<div class="row">
				
					<div class="col-md-6">
						<div class="form-group">
							<label for="userMobile">Mobile</label> <input type="text"
								class="form-control" id="userMobile"
								value="<%=pt.getUserMob()%>" readonly>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="routeType">Route Type</label> <input type="text"
								class="form-control" id="routeType"
								value="<%=pt.getPassRouteType()%>" readonly>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="date">Date</label> <input type="text"
								class="form-control" id="date"
								value="<%=pt.getDate()%>" readonly>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="amount">Amount</label> <input type="text"
								class="form-control" id="amount"
								value="<%=pt.getAmount()%>" readonly>
						</div>
					</div>
				</div>
					
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="orderID">Order ID</label> <input type="text"
								class="form-control" id="orderID"
								value="<%=pt.getOrder_id()%>" readonly>
						</div>
					</div>
				</div>
			 </div>
			 </div>
			 <%} %>
	</div>

</body>
<%@ include file="include\foot.jsp"%>


</html>
