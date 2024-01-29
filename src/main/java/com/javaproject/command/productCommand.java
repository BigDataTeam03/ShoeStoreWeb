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
		
		
		System.out.println("product command실행 시작");
		
		ProductDao dao = new ProductDao();
		ArrayList<ProductDto> resultArray	=	dao.productImageFetch();
		HttpSession	session = request.getSession();
		
		
		System.out.println("product Dao 실행 완료.");
		session.setAttribute("product_list",resultArray);

		
		
		
		
		
		
		
		
	// <<Result array 의 내용물을 확인하는 test code// 
		
//		for(int i =0; i <resultArray.size(); i++) {
//			
//				System.out.println(resultArray.get(i).getProduct_name());
//				System.out.println("파일의 이미지 패스 입니다. ");
//				System.out.println(	resultArray.get(i).getImageFilePath());
//				
//		}
		
		//세션에 product dao 에서 가져온 결과물인 dto array list를 저장함. 
		
		
		
		// 안되서 실행해본 이미지 하나로 하는테스트 코드들 .
//		session.setAttribute("imageFilePath", resultArray.get(0).getProduct_color());
//		
//		System.out.println(	session.getAttribute("imageFilePath"));
//		
//		
//
//		String webAppPath = request.getSession().getServletContext().getRealPath("/");
//		
//		System.out.println("웹앱패쓰" +webAppPath);

		//session.setAttribute("webAppPath",webAppPath+"Screenshot 2024-01-18 at 11.28.44 PM.png");
		
		
		
	}
	


}
