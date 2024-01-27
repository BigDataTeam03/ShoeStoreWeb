<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Image</title>
</head>
<body>
<h1 style="color:red" align="center"> ADD IMAGE DETAIL </h1>


<div align="center">

<form action="AddImage" method="post" enctype="multipart/form-data">
	SELECT IMAGE: 
	<input type="file" name="image">
	<input type="submit" value="Add Image">


</form>


</div>




</body>
</html>