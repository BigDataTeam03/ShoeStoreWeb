<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<!-- 이페이지는 전페이지에서 선택한 상품명에 대한 색상, 사이즈, 수량에 대한 정보를 받아서 실제 디비에서 product detail 검색후
 검색된 상품의 수량을 수정하여 최종적으로 상품이 결제되게하는 페이지 
 -->

<head>
    <meta charset="UTF-8">
    <title>상품 구매</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<%
	String product_code = request.getParameter("product_code");
    String product_name = request.getParameter("product_name");
    out.print(product_name);
    
    
%>

<body>
    <div class="container">
        <h1 class="text-center">상품 구매</h1>
        <hr>
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="purchaseComplete.jsp?product_code=<%=product_code%>" method="post">
                <!-- <form action="update.do" method="post"> -->
                    <div class="form-group">
                        <label for="productName">상품명:</label>
                        <input type="text" class="form-control" id="product_name" name="product_name" value="<%=product_name %>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="quantity">수량 선택:</label>
                        <input type="number" class="form-control" id="quantity" name="quantity" min="1" value="1" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block" >구매하기</button>
                </form>
            </div>
        </div>
    </div>
    <!-- 부트스트랩 JS 및 jQuery 링크 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
