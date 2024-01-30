<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>구매 완료</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f4f4;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
        .btn {
            margin-top: 20px;
        }
    </style>
</head>

<%
	String code = request.getParameter("product_code");
	String product_name = request.getParameter("product_name");
	String qty = request.getParameter("quantity");

	session.setAttribute("select_code",code);
	session.setAttribute("select_qty", qty);

%>
<body>

<div class="container">
    <h1><%=product_name %> <%=qty %> 개 구매가 완료되었습니다!</h1>
    <p>구매해 주셔서 감사합니다.</p>
    <form action="update.do" method="post">
    		<input class="btn btn-primary" type="submit" value="홈으로 돌아가기">
    </form>
    <!-- <a href="update.do" class="btn btn-primary" >홈으로 돌아가기</a> -->
</div>

</body>
</html>
