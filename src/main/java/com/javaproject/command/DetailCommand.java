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
		
				ProductDao dao = new ProductDao();
				dao.purchaseDetail(String selectedProductName);
				ArrayList<ProductDto> DetailResult = dao.purchaseDetail(String selectedProductName);
				HttpSession	session = request.getSession();
				
				session.setAttribute("DetailResult", DetailResult);
		

	}

}
