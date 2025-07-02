package step1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 * 서블릿을 구현하기 위해서는 일반적으로 HttpServlet class를 
 * 상속받는다 (만댝 다른 프로토콜(ex - FTP)을 위해서는 GenericServlet을 상속 받을 수도 있다
 * HttpServlet : HTTP 기반의 자바 웹 어플리케이션을 잘 개발할 수 있도록 지원하는 abstract class
 */
// @에너테이션 : 자바의 의미있는 주석
// 컴파일 또는 런타임에 영향주는 주석으로 메타 데이터를 기술
// 아래 HelloServlet 이라는 웹 프로그램을 클라이언트가 실행하기 위한 url을 제공하는 역할
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * doGet(): 클라이언트 Get 요청을 처리하는 메서드
	 * 클라잉언트(브라우저)에서 직접 url을 명시하거나 링크, 폼 등을 이용해 호출시 실행
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답시 컨텐트 타입을 설정, 브라우저에게 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
		response.setContentType("text/html;charset=UTF-8");
		// HTML을 부라우저로 전송하기 위한 출력 스트림
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Study</title>");
		out.println("<body bgcolor=yellow>");
		out.println("<h3>Hello Servlet</h3>");
		// client 가 보낸 데이터를 받아 온다
//		<a href="helloServlet?postNo=7">게시글 보기 </a>
//		postNo : name, 7 : value
//		name을 명시하면 그에 따른 value가 반환됨
		String pageNo = request.getParameter("postNo");
		String userName = request.getParameter("userName");
		out.println("페이지 번호:" + pageNo);
		out.println("<br>");
		out.println("유저 이름:" + userName);
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();
	}

}
