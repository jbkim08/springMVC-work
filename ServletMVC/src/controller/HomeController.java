package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Test2Service;

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
			// 파라미터 데이터 추출
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			
			int result = number1 + number2;
			System.out.println(result);
			request.setAttribute("result", result);

			viewName = "test1.jsp";
		} else if(url.contains("test2.mvc")) {
			
			int result = Test2Service.minus(request);
			
			request.setAttribute("result", result);
			
			viewName = "test2.jsp";
		}
		
		request.getRequestDispatcher(viewName).forward(request, response);
	}

}
