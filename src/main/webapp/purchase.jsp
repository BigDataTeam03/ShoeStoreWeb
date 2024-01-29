<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>상품 구매</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<%
    String product_name = request.getParameter("product_name");
    out.print(product_name);
%>

<body>
    <div class="container">
        <h1 class="text-center">상품 구매</h1>
        <hr>
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="purchase_process.jsp" method="post">
                    <div class="form-group">
                        <label for="productName">상품명:</label>
                        <input type="text" class="form-control" id="product_name" name="product_name" value="<%=product_name %>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="color">색상 선택:</label>
                        <select class="form-control" id="color" name="color">
                            <option value="Red">빨강</option>
                            <option value="Blue">파랑</option>
                            <option value="Green">초록</option>
                            <option value="Yellow">노랑</option>
                            <!-- 다른 색상 옵션들을 필요에 따라 추가 -->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="size">사이즈 선택:</label>
                        <select class="form-control" id="size" name="size">
                            <option value="Small">S</option>
                            <option value="Medium">M</option>
                            <option value="Large">L</option>
                            <!-- 다른 사이즈 옵션들을 필요에 따라 추가 -->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="quantity">수량 선택:</label>
                        <input type="number" class="form-control" id="quantity" name="quantity" min="1" value="1" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">구매하기</button>
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
