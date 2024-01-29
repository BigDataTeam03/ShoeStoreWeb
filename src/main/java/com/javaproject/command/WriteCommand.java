package com.javaproject.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.javaproject.dao.AdminDao;



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
		AdminDao insertDao = new AdminDao();
		
		
		 try {
	            Part filePart = request.getPart("filename"); // "filename"은 폼에서 정의한 파일 업로드 필드의 이름
	            String fileName = filePart.getSubmittedFileName();
	            insertDao.write(pcode, pName, pColor, pQty, pSize, pPrice,fileName);// TODO Auto-generated method stub
	            //String uploadPath = "/Users/dianakim/Desktop/2024.01.29_ shoeStore_semiver2.0/ShoeStoreWeb/src/main/webapp/ShoeImage/"; // 실제 서버 경로로 변경해야 합니다.
	            String uploadPath = "/Users/forrestdpark/Desktop/JavaProgram/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShoeStoreWeb_big3/ShoeImage/"; // 실제 서버 경로로 변경해야 합니다.
	            String filePath = uploadPath + fileName;
	            filePart.write(filePath);
	            System.out.println("이미지 업로드 성공");
	            
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("이미지 업로드 실패");
	        }
	    }
	}