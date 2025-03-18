

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("action");
		
		switch(act) {
		case "write":
			writeProduct(request, response);
			break;
			
		case "selectid":
			selectProduct(request,response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	ProductDAO dao = new ProductDAOImpl();
	
	protected void selectProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try {
			ProductDTO dto = dao.selectProduct(Integer.parseInt(id));
			System.out.println("성공" + dto.toString());
		} catch (SQLException e) {
			System.out.println("실패");
			System.out.println(e);
		}
		
	}
	
	protected void writeProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDTO dto = new ProductDTO();
		
		dto.setName("컴퓨터");
		dto.setCategory("가전");
		dto.setPrice(3000);
		dto.setBrand("삼성");
		dto.setStockQuantity(10);
		
		try {
			dao.insertProduct(dto);
			System.out.println("성공");
		} catch (SQLException e) {
			System.out.println("실패");
			System.out.println(e);
		}
		
	}
}
