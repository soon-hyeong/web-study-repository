package step2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTestServlet1
 */
@WebServlet("/context-test1")
public class ServletContextTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 응답시 컨텐트 타입을 설정, 브라우저에게 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
		response.setContentType("text/html;charset=UTF-8");
		// HTML을 부라우저로 전송하기 위한 출력 스트림
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ServletContextStudy1</title>");
		out.println("<body bgcolor=yellow>");
		String securityInfo = this.getServletConfig().getServletContext().getInitParameter("securityConfigInfo");
		out.println("<h3>ServletContextTestServlet1</h3>");
		out.println("ServletContext의 securityInfo:" + securityInfo);
		/************ServletContextListner에서 할당한 보안 정보를 반환***********/
		String securityRoleInfo=this.getServletConfig().getServletContext().getAttribute("securityRoleInfo").toString();
		out.println("<br><br><strong>" + securityRoleInfo + "</strong>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();
	}

}
