package org.kosa.job.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.kosa.job.model.NewsService;

/**
 * Model2 MVC의 Controller 역할을 수행하는 서블릿
 * - 클라이언트의 요청을 분석
 * - 분석 내용에 따라 Model과 연동
 * - 연동 결과를 View와 공유하기 위한 작업
 * - 제어 이동 방식을 결정하여 응듭을 위한 view로 이동 시킨다
 */
@WebServlet("/FindNewsById")
public class FindNewsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("****" + getServletName() + "****");
		// 요청 분석
		String newsId = request.getParameter("newsId");
		// 정수형 변환 : 웹 통신시에는 텍스트로 모든 정보가 인식되므로 별도의 형 변환이 필요
		int newsId2 = Integer.parseInt(newsId);
		// 모델 연동
		String newsInfo = NewsService.getInstance().findNewsById(newsId2);
		//연동 결과를 공유	: request에 공유하는 것이 가장 적저랗다고 판단(서버 메모리 효율성)
		request.setAttribute("newsInfo", newsInfo);
		// foward방식으로 제어를 이동시켜 응답하게 한다(이유 : request와 response가 유지되어 이동 되므로 )
		//경로가 들어가면 해당 .jsp로 foward가 되는데 foward()의 매개변수의 request, response는 기존의 request와 response로 이동.
		//
		request.getRequestDispatcher("/news-view.jsp").forward(request, response);
	}

}
