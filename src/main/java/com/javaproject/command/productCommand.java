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
				System.out.println("파일의 이미지 패스 입니다. ");
				
				System.out.println(	resultArray.get(i).getImageFilePath());
		}
		
		session.setAttribute("product_list",resultArray);
		session.setAttribute("imageFilePath", resultArray.get(0).getProduct_color());
		System.out.println(	session.getAttribute("imageFilePath"));
		
		

		String webAppPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println("웹앱패쓰" +webAppPath);

	session.setAttribute("webAppPath",webAppPath+"Screenshot 2024-01-18 at 11.28.44 PM.png");
		
		
		
	}
	


}
