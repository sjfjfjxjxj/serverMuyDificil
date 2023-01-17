package com.kh.checkbox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBoxServlet
 */
@WebServlet("/showResult.do") //서블렛 만들때 잊지말기
public class CheckBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBoxServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] values = request.getParameterValues("place");
		
		request.setAttribute("places", values);
		RequestDispatcher view = request.getRequestDispatcher("/checkbox/checkResult.jsp");
		view.forward(request, response);
		
		//String value = request.getParameter("place");<- 받아오는 값이 한개일때
		//for(String value : values) {
			//System.out.println("가고싶은 곳: ");
			//System.out.println(value + ",");
		//}
//		response.setContentType("text/html; charset=utf-8"); //이렇게 해줘야 한글 안깨짐
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>관광지 선택 결과</title></head>");
//		out.println("<body>");
//		out.println("<h1>관광지 선택 결과</h1>");
//		for(String value : values) {
//			out.println(value +", ");
//		}
//		out.println("</body></html>");
//		//http://127.0.0.1:8987/SuperBasicWeb/showResult.do?place=arequipa&place=bogota&place=khotao&place=havana&place=medellin
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
