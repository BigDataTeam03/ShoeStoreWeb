package com.javaproject.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.dao.UserDao;
import com.javaproject.dto.UserDto;

public class registerCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			HttpSession	session = request.getSession();
			
	        String cust_id = 	request.getParameter("cust_id");
	        String cust_pw = 	request.getParameter("cust_pw");
	        String cust_name =  request.getParameter("cust_name");
	        String cust_telno = request.getParameter("cust_telno");
	        
	        //db 에 넣는다. 
	        UserDto newUser = new UserDto(cust_id, cust_pw, cust_name, cust_telno);
	       
	        session.setAttribute("newUser", newUser);	
	        
	        UserDao dao = new UserDao();
	        dao.register(cust_id, cust_pw, cust_name, cust_telno);

	        	 
 
     
		
		
		
	}

}
