<%@page import="java.io.File"%>
<%@page import="com.javaproject.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>상품 목록</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #FFA500; /* 타이틀 글자 색상 */
            font-family: 'Roboto', sans-serif; /* 세련된 폰트 설정 */
            font-weight: bold; /* 폰트 굵기 */
            letter-spacing: 1px; /* 글자 간격 */
            text-transform: uppercase; /* 대문자 변환 */
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #dee2e6;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        .product-image {
            width: 100px;
            height: auto;
        }
    </style>
</head>
<% ArrayList<ProductDto> product_list = (ArrayList<ProductDto>) session.getAttribute("product_list"); %>

<% int totalProductNumber = product_list.size(); 

//out.print("총 상품 수: " + totalProductNumber);%>	
<body>
    <div class="container">
        <h1>상품 목록 </h1>
        <hr>
        <h3><% out.print("총 상품 수 : " + totalProductNumber); %> <br></h3>
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th>상품코드</th>
                    <th>상품명</th>
                    <th>이미지</th>    
                    <th>가격</th>
                    <th>수량</th>
                    <th>색깔</th>
                    <th>사이즈</th>
                    
                </tr>
            </thead>
            
            
            <tbody>
                <c:forEach items="<%=product_list %>" var="dto">
                    <tr>
                        <td style="vertical-align: middle;" >${dto.product_code}</td>
                        <td style="vertical-align: middle;" >${dto.product_name}</td>
                        <td style="vertical-align: middle;" ><img class="product-image" alt="no image" src="/ShoeStoreWeb_big3/ShoeImage/${dto.product_imageName}"></td>
                        <%-- <td style="vertical-align: middle;" > /ShoeStoreWeb_big3/ShoeImage/${dto.product_imageName})</td> --%>
                     	 <td style="vertical-align: middle;"><fmt:formatNumber value="${dto.product_price}" pattern="#,##0 원"/></td> 
                   		<td style="vertical-align: middle;" >${dto.product_qty}</td>
                   		<td style="vertical-align: middle;" >${dto.product_color}</td>
                   		<td style="vertical-align: middle;" >${dto.product_size}</td>
                        
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div style="text-align: center;"> <form action="write_view.jsp?totalProductNumber=<%=totalProductNumber%>" method="post"> 
        				<input type="submit" value="등록하러가기" > </form> </div>
    </div>
    <!-- 부트스트랩 JS 및 jQuery 링크 -->
  
