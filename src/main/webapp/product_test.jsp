<%@page import="java.io.File"%>
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
/* 	String imageFileName
	String filePath = application.getRealPath("/"+resultArray.get(0)); // 임의의 경로를 하나 만들어서 넣음.	 */
	%>

	<!-- session.getAttribute("list");
	 ArrayList<ProductDto> product_list = (ArrayList<ProductDto>) session.getAttribute("product_list");
	
	for (int i=0 ; i< product_list.size(); i++){
		
		out.print(product_list.get(i).getProduct_code()+"<br>");
		out.print(product_list.get(i).getProduct_name().toString());
		out.print(product_list.get(i).getProduct_());
		out.print(session.getAttribute("image_file_path1"));
		
	}  -->
	imageFilePath( 절대경) : <%= session.getAttribute("imageFilePath") %>            
	<%--  <img alt="test" src="<%= session.getAttribute("imageFilePath") %>"/> <br>  --%>
	
<% out.print(	request.getContextPath()); %> <br>
<%// out.print(	request.getSession().getServletContext().getRealPath("") + File.separator + session.getAttribute("imageFilePath") ); %>
<% 	//String realPath =request.getSession().getServletContext().getRealPath("") + File.separator + session.getAttribute("imageFilePath") ; %>
<%
			
		String currentWepAppPath = request.getPathInfo();
		String currentWepAppPath_realPath = request.getSession().getServletContext().getRealPath("/");
		String webAppPath=(String)session.getAttribute("webAppPath");
		out.print("이미지의 웹엡 패스 입니다 :"+webAppPath+"<br>");
		out.print("현재 페이지의 웹엡 패스입니다.  :" +currentWepAppPath_realPath +"<br>");
		out.print("현재 페이지의 상대주소  :" +request.getContextPath() +"<br>");
		String relitivePath = request.getContextPath();
		

		
	%>
		<h1>MVC 게시판 </h1>
		
	${dto.product_color}
	<% String realPath = (String) session.getAttribute("imageFilePath"); 
	 out.print("reltive path 입니다.  : "+ relitivePath);
	
	%>
	
	<%-- <img src="<%= request.getContextPath() %>/sss.png" alt="이미지"> --%>

	<img alt="test" src="${realPath}"/> <br>
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
			
		<!-- 여기서는 꺽쇠 퍼센트를 쓰면안된다.  -->
		<c:forEach items="${product_list}" var = "dto">
			<tr>
				<td>${dto.product_code}</td>
				<td>${dto.product_name}</td>
				<!-- <td><img alt="no image" src = "file:///Users/forrestdpark/eclipse/jee-2023-12/Eclipse.app/Contents/MacOS/image_1.png">  </td> -->
				
				<td><img  class="product-image"  alt="no image" src =  "/ShoeStoreWeb_big3/${dto.getImageFilePath()}"> </td>
				<td>${dto.product_color}</td>
				<%-- <td> ${dto.product_color}</td> --%>
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