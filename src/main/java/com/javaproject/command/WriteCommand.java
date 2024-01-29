package com.javaproject.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.javaproject.dao.AdminDao;



public class WriteCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// write_view.jsp의 request를 받아서 table에 insert 한다.
		String pName = request.getParameter("product_name");
		String pColor = request.getParameter("product_color");
		int pQty = Integer.parseInt(request.getParameter("product_qty"));
		int pSize = Integer.parseInt(request.getParameter("product_size"));
		int pPrice = Integer.parseInt(request.getParameter("product_price"));
		
		AdminDao dao = new AdminDao();
		dao.write(pName, pColor, pQty, pSize, pPrice);// TODO Auto-generated method stub

	}

}
