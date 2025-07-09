package org.kosa.myproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

/**
 * Front Controller Design Pattern : 모든 클라이언트 요청을 하나의 진입점으로 모아서 처리 Spring에서는
 * DispatherServlet 이 Front Controller 역할을 한다
 * 
 * ver2 : 메서드별로 역할을 분리, 단일 책임 원칙 적용
 */
@WebServlet("/FrontControllerServletVer2")
public class FrontControllerServletVer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void findCustomerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트 요청 분석 : 클라이언트로부터 고객 아이디를 받아 온다
		// MockDao와 연동한다
		// 고객이 존재하면 고객정보를 request에 공유하여 foward로 응답한다
		// 고객이 존재하지 않으면 rediret 방식으로 응답한다
		String customerId = request.getParameter("customerId");

		CustomerVo vo = MockDao.getInstance().findCustomerById(customerId);
		if (vo == null) {
			response.sendRedirect("findbyid-fail.jsp");
		} else {
			request.setAttribute("customerVo", vo);
			request.getRequestDispatcher("findbyid-ok.jsp").forward(request, response);
		}
	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MockDao.getInstance().registerCustomer(new CustomerVo(request.getParameter("id"),
				request.getParameter("name"), request.getParameter("address")));
		response.sendRedirect("register-result.jsp");
	}

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String requestType = request.getParameter("requestType");
			// System.out.println(requestType);
			if (requestType != null && requestType.equals("findbyid")) {
				findCustomerById(request, response);
			} else if (requestType != null && requestType.equals("registerCustomer")) {
				register(request, response);
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
