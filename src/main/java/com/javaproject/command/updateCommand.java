package com.javaproject.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.dao.ProductDao;
import com.javaproject.dto.ProductDto;

public class updateCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("update command실행 시작");
		
		ProductDao updateDao = new ProductDao();
//		dao.update();
		HttpSession	session = request.getSession();
		
//		System.out.println("혹시 여기?");
		int select_code  = Integer.parseInt((String )session.getAttribute("select_code"));
//		System.out.println("아니면 여기?");
		int select_qty   = Integer.parseInt((String)session.getAttribute("select_qty"));
		updateDao.update(select_code,select_qty);
		
	}

}
