<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	boolean passOrFail = (boolean)session.getAttribute("passOrFail");
	boolean adminLogin = (boolean)session.getAttribute("adminLogin");
	

	if(passOrFail){
		
		if(adminLogin){
			response.sendRedirect("list.do");
			
		}else{
		
			response.sendRedirect("product.do");
		}
	} else {
		response.sendRedirect("login.do");
		
	}

%>

