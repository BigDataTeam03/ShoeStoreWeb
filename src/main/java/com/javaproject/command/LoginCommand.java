package com.javaproject.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.dao.UserDao;
import com.javaproject.dto.UserDto;
import com.mysql.cj.Session;

public class LoginCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

			UserDao dao = new UserDao();
			
			HttpSession	session = request.getSession();
			
			
		
	}

}
