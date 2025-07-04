package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답시 컨텐트 타입을 설정, 브라우저에게 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Set Cookie Study</title>");
				out.println("<body bgcolor=yellow>");
				out.println("<h3>Set Cookie Study</h3>");
				String time = new Date().toString().replace(" ", "-");
				Cookie cookie = new Cookie("testCookie", time);
				cookie.setMaxAge(60); // n초 동안 유지
				response.addCookie(cookie); // 응답시 쿠키가 전송되도락 한다
				out.println("cookie를 생성해 클라이언트에 전송<br><br>");
				out.println("<br><br><a href=index.html>home으로</a><br><br>");
				out.println("</body>");
				out.println("</head>");
				out.println("</html>");
				out.close();
	}

}
