package com.javaproject.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.dao.UserDao;
import com.javaproject.dto.UserDto;

public class CheckCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String userId = request.getParameter("username");
		String userPw = request.getParameter("password");
		
		UserDao dao = new UserDao();
		boolean idCheckResult	= dao.checkUserId(userId);
		HttpSession	session = request.getSession();
		
		System.out.println("다오를 실행한 결과입니다. ");
		System.out.println(idCheckResult);
		
		session.setAttribute("idCheckResult", idCheckResult);
		
		if(idCheckResult == true ) {
			boolean pwCheckResult	= dao.checkUserPw(userPw);
		
			if(pwCheckResult) {
				System.out.println("환영합니다");
				
				session.setAttribute("passOrFail", true);
				
				if(userId.equals("admin")&& userPw.equals("1234")) {
					
					session.setAttribute("adminLogin", true);
					
				}else {
					session.setAttribute("adminLogin", false);
				}
				
			}else {
				session.setAttribute("passOrFail", false);
			}
		} else {
			session.setAttribute("passOrFail", false);
		}
			
	}

}
