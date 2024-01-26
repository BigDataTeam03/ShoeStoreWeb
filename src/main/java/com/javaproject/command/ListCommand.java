package com.javaproject.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.admin_dao.AdminDao;
import com.javalec.admin_dto.AdminDto;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		dao.list();
		ArrayList<AdminDto> dtos = dao.list();
		request.setAttribute("list", dtos);
		
		
	}

}
