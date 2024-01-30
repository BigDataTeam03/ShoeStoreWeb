package com.javaproject.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.command.CheckCommand;
import com.javaproject.command.ListCommand;
import com.javaproject.command.LoginCommand;
import com.javaproject.command.ShoeCommand;
import com.javaproject.command.WriteCommand;
import com.javaproject.command.productCommand;
import com.javaproject.command.registerCommand;
import com.javaproject.command.updateCommand;

/**
 * Servlet implementation class ShoeController
 */

@MultipartConfig
@WebServlet("*.do")
public class ShoeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Description : Controller of shoe store web ver.3.0
		 * Author : Forrest D Park
		 * Date : 2024.01.30
		 * Update  2024.01.30 by D Park
		 * 		1. Login check 화면 완성 컨트롤러 추가 
		 * 
		 */
		
		
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		
		String webAppPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println("웹앱패쓰" +webAppPath);
			
			
		String viewPage = null;
		ShoeCommand command = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command_do = uri.substring(contextPath.length());
		System.out.println(command_do);
		switch(command_do) {
		
		// 로그인 실행 
		case("/login.do"):
			System.out.println("login command 실행 ");
			command = new LoginCommand();
			command.execute(request, response);
			viewPage ="/login.jsp";
			break;
		
		// 유저가 맞는지 확인 
		case("/check.do"):
			System.out.println("check command 를 실행합니다. ");
			command = new CheckCommand();
			command.execute(request, response);
			viewPage ="/check.jsp";
			break;
			
			
		// 유저가 보는 상품 목록
		case("/product.do"):
			System.out.println("product view command 실행 ");
			command= new productCommand();
			command.execute(request, response);
			
			viewPage= "/product.jsp";
			break;
		// 관리자가 보는 상품 목록
		case("/list.do"):
			command = new ListCommand();
			command.execute(request, response); 
			viewPage = "/list.jsp"; 
			break;
			
		// 상품입력후 결과 
		case("/write_view.do"):
			viewPage = "write_view.jsp";
			break;
	
		// 상품 입력 
		case("/write.do"):
			System.out.println("wirte do 를 실행합니다. ");
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			break;
			
			
		// 회원가입
		case ("/register.do"):
		    System.out.println("register command를 실행합니다.");
		    command = new registerCommand();
		    command.execute(request, response);
		    viewPage = "login.jsp";
		    break;
		
			
		
		//결제가 완료되면 남은제고에서 수량을 지움 
		case("/update.do"):
			System.out.println("update do 를 실행합니다.");
			command = new updateCommand();
			command.execute(request, response);
			viewPage = "product.do";
			break;
			
		default :
			break;
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		System.out.println(	session.getAttribute("imageFilePath"));
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//End


