<%@page import="java.util.ArrayList"%>
<%@page import="com.javaproject.dto.AdminDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>

<% 

// "list"라는 속성이 ArrayList인 경우
ArrayList<AdminDto> list = (ArrayList<AdminDto>) request.getAttribute("list");

// ArrayList의 크기를 가져오기
int totalProductNumber = list.size();
out.print("총 상품 수: " + totalProductNumber);

%>


<body>


	<h1> 게시판</h1>
	
	 검색선택: 
	<form action ="">
			<select name="query">
				<option value="name">이름</option>
				<option value="color">색깔</option>
				<option value="qty" selected="selected">수량</option>
				<option value="size">사이즈</option>
				<option value="price">가격</option>
			</select>
		<input type="text" name="content" size="30">
		<input type="submit" value="검색">
	</form>
	<br>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>색깔</th>
			<th>수량</th>
			<th>사이즈</th>
			<th>가격</th>
			<th>이미지</th>
		</tr>
		
		<c:forEach items="${list}" var="AdminDto">
		
			<tr>
				<td>${AdminDto.product_code}</td>
				<td>${AdminDto.product_name}</td>
				<td>${AdminDto.product_color}</td>
				<td>${AdminDto.product_qty}</td>
				<td>${AdminDto.product_size}</td>
				<td>${AdminDto.product_price}</td>
				
			</tr>
		
		</c:forEach>
		
	</table>
	<br>
	<form action="write_view.jsp?totalProductNumber=<%=totalProductNumber%>" method="post">
	<input type="submit" value="입력">
	</form>
	
	
    
</body>
</html>