
package ecomerce;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    private Connection connection;

    public BillDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to get all cart items (sum quantity for duplicates)
    public List<AddCartBean> getCartItems() throws SQLException {
    	
        List<AddCartBean> cartItems = new ArrayList<>();
        String sql = "SELECT PCODE, PNAME, PRICE, SUM(STOCK) AS TOTAL_STOCK " +
                     "FROM cart " +
                     "WHERE PNAME IS NOT NULL AND PRICE > 0 " +
                     "GROUP BY PCODE, PNAME, PRICE";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String pcode = resultSet.getString("PCODE");
            String pname = resultSet.getString("PNAME");
            double price = resultSet.getDouble("PRICE");
            int totalStock = resultSet.getInt("TOTAL_STOCK");

            cartItems.add(new AddCartBean());
        }

        return cartItems;
    }
}
