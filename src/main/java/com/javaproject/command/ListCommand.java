package com.javaproject.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaproject.dao.AdminDao;
import com.javaproject.dto.AdminDto;



public class ListCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("List command 가 실행 됩니다.");
		
		AdminDao dao = new AdminDao();
		dao.list();
		ArrayList<AdminDto> dtos = dao.list();
		
		
		request.setAttribute("list", dtos);
		
		
	}

}
