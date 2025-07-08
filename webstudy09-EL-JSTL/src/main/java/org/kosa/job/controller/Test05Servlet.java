package org.kosa.job.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.kosa.job.model.MemberDao;
import org.kosa.job.model.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test05Servlet
 */
@WebServlet("/Test05Servlet")
public class Test05Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// parameter form이라던지, 쿼리스트링이라던지 클라이언트에서 전송받은 것
		// attribute 서버의 객체
		try {
			List<MemberVO> list = MemberDao.getInstance().findMemberByAddress((String)request.getParameter("address"));
			request.setAttribute("list", list);
			request.getRequestDispatcher("step5-jstl-forEach-member-list.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
