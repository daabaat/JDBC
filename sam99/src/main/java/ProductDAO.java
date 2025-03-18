import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
	
	void insertProduct(ProductDTO dto) throws SQLException;
	
	ProductDTO selectProduct(int id) throws SQLException;
	
	List<ProductDTO> selectAll() throws SQLException;
	
	int deleteProduct(int id)	throws SQLException;
	
	int updateProduct(ProductDTO dto) throws SQLException;
	
}
