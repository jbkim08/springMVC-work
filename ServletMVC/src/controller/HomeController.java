package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 요청중 .mvc로 끝나면 모두 받기
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청한 주소를 가져옴
		String url = request.getRequestURI();
		//System.out.println("요청주소 : " + url);		
		String viewName = null;
		
		if(url.contains("main.mvc")) {
			viewName = "main.jsp";
		} else if(url.contains("test1.mvc")) {
			viewName = "test1.jsp";
		} else if(url.contains("test2.mvc")) {
			viewName = "test2.jsp";
		}
		
		request.getRequestDispatcher(viewName).forward(request, response);
	}

}
