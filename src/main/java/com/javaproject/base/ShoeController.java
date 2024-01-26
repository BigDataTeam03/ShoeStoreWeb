package com.javaproject.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.javaproject.command.ListCommand;


/**
 * Servlet implementation class ShoeController
 */
@WebServlet("/ShoeController")
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
		
		 
		
		
		ListCommand command = null;
		String viewPage = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command_do = uri.substring(contextPath.length());
		
		switch(command_do) {
		
		case("/list.do"):
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
			
		default:
			break;
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); 
		dispatcher.forward(request, response); 
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//End


