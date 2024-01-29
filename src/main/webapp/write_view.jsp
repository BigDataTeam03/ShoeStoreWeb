<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성하기</title>

<!-- 부트스트랩 CSS 링크 -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        padding: 20px;
    }
    .container {
        max-width: 600px;
        margin: 0 auto;
    }
    form {
        background-color: #f9f9f9;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    form input[type="text"], form input[type="file"] {
        margin-bottom: 10px;
    }
    form input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
    }
    form input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>

</head>
<% int total = Integer.parseInt(request.getParameter("totalProductNumber"))+1; out.print(total); %>
<body>

<div class="container">
    <h2 class="mb-4" style="text-align: center;">상품 등록하기</h2>
    <form action="write.do" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="product_code">상품코드:</label>
            <input type="text" class="form-control" name="product_code" size="10" value="<%=total%>" readonly="readonly">
        </div>
        <div class="form-group">
            <label for="product_name">상품명:</label>
            <input type="text" class="form-control" name="product_name" size="10" value="에어포스">
        </div>
        <div class="form-group">
            <label for="product_color">색깔:</label>
            <input type="text" class="form-control" name="product_color" size="10" value="검정">
        </div>
        <div class="form-group">
            <label for="product_qty">수량:</label>
            <input type="text" class="form-control" name="product_qty" size="10" value="123">
        </div>
        <div class="form-group">
            <label for="product_size">사이즈:</label>
            <input type="text" class="form-control" name="product_size" size="10" value="275">
        </div>
        <div class="form-group">
            <label for="product_price">가격:</label>
            <input type="text" class="form-control" name="product_price" size="10" value="63000">
        </div>
        <div class="form-group">
            <label for="filename">이미지:</label>
            <input type="file" class="form-control-file" name="filename" size="20">
        </div>
        <input type="submit" class="btn btn-primary" value="등록">
    </form>
</div>

<!-- 부트스트랩 JS 및 jQuery 링크는 생략 -->

</body>
</html>
