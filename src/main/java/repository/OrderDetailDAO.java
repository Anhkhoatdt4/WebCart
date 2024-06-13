package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import context.DBContext;
import model.OrderDetail;
import model.Product;

public class OrderDetailDAO {
    public boolean addOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO order_detail (orderdetail_id, product_id, quantity, price, order_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderDetail.getOrderDetailId());
            statement.setInt(2, orderDetail.getProductID());
            statement.setInt(3, orderDetail.getQuantity());
            statement.setDouble(4, orderDetail.getPrice());
            statement.setInt(5, orderDetail.getOrderId());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public OrderDetail getOrderDetailByOrderIdAndProductId(int orderId, int productId) {
        String sql = "SELECT * FROM order_detail WHERE order_id = ? AND product_id = ?";
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            statement.setInt(2, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailId(resultSet.getInt("orderdetail_id"));
                orderDetail.setOrderId(resultSet.getInt("order_id"));
                orderDetail.setQuantity(resultSet.getInt("quantity"));
                orderDetail.setPrice(resultSet.getDouble("price"));
                Product product = new Product();
                product.setpId(resultSet.getInt("product_id"));
                
                return orderDetail;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int IndexOfOrderDetail()
	 {
		 String sql = "select max(orderdetail_id) from order_detail";
		 try {
			Connection connection = DBContext.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				return rs.getInt("max(orderdetail_id)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return -1;
	 }
   
    public List<OrderDetail> getAllOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String sql = "SELECT * FROM order_detail";
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailId(resultSet.getInt("orderdetail_id"));
                orderDetail.setProductID(resultSet.getInt("product_id"));
                orderDetail.setQuantity(resultSet.getInt("quantity"));
                orderDetail.setPrice(resultSet.getDouble("price"));
                orderDetail.setOrderId(resultSet.getInt("order_id"));
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    
    public OrderDetail listGetOrderDetail(int id)
    {
    	String sql = "Select * from order_detail where order_id = ? "
    			+"order by order_detail.orderdetail_id "
    			+ "limit 1";
    	OrderDetail orderDetail=new OrderDetail();
    	Connection conn = DBContext.getConnection();
    	try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				orderDetail= new OrderDetail(rs.getInt("orderdetail_id"), rs.getInt("product_id"), rs.getInt("quantity"), rs.getDouble("price"), id);
			}
			return orderDetail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return null;
    }
    
    public void deleteOrderDetail(int id)
	 {
		 String sql = "delete from order_detail where order_id=?";
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
    
    public  Map<Product,Integer> getProductByOrderId(int id)
    {
		Map<Product,Integer> list=new HashMap<Product, Integer>();
    	String sql="SELECT * FROM order_detail WHERE order_id = ? ";
    	 try (Connection connection = DBContext.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                  int proId=resultSet.getInt("product_id");
                  //System.out.println();
                  ProductDAO proDao=new ProductDAO();
                  Product pro=proDao.getProductById(proId);
  				list.put(pro,resultSet.getInt("quantity"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    	 return list;
    }
    
    public static void main(String[] args) {
		OrderDetailDAO a = new OrderDetailDAO();
		System.out.println(a.listGetOrderDetail(12));
//		List<OrderDetail> b = a.listGetOrderDetail(4);
//		System.out.println(b);
//		System.out.println(a.getOrderId("Đang vận chuyển", 2));
//		OrderDetail b = new OrderDetail();
//		b.setOrderDetailId(3);
//		b.setProductID(2);
//		b.setQuantity(2);
//		b.setPrice(10000);
//		b.setOrderId(1);
//		System.out.println(b);
//		boolean success = a.addOrderDetail(b); // Thay các giá trị 3, 2, 3, 2000 bằng các giá trị thực tế tương ứng
//		if (success) {
//		    System.out.println("Thêm chi tiết đơn hàng thành công.");
//		} else {
//		    System.out.println("Thêm chi tiết đơn hàng thất bại.");
//		}
//		System.out.println(a.IndexOfOrderDetail());
	}
    
    
}
