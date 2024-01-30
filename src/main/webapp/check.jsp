<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	boolean passOrFail = (boolean)session.getAttribute("passOrFail");
	if(passOrFail){
		response.sendRedirect("product.do");
	} else {
		response.sendRedirect("login.do");
		
	}

%>

