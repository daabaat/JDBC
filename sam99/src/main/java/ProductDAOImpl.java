import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void insertProduct(ProductDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO products (name, category, brand, price, stock_quantity) VALUES"
				+ "(?, ?, ?, ?, ?); ";
		try { 
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getCategory());
			stmt.setString(3, dto.getBrand());
			stmt.setInt(4, dto.getPrice());
			stmt.setInt(5, dto.getStockQuantity());
			int size = stmt.executeUpdate();
			System.out.println("size : " + size);
		}finally {
			DBUtil.close(stmt, conn);
		}
	}

	@Override
	public ProductDTO selectProduct(int id) throws SQLException {
		ProductDTO dto = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM products WHERE product_id = ?;";
		ResultSet rst = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rst = stmt.executeQuery();
			if(rst.next()) {
				dto = new ProductDTO();
				dto.setProductId(id);
				dto.setName(rst.getString(2));
				dto.setCategory(rst.getString(3));
				dto.setBrand(rst.getString(4));
				dto.setPrice(rst.getInt(5));
				dto.setStockQuantity(rst.getInt(6));
			}
		}finally {
			DBUtil.close(rst, stmt, conn);
		}
		return dto;
	}

}
