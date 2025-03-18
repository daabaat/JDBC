

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
			
		case "selectall":
			selectAllProduct(request,response);
			break;
			
		case "deleteid":
			deleteProduct(request,response);
			break;
			
		case "updateid":
			updateProduct(request,response);
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
	
	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try {
			int result = dao.deleteProduct(Integer.parseInt(id));
			System.out.println("성공");
			System.out.println("삭제"+ result);
		} catch (SQLException e) {
			System.out.println("실패");
			System.out.println(e);
		}
		
	}
	
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
	
	protected void selectAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<ProductDTO> list = dao.selectAll();
			System.out.println("성공");
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		} catch (SQLException e) {
			System.out.println("실패");
			System.out.println(e);
		}
		
	}
	
	protected void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDTO dto = new ProductDTO();
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		int price = Integer.parseInt(request.getParameter("price"));
		int stockQuantity = Integer.parseInt(request.getParameter("stockquantity"));
		int id = Integer.parseInt(request.getParameter("id"));
	
		dto.setName(name);
		dto.setCategory(category);
		dto.setPrice(price);
		dto.setBrand(brand);
		dto.setStockQuantity(stockQuantity);
		dto.setProductId(id);
		
		try {
			int size = dao.updateProduct(dto);
			System.out.println("성공");
			System.out.println(size);
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
