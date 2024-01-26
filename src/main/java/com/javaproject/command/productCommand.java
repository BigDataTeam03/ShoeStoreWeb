package com.javaproject.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.dao.ProductDao;
import com.javaproject.dao.UserDao;
import com.javaproject.dto.ProductDto;
import com.javaproject.dto.UserDto;

public class productCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("product command 를 실행합니다");
		ProductDao dao = new ProductDao();
		ArrayList<ProductDto> resultArray	=	dao.productImageFetch();
		HttpSession	session = request.getSession();
		System.out.println("product Dao 를 실행했다");
		for(int i =0; i <resultArray.size(); i++) {
				System.out.println(resultArray.get(i).getProduct_name());
//				System.out.println(	resultArray.get(i).getImageFilePath());
		}
		
		session.setAttribute("product_list",resultArray);
		
	
		
	}

}
