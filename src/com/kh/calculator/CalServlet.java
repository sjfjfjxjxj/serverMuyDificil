package com.kh.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		int firstNum = Integer.parseInt(request.getParameter("first-num"));
		String opCode=request.getParameter("op-code");
		int secondNum = Integer.parseInt(request.getParameter("second-num"));
		//프론트에서 백엔드(서버)로 데이터 넘어옴(받는 프로퍼티는 네임ㅇㅇ)
		int result = 0;
		//두개 값을 연산한 결과값을 사용자에게 전송
		switch(opCode) {
		case "+" : result = firstNum + secondNum; break;
		case "-" : result = firstNum - secondNum; break;
		case "x" : result = firstNum * secondNum; break;
		case "/" : result = firstNum / secondNum; break;
		case "%" : result = firstNum % secondNum; break;
		}
		//jsp에 자바코드 작성해 웹페이지 구성할수 있지만 사용x(Model1방식)
		//jsp는 MVC패턴에서 View역할을 할건데,
		//그러기위해 Servlet에서 JSP로 결과값 보내줘야해.
		//앞으로는 JSP로 데에터 보내주는 코드를 작성할 것.
		//1. JSP에서 쓸 데이터를 request에 저장(request는 전역변수처럼 사용)
		// , 컨테이너가 동작하는동안 생성되어 있으므로)
		request.setAttribute("result", result);
		//2. 어떤 JSP에서 request에 set한 데이터를 사용할지 지정해줌(JSP파일은 많으니깐)
		RequestDispatcher view = request.getRequestDispatcher("/calculator/output.jsp");
		view.forward(request, response);
		
		//~이 스트림 여는 방식은 안쓸거다. out.println부분을 떼서 jsp파일로 보낼것~
		//result = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
		//스트림 통해 페이지 만들어 응답함
//		PrintWriter out = response.getWriter(); // 스트림임ㅇㅇ
//		out.println("<html><head><title>계산결과</title></head>");
//		out.println("<body>result:");
//		out.println("<strong>" + result + "</strong>");
//		out.println("</body></html>");
		//System.out.println("1: "+firstNum+"연산자 : " + opCode + "2 : "+ secondNum);
				
	}
}
