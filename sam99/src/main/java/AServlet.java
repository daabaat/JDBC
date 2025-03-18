

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AServlet
 */
@WebServlet(urlPatterns = {"/aa","/bb"})
public class AServlet extends HttpServlet {
	int a;
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
		super.destroy();
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		doGet(req,res);	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String s = null;
//		System.out.println(s.length());
		a++;
		System.out.println("do get");
		System.out.println("get a : "+ a);
//		String data = request.getParameter("a");
//		System.out.println("data : "+ data);
//		String[] arr = request.getParameterValues("a");
//		System.out.println(arr.length);
		System.out.println(request.getContextPath());
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		response.setContentType("text/html;charset=utf-8");
		response.getOutputStream();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
