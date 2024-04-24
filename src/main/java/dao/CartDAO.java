package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Cart;
// import model.User;
import model.CartDetail;
import model.Product;

public class CartDAO {	
	public boolean addCart(Cart cart)
	{
		String sql = "insert into cart (id, user_id) values(? , ?)";
		try (	
				Connection connection = DBContext.getConnection();
	            PreparedStatement st = connection.prepareStatement(sql)) {

	            System.out.println("Trong phần add Cart");
	            st.setInt(1, cart.getCartId());
	            st.setInt(2, cart.getUser_Id());
	            int rowsInserted = st.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            System.out.println("Lỗi trong addCart: " + e.getMessage());
	            return false;
	        }
	    }
	
	public int getMaxCartId() {
	    String sql = "SELECT MAX(id) AS maxId FROM cart";
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
	
	
	 public List<Product> getProductOnCDT(List<CartDetail> list) {
	        List<Product> listProduct = new ArrayList<>();
	        for (CartDetail cartDetail : list) {
	            listProduct.add(cartDetail.getProduct());
	        }
	        return listProduct;
	    }
	
	 public List<CartDetail> getCartDetailsByCartId(int cartId , ProductDAO pdb) {
	        List<CartDetail> cartDetails = new ArrayList<>();
	        String sql = "SELECT * FROM cart_detail WHERE Cart_id =?";
	        
	        try (Connection connection = DBContext.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	            preparedStatement.setInt(1, cartId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()) {
	                CartDetail cartDetail = new CartDetail();
	                // Lấy thông tin từ cột trong ResultSet và thiết lập cho đối tượng CartDetail
	                cartDetail.setCartDetailId(resultSet.getInt("cart_detail_id"));
	                cartDetail.setProduct(pdb.getProductById(resultSet.getInt("product_id")));
	                cartDetail.setQuantity(resultSet.getInt("c_quantity"));
	                cartDetail.setTotalMoney(resultSet.getDouble("totalmoney"));
	                
	                cartDetails.add(cartDetail);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Xử lý các ngoại lệ nếu có
	        }
	        
	        return cartDetails;
	    }
	 
	 public Cart getCartByUserId (int id)
	 {
		 Cart cart = null;
		 String sql = "SELECT * FROM cart where user_id=?";
		try {
			Connection connection = DBContext.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				cart = new Cart();
                cart.setCartId(rs.getInt("id"));
                cart.setUser_Id(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return cart;
	 }
	 public void deleteCart(int id)
	 {
		 String sql = "delete from pbl3.order where user_id=?";
		 Connection con = DBContext.getConnection();
		 try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			 int rowsAffected = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
	
	
	public static void main(String[] args) {
		CartDAO a = new CartDAO();
		ProductDAO pdb = new ProductDAO();
//		List<CartDetail> cartDetails = a.getCartDetailsByCartId(101, pdb);
//		System.out.println(cartDetails);
		
		Cart b = a.getCartByUserId(7);
		System.out.println(b);
	}
}



