package org.kosa.myproject.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Front Controller Design Pattern : 모든 클라이언트 요청을 하나의 진입점으로 모아서 처리 Spring에서는
 * DispatherServlet 이 Front Controller 역할을 한다
 * 
 * ver2 : 메서드별로 역할을 분리, 단일 책임 원칙 적용
 * 
 * ver3 : 요청 처리 전담 작업을 별도의 클래스로 전담시킴, 단일 책임 원칙을 강화
 */
@WebServlet("/FrontControllerServletVer3")
public class FrontControllerServletVer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String requestType = request.getParameter("requestType");
			// System.out.println(requestType);
			if (requestType != null && requestType.equals("findbyid")) {
				FindCustomerByController controller = new FindCustomerByController();
				String path = controller.findCustomerById(request, response);
				request.getRequestDispatcher(path).forward(request, response);
			} else if (requestType != null && requestType.equals("registerCustomer")) {
				// register(request, response);
			}
		} catch (Exception e) { // 예외 처리 로직을 Front에게 일관성 있게 정의, 이후 유지보수성도 향상
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doDispatch(request, response);
	}

}
