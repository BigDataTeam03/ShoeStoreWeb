<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Executed Query : <%= session.getAttribute("query") %>
	customer ID : <%= session.getAttribute("CUSTID")%>
</body>
</html>