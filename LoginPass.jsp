<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ecomerce.RegisterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
RegisterBean cb=(RegisterBean)session.getAttribute("bean");

out.println("Welcome "+cb.getName()+" login Sucessfully....");


%>

   <br> <br><button onclick="location.href='AddProduct.html'">Addproduct</button> <br> <br>

<h1 id="SetHere">Your OTP is : <span></span></h1>

<button id="btngenerate">Generate</button> 

<div class="container">

<input type="text" id="enter" placeholder="Enter OTP">  
<button id="btnverify">Verify</button>

</div>



<script >

function Generate()
{
      var digits='0123456789';
      let otp='';
      for (let i = 0; i <4 ; i++)
    	  {
    	  otp=otp+digits[Math.floor(Math.random()*10)];
    	  }
        
      return otp;
}

function verifyOTP()
{
	var myOTP=document.getElementById("enter").value;
	var OTPoriginal=document.querySelector("span").innerHTML;
	if(myOTP==OTPoriginal)
		{
		 alert("right");
		}
	else{
		alert("wrong");
	}
}
	
	
	document.getElementById("btngenerate").onclick=function()
	{
		document.querySelector("span").innerHTML=Generate();
	}
	
	document.getElementById("btnverify").onclick=function()
	{
		verifyOTP();
	}
	
</script>


</body>
</html>