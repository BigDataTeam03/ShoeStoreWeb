package com.javaproject.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.dao.ProductDao;
import com.javaproject.dto.ProductDto;

public class DetailCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String product_details = request.getParameter("product_details");
		 
		ProductDao dao = new ProductDao();
		
		
		ArrayList<ProductDto> detailResult = dao.purchaseDetail(product_details);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("DetailResult", detailResult);

	}

}
