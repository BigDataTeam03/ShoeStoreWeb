<%@page import="com.javaproject.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
/* 	String imageFileName
	String filePath = application.getRealPath("/"+resultArray.get(0)); // 임의의 경로를 하나 만들어서 넣음.	 */
	%>
	<%
	//session.getAttribute("list");
	ArrayList<ProductDto> product_list = (ArrayList<ProductDto>) session.getAttribute("product_list");
	
	for (int i=0 ; i< product_list.size(); i++){
		
		out.print(product_list.get(i).getProduct_code());
		out.print(product_list.get(i).getProduct_name());
		out.print(product_list.get(i).getProduct_()+ "<br>");
		
	}
	
	out.print(session.getAttribute("product_list")  );
	%>
		<h1>MVC 게시판 </h1>
	<table border ="1">
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>색깔</th>
			<th>수량</th>
			<th>사이즈</th>
			<th>가격</th>
			<th>이미지</th>
		</tr>
			
		<!-- 여기서는 꺽쇠 퍼센트를 쓰면안된다.  -->
		<c:forEach items="${product_list}" var = "dto">
			<tr>
				<td>${dto.product_code}</td>
				<td>${dto.product_name}</td>
				<td>${dto.product_color}</td>
				<td>${dto.product_qty}</td>
				<td>${dto.product_size}</td>
				<td>${dto.product_price}</td>
				<%-- <td>${dto.imageFileName}</td> --%> 
				<%-- <td><img alt="test" src="${dto.imageFileName}"/>	             </td> --%>
			</tr>
		</c:forEach>
		<tr>
		</tr>
	</table>




	
	imageFilePath :<%=session.getAttribute("imageFilePath")%>			
	<img alt="test" src="<%=session.getAttribute("imageFilePath")%>"/>	
	
	

	
		

</body>
</html>