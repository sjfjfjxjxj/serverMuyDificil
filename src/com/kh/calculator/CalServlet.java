package com.kh.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalServlet
 */
@WebServlet("/operating.do")
public class CalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


//서블릿은 꼭 서버 끈 상태로 해야된대...
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstNum = request.getParameter("first-num");
		String opCode=request.getParameter("op-code");
		String secondNum = request.getParameter("second-num");
		//프론트에서 백엔드(서버)로 데이터 넘어옴
		int result = 0;
		//두개 값을 연산한 결과값을 사용자에게 전송
		result = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
		//스트림 통해 페이지 만들어 응답함
		PrintWriter out = response.getWriter(); //스트림임ㅇㅇ
		out.println("<html><head><title>계산결과</title></head>");
		out.println("<body>result:");
		out.println("<strong>"+result+"</strong>");
		out.println("</body></html>");
		//System.out.println("1: "+firstNum+"연산자 : " + opCode + "2 : "+ secondNum);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
