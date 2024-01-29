<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<% int total = Integer.parseInt(request.getParameter("totalProductNumber"))+1;
out.print(total);

%>

</head>
<body>

<h2>글작성</h2>

	<form action="write.do" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
		상품코드: <input type="text" name="product_code" size="10" value ="<%=total%>" readonly="readonly"><br>
		상품명 : <input type="text" name="product_name" size="10" value = "111"><br>
		색깔 : <input type="text" name="product_color" size="10"  value = "111"><br>
		수량 : <input type="text" name="product_qty" size="10" value = "111"><br>
		사이즈 : <input type="text" name="product_size" size="10" value = "111"><br>
		가격 : <input type="text" name="product_price" size="10" value = "111"><br>
		이미지 : <input type="file" name="filename" size="20" value = "111"><br/>	
		<input type="submit" value="등록">
	</form>
		
	
	














</body>
</html>