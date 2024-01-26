package com.javaproject.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.command.LoginCommand;
import com.javaproject.command.ShoeCommand;
import com.javaproject.command.productCommand;

/**
 * Servlet implementation class ShoeController
 */
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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String viewPage = null;
		ShoeCommand command = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command_do = uri.substring(contextPath.length());
		System.out.println(command_do);
		switch(command_do) {
		
		case("/login.do"):
			System.out.println("login command 를 실행합니다. ");
			command = new LoginCommand();
			command.execute(request, response);
			viewPage ="/login.jsp";
		
		case("/product.do"):
			System.out.println("product view command 를 실행하빈다. ");
			command= new productCommand();
			command.execute(request, response);
			System.out.println("------view page 로 넘어갑니다!!------");
			viewPage= "/product.jsp";
			
			default :
				break;
			
		}
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
					dispatcher.forward(request, response);
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//End


