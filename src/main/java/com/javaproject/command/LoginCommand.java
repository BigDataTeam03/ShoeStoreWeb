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
			UserDto resultDto	=	dao.testDao();
			HttpSession	session = request.getSession();
			
			System.out.println("다오를 실행한 결과입니다. ");
			System.out.println(resultDto.getCust_id());
			
			session.setAttribute("CUSTNAME", resultDto.getCust_id());
			
		
	}

}
