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
RegisterBean cb=(RegisterBean)session.getAttribute("cust");

out.println("Welcome "+cb.getName()+" Register Sucessfully....");

%>

</body>
</html>