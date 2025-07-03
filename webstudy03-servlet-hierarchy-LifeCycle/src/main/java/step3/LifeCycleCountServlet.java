package step3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleCountServlet
 */
@WebServlet("/life-count")
public class LifeCycleCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LifeCycleCountServlet() {
		super();
		System.out.println(getClass() + "객체 생성");
	}

	private int count; // 0으로 초기화
	@Override
	public void init() throws ServletException {
		System.out.println(getClass() + "init()" + count++);
	}

	@Override
	public void destroy() {
		System.out.println(getClass() + "destroy()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		// 응답시 컨텐트 타입을 설정, 브라우저에게 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet LifeCycle</title>");
		out.println("<body>");
		out.println("<h1>접속수" + count + "</h1>");
		count++;
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();
	}

}
