<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ecomerce.AddProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="message">
<%
AddProductBean cb=(AddProductBean)session.getAttribute("bean");

  out.println("Welcome "+cb.getPname()+" Product Details Added sucessfully");
%>
</div>
<br><br>
<button onclick="location.href='ViewAllProduct.html'">ViewAllProduct</button><br>
<button onclick="location.href='Logout.html'">Logout</button>


</body>
</html>