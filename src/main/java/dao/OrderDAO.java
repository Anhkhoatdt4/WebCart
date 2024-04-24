package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import context.DBContext;
import model.Order;
import model.User;

public class OrderDAO {
	
	public List<Order> getAllOrder(String month)
	{
		List<Order> list=new ArrayList<Order>();
		String sql="SELECT * FROM pbl3.order WHERE date LIKE ? ";
		try
		{
			Connection connection=DBContext.getConnection();
			PreparedStatement st = connection.prepareStatement(sql); 
			st.setString(1, "2024-" + month+"%");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Order order=new Order(rs.getInt("orderId"),rs.getDate("date"), rs.getDouble("totalmoney"),
						 rs.getInt("user_id"), null, rs.getString("status"),null);
				list.add(order);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	 public int IndexOfUser()
	 {
		 String sql = "SELECT max(orderId) FROM pbl3.order"
		 		 ;
		 try {
			Connection connection = DBContext.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				return rs.getInt("max(orderId)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return -1;
	 } 
	 
	 public void addOrderIntoDb(int orderID , Date date , double totalMoney, String status, int userID)
	 {
		 String sql = "INSERT INTO `order` (orderId, date, totalmoney, status, user_id) VALUES (?, ?, ?, ?, ?)";
		 try {
			Connection connection = DBContext.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, orderID);
			st.setDate(2, new java.sql.Date(date.getTime()));
			st.setDouble(3, totalMoney);
			st.setString(4,status);
			st.setInt(5, userID);
			st.executeUpdate();
			System.out.println("Them order Thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 
	 public void updateOrderStatus(int orderId, String newStatus) {
	        String sql = "UPDATE `order` SET status = ? WHERE orderId = ?";
	        
	        try (Connection connection = DBContext.getConnection();
	             PreparedStatement st = connection.prepareStatement(sql)) {
	            
	            st.setString(1, newStatus);
	            st.setInt(2, orderId);
	            
	            int rowsAffected = st.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("Trạng thái của đơn hàng đã được cập nhật.");
	            } else {
	                System.out.println("Không có đơn hàng nào được cập nhật.");
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public double[] getTotalMoneyByWeek(String s1, String s2)
		{
			double[] tam=new double[13];
			String sql="SELECT  date, SUM(totalmoney) AS total FROM pbl3.order "
					+"WHERE date BETWEEN ? AND ? AND status='Đã giao hàng' "
					+ "group by date";
			try {
				Connection connection=DBContext.getConnection();
				PreparedStatement st=connection.prepareStatement(sql);
				st.setString(1, s1);
				st.setString(2, s2);
				int i=1;
				ResultSet rs=st.executeQuery();
				while (rs.next())
				{
					tam[i]=rs.getDouble("total");
					i++;	
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return tam;
			
		}
		public double[] getTotalMoneyByMonth(int monthStart, int yearStart, int monthEnd, int yearEnd) {
		    double[] tam = new double[13]; // 13 vì chúng ta sẽ lấy dữ liệu từ tháng 1 đến tháng 12
		    String sql = "SELECT MONTH(date) AS month1, SUM(totalmoney) AS total " +
		                 "FROM pbl3.order " +
		                 "WHERE (YEAR(date) = ? AND MONTH(date) >= ?) OR " +
		                 "(YEAR(date) = ? AND MONTH(date) <= ?) AND status='Đã giao hàng' " +
		                 "GROUP BY MONTH(date)";
		    try {
		        Connection connection = DBContext.getConnection();
		        PreparedStatement st = connection.prepareStatement(sql);
		        st.setInt(1, yearStart);
		        st.setInt(2, monthStart);
		        st.setInt(3, yearEnd);
		        st.setInt(4, monthEnd);
		        int i = 0;
		        ResultSet rs = st.executeQuery();
		        while (rs.next()) {
		            tam[rs.getInt("month1")] = rs.getDouble("total");		            
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return tam;
		}
	 
	 public List<Order> getAllOrders() {
		    List<Order> orders = new ArrayList<>();
		    String sql = "SELECT * FROM `order`";
		    try (Connection connection = DBContext.getConnection();
		         PreparedStatement st = connection.prepareStatement(sql);
		         ResultSet rs = st.executeQuery()) {
		        while (rs.next()) {
		            Order order = new Order();
		            order.setOrderId(rs.getInt("orderId"));
		            order.setDate(rs.getDate("date"));
		            order.setTotalMoney(rs.getDouble("totalmoney"));
		            order.setStatus(rs.getString("status"));
		            order.setUserId(rs.getInt("user_id"));
		            // Nếu có thêm thuộc tính khác của đơn hàng, bạn có thể thêm vào đây
		            orders.add(order);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return orders;
		}
	 
	 public Order searchOrder(int id) {
		    String sql = "SELECT * FROM pbl3.order WHERE user_id = ? ORDER BY orderId DESC LIMIT 1";
		    Connection connection = DBContext.getConnection();
		    try (PreparedStatement st = connection.prepareStatement(sql)) {
		        st.setInt(1, id);
		        ResultSet rs = st.executeQuery();
		        if (rs.next()) {
		            return new Order(rs.getInt("orderId"),
		                    rs.getDate("date"),
		                    rs.getDouble("totalmoney"),
		                    rs.getString("status"),
		                    rs.getInt("user_id"));
		        } else {
		            System.out.println("Không có order nào phù hợp.");
		            return null;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}

	 public List<Integer> getOrderIds(String status, int uId) {
		    List<Integer> orderIds = new ArrayList<>();
		    String sql = "SELECT orderID FROM pbl3.order where status = ? and user_id = ?";
		    try {
		        Connection conn = DBContext.getConnection();
		        PreparedStatement st = conn.prepareStatement(sql);
		        st.setString(1, status);
		        st.setInt(2, uId);
		        ResultSet rs = st.executeQuery();
		        while (rs.next()) {
		            orderIds.add(rs.getInt("orderID"));
		        }
		    } catch (Exception e) {
		        // Handle exception
		        e.printStackTrace();
		    }
		    return orderIds;
		}
	 
	 public void deleteOrder(int id)
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
		 OrderDAO a = new OrderDAO();
		 System.out.println(a.getAllOrder("04"));
			/* System.out.println(a.getTotalMoneyByMonth(11,2023,4,2024)[3]); */
			System.out.println(a.getTotalMoneyByWeek("2024-03-14", "2024-04-20")[3]);
//			 a.addOrderIntoDb(4, new Date(),2000 , "cho xac nhan", 3);
//			 a.updateOrderStatus(4, "Chờ xác nhận");
			/* System.out.println(a.getAllOrders()); */
	}
}
