<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1> 게시판</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>색깔</th>
			<th>수량</th>
			<th>사이즈</th>
			<th>가격</th>
		</tr>
		
		<c:forEach items="${list}" var="AdminDto">
		
			<tr>
				<td>${AdminDto.pnum}</td>
				<td>${AdminDto.pname}</td>
				<td>${AdminDto.pcolor}</td>
				<td>${AdminDto.pqty}</td>
				<td>${AdminDto.psize}</td>
				<td>${AdminDto.pprice}</td>
				
			</tr>
		
		</c:forEach>
		
	
	</table>
</body>
</html>