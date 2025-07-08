package org.kosa.job.controller;

import java.io.IOException;
import java.util.List;

import org.kosa.job.model.NewsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewsListServlet
 */
@WebServlet("/NewsList")
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> newsList = NewsService.getInstance().findNewsList();
		request.setAttribute("newsList", newsList);
		// 뉴스 리스트를 클라이언트에게 보여주면 되므로
		// request에 공유하여 응답하는 것이 가장 적절request가 유지되면서 제어 이동하는 방식이 foward댜ㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑ
		request.getRequestDispatcher("news-list.jsp").forward(request, response);
	}

}
