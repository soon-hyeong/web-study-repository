package org.kosa.job.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.kosa.job.model.MemberDao;
import org.kosa.job.model.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test01Servlet
 */
@WebServlet("/Test01Servlet")
public class Test01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			String id = request.getParameter("id");
			MemberDao memberDao = MemberDao.getInstance();
			MemberVO vo  = memberDao.findMemberById(id);
			request.setAttribute("member", vo);
			// forward 방식이므로 request, response 유지
			request.getRequestDispatcher("/step1-el.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
