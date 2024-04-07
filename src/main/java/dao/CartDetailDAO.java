package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import model.CartDetail;
import model.Product;

public class CartDetailDAO {
	public boolean addCartDetail(CartDetail cartDetail) {
        String sql = "INSERT INTO cart_detail (Cart_id, product_id,c_quantity, totalmoney,cart_detail_id) VALUES (?, ?, ?,? ,?)";
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cartDetail.getCartId());
            statement.setInt(2, cartDetail.getProduct().getpId()); // Giả sử có phương thức getId() trong lớp Product
            statement.setInt(3, cartDetail.getQuantity());
            statement.setDouble(4, cartDetail.getTotalMoney());
            statement.setInt(5, cartDetail.getCartDetailId());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public int getMaxCart_DetailId() {
	    String sql = "SELECT MAX(cart_detail_id) AS maxId FROM cart_detail";
	    try (Connection connection = DBContext.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getInt("maxId");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	
	public boolean updateCartDetailQuantity(int cartId, int productId, int newQuantity, double totalmoney) {
	    String sql = "UPDATE cart_detail SET c_quantity = ? , totalmoney = ? WHERE Cart_id = ? AND product_id = ?";
	    try (Connection connection = DBContext.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	       
	        statement.setInt(1, newQuantity);
	        statement.setDouble(2, totalmoney);
	        statement.setInt(3, cartId);
	        statement.setInt(4, productId);

	        int rowsUpdated = statement.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	

	public static void main(String[] args) {
//		ProductDAO pdb = new ProductDAO();
//		Product product = pdb.getProductById(1);
//		System.out.println(product);
//		
//		CartDetail cartDetail = new CartDetail();
//        cartDetail.setCartId(103); // Thiết lập ID của giỏ hàng
//        cartDetail.setProduct(product); // Thiết lập sản phẩm
//        cartDetail.setQuantity(10); // Thiết lập số lượng
//        cartDetail.setTotalMoney(product.getPprice() * cartDetail.getQuantity()); // Tính toán tổng tiền dựa trên giá và số lượng
//
//        // Sử dụng CartDetailDAO để thêm CartDetail vào cơ sở dữ liệu
//        CartDetailDAO cartDetailDAO = new CartDetailDAO();
//        boolean success = cartDetailDAO.addCartDetail(cartDetail);
//        
//        if (success) {
//            System.out.println("Thêm CartDetail thành công.");
//        } else {
//            System.out.println("Thêm CartDetail thất bại.");
//        }
	}
}
