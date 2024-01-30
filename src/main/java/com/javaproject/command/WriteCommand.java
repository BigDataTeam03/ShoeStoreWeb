package com.javaproject.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.javaproject.dao.AdminDao;
import com.javaproject.dao.ProductDao;
import com.javaproject.dto.ProductDto;
import com.mysql.cj.Session;



public class WriteCommand implements ShoeCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		System.out.println("write command 를 실행합니다.");
		
		// write_view.jsp의 request를 받아서 table에 insert 한다.
		
		int pcode = Integer.parseInt(request.getParameter("product_code"));

		
		String pName = request.getParameter("product_name");
		String pColor = request.getParameter("product_color");
		int pQty = Integer.parseInt(request.getParameter("product_qty"));
		int pSize = Integer.parseInt(request.getParameter("product_size"));
		int pPrice = Integer.parseInt(request.getParameter("product_price"));
		
		String pDetail = pName+ "_"+ pColor + "_"+ pSize;
		
		AdminDao insertDao = new AdminDao();
		
		
		 try {
	            Part filePart = request.getPart("filename"); // "filename"은 폼에서 정의한 파일 업로드 필드의 이름
	            String fileName = filePart.getSubmittedFileName();
	            insertDao.write(pcode, pName, pColor, pQty, pSize, pPrice,pDetail,fileName);
	            String uploadPath = "/Users/forrestdpark/Desktop/JavaProgram/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShoeStoreWeb_big3/ShoeImage/"; // 실제 서버 경로로 변경해야 합니다.
	            String filePath = uploadPath + fileName;
	            filePart.write(filePath);
	            System.out.println("이미지 업로드 성공");
	            
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("이미지 업로드 실패");
	        }
		 
		 
		 	/// 상품 이미지를 세션에 저장하기 위하여 product dao 를 실행합니다. 
			
			System.out.println("product command실행 시작");
			
			ProductDao dao = new ProductDao();
			ArrayList<ProductDto> resultArray	=	dao.productImageFetch();
			HttpSession	session = request.getSession();
			
			
			System.out.println("product Dao 실행 완료.");
			for (int i =0 ; i<resultArray.size(); i++) {
				
				System.out.println(i);
				
			}
			
			//product dao -> product command 에서 product list 가 session 저장. 
			
			session.setAttribute("product_list",resultArray);
		 
		 
		 
		 
	    }
	
		
	

		
	
	}