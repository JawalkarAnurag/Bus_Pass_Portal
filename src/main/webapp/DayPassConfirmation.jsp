<!DOCTYPE html>
<%@page import="model.DayPass"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="model.ApplicationData"%>
<html>
<head>
<%@ include file="include\head.jsp"%>
<title>Daily Pass Confirmation</title>
<%@ include file="include\NavCss.jsp"%>

<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script> 
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>
	<%@ include file="include\navbar.jsp"%>

	<%!String userMobile = null;
	String stud_doc_uploaded = null;
	DayPass dPass=new DayPass(); 
%>



	<%
	stud_doc_uploaded = (String) session.getAttribute("stud_doc_uploaded");
	userMobile = (String) session.getAttribute("userMobile");
	dPass=(DayPass)session.getAttribute("DayPass");
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
<div class="card rounded">
    <div class="card-body">
        <h5 class="card-header text-center">Pass Information</h5>
        <div class="row">
            <div class="col-md-6">
                <p class="card-text"><strong>Pass ID :</strong></p>
                <p class="card-text"><strong>Pass Type :</strong></p>
                <p class="card-text"><strong>Date :</strong></p>
            </div>
            <div class="col-md-6">
                <p class="card-text"><%=dPass.getPassId() %></p>
                <p class="card-text">Day Pass</p>
                <p class="card-text"><%=dPass.getDate()%> <%=dPass.getTime() %></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <p class="card-text"><strong>Gov ID :</strong></p>
                <p class="card-text"><strong>Gender :</strong></p>
                <p class="card-text"><strong>Pass Route Type :</strong></p>
                <p class="card-text"><strong>Amount :</strong></p>

            </div>
            <div class="col-md-6">
                <p class="card-text"><%=dPass.getGovID() %></p>
                <p class="card-text"><%=dPass.getGender() %></p>
                <p class="card-text"><%=dPass.getArea() %></p>
                <p class="card-text"><%=dPass.getAmount() %> (INR)</p>

            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
            
                <button onclick="initiatePayment('<%=dPass.getAmount()%>')" class="btn btn-success btn-lg" >Pay</button>
            </div>
        </div>
    </div>
</div>

	</div>

</body>
<script>
function pass(){
	location.href="PassType.jsp";
}

function initiatePayment(amount){
	
	console.log("payment Started");
	console.log(amount+"(in paise)");
	 
	$.ajax({
	        url: 'PaymentController',
	        method: 'POST',
	        data: {
	            amount: amount
	        },
	        success: function(orderId) {
	            createPayment(orderId, amount);
	        },
	        error: function(xhr, status, error) {
	            console.error("Error: " + error);
	        }
	    });
	
}
	

function createPayment(orderId, amount) {
   
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
            var pay_id=response.razorpay_payment_id;
        	var order_id=response.razorpay_order_id;
        	var rzp_sign=response.razorpay_signature;
            
            console.log(response);
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
    		  var servletURL = 'PaymentSuccessController?pay_id='+encoded_pay_id+'&order_id='+encoded_order_id+'&rzp_sign='+encoded_rzp_sign;

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

<%@ include file="include\foot.jsp"%>
</html>
