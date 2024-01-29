<%@page import="java.io.File"%>
<%@page import="com.javaproject.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
        /* 이미지 크기를 조정하기 위한 CSS */
        .product-image {
            width: 100px; /* 원하는 이미지 너비로 조정하세요 */
            height: auto; /* 높이 자동 조정 */
        }
    </style>

</head>
	<body>
	
		<%
			
			out.print("현재 페이지의 상대주소  :" +request.getContextPath() +"<br>");
			String relitivePath = request.getContextPath();
			String currentWepAppPath_realPath = request.getSession().getServletContext().getRealPath("/");
			
			out.print("이미지의 웹엡 패스 입니다 :"+currentWepAppPath_realPath+"<br>");
			
		%>
		<h1>상품 목록 </h1>

		<table border ="1">
			<tr>
				<th>상품코드</th>
				<th>상품명</th>
				<th>이미지</th>	
				<th>색깔</th>
				<th>수량</th>
				<th>사이즈</th>
				<th>가격</th>
			</tr>
				
			<c:forEach items="${product_list}" var = "dto">
				<tr>
					<td>${dto.product_code}</td>
					<td>${dto.product_name}</td>
					<td>${dto.product_name}</td>
					<td>${dto.getImageFilePath_ShoeImageDir()}</td>
					<td><img  class="product-image"  alt="no image" src =  "/ShoeStoreWeb_big3/ShoeImage/${dto.getImageFilePath_ShoeImageDir()}"> </td>
					
					<td>${dto.product_color}</td>
					<td>${dto.product_qty}</td>
					<td>${dto.product_size}</td>
					<td>${dto.product_price}</td>
				</tr>
			</c:forEach>
			<tr>
			</tr>
		</table>
	
		
		imageFilePath :<%=session.getAttribute("imageFilePath")%>			
	<img alt="test" src="<%=session.getAttribute("imageFilePath")%>"/>
	
	</body>
</html>