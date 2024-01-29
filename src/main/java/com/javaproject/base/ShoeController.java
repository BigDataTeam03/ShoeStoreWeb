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

import com.javaproject.command.ListCommand;
import com.javaproject.command.LoginCommand;
import com.javaproject.command.ShoeCommand;
import com.javaproject.command.WriteCommand;
import com.javaproject.command.productCommand;
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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
//		// ServletContext 객체 가져오기
//        ServletContext context = getServletContext();
//
//        // 웹 애플리케이션 경로 가져오기
//        String webAppPath = context.getRealPath("/");
//        
//        // 경로 출력
//		System.out.println( "파일 경로 출력 :" + webAppPath ) ;  
//		response.getWriter().println("웹 애플리케이션 경로: " + webAppPath);
//		
			String webAppPath = request.getSession().getServletContext().getRealPath("/");
			System.out.println("웹앱패쓰" +webAppPath);
			
			
		String viewPage = null;
		ShoeCommand command = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command_do = uri.substring(contextPath.length());
		System.out.println(command_do);
		switch(command_do) {
		
		case("/login.do"):
			System.out.println("login command 실행 ");
			command = new LoginCommand();
			command.execute(request, response);
			viewPage ="/login.jsp";
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
			
		case("/write_view.do"):
			viewPage = "write_view.jsp";
			break;
	
			
		case("/write.do"):
			System.out.println("wirte do 를 실행합니다. ");
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			break;	
			
		
			default :
				break;
		
				//결제가 완료되면 남은제고에서 수량을 지움 
		case("/update.do"):
			System.out.println("update do 를 실행합니다.");
			command = new updateCommand();
			command.execute(request, response);
			viewPage = "product.do";
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		System.out.println(	session.getAttribute("imageFilePath"));
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//End


