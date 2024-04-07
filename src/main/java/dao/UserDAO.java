package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import context.DBContext;
import model.User;

public class UserDAO {
	public User login(String username , String password)
	{
		String sql = "select * from user where username=? and password=?";
		Connection connection = DBContext.getConnection();
	    try (PreparedStatement st = connection.prepareStatement(sql)) {
	        st.setString(1, username);
	        st.setString(2, password);
	        ResultSet rs = st.executeQuery();
	            if (rs.next())
	            {
	               return new User(rs.getInt("userid"),
	            		   rs.getString("username"),
	            		   rs.getString("password"),
	            		   rs.getString("address"),
	            		   rs.getString("uPhone"),
	            		   rs.getInt("role"));
	            } 
	            else 
	            {
	            	System.out.println("Khong co tai khoan nao hop le. ");
	                return null;
	            }
	     }catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public boolean addUser(User user)
	{
		String sql = "insert into user (userid,username,password,address,uPhone,role) values(? , ? ,?, ?, ? , ?)";
		try (	Connection connection = DBContext.getConnection();
	             PreparedStatement st = connection.prepareStatement(sql)) {

	            System.out.println("Trong phần add User");
	            st.setInt(1, user.getUserid());
	            st.setString(2, user.getUsername());
	            st.setString(3, user.getPassword());
	            st.setString(4, user.getAddress());
	            st.setString(5, user.getuPhone());
	            st.setInt(6, 0);

	            int rowsInserted = st.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            System.out.println("Lỗi: " + e.getMessage());
	            return false;
	        }
	    }
	
	 public boolean updateUser(User user) {
	        String sql = "UPDATE user SET username=?, password=?,address=?,uPhone=?, role=? WHERE userid=?";
	        Connection connection = DBContext.getConnection();
	        try (PreparedStatement st = connection.prepareStatement(sql)) {
	            st.setString(1, user.getUsername());
	            st.setString(2, user.getPassword());
	            st.setString(3, user.getAddress());
	            st.setString(4, user.getuPhone());
	            st.setInt(5, user.getRole());
	            st.setInt(6, user.getUserid());
	            int rowsAffected = st.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 public boolean deleteUser(int userId) {
	        String sql = "DELETE FROM user WHERE userid=?";
	        Connection connection = DBContext.getConnection();
	        try (PreparedStatement st = connection.prepareStatement(sql)) {
	        	 System.out.println("Trong phần deleteUser");
	            st.setInt(1, userId);
	            int rowsAffected = st.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 public int IndexOfUser()
	 {
		 String sql = "select max(userid) from user";
		 try {
			Connection connection = DBContext.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				return rs.getInt("max(userid)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return -1;
	 }
	 
	 public static String generateRandomPhoneNumber() {
	        Random random = new Random();
	        StringBuilder phoneNumber = new StringBuilder("0"); 
	        for (int i = 0; i < 7; i++) { 
	            phoneNumber.append(random.nextInt(10));
	        }
	        return phoneNumber.toString();
	    }
	 
	 public int getUserIdByUsernameAndPassword(String username, String password) {
		    String sql = "SELECT userid FROM user WHERE username = ? AND password = ?";
		    try (Connection connection = DBContext.getConnection();
		         PreparedStatement st = connection.prepareStatement(sql)) {
		        st.setString(1, username);
		        st.setString(2, password);
		        ResultSet rs = st.executeQuery();
		        if (rs.next()) {
		            return rs.getInt("userid");
		        } else {
		            return -1; 
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return -1; 
		    }
		}


	 
	public static void main(String[] args) {
		UserDAO a = new UserDAO();
		a.addUser(new User(8, "eqw", "123456", "ee", "01234", 0));
//		User b = a.login("congbao", "456");
//		
//		System.out.println(b);
//		
//		
//        User userToUpdate = new User(50, "aer", "newPassword","sai gon" ,"0987654321", 0); // Đối tượng User cần cập nhật
//        boolean updateSuccess = a.updateUser(userToUpdate);
//        if (updateSuccess) {
//            System.out.println("Cập nhật thông tin người dùng thành công.");
//        } else {
//            System.out.println("Không thể cập nhật thông tin người dùng.");
//        }
//        System.out.println(a.IndexOfUser());
//        UserDAO userDAO = new UserDAO();
//        int userId = userDAO.getUserIdByUsernameAndPassword("congbao", "456");
//        if (userId != -1) {
//            System.out.println("User id tương ứng: " + userId);
//        } else {
//            System.out.println("Không tìm thấy user id cho username và password đã cho.");
//        }
//        boolean deleteSuccess = a.deleteUser(5);
//        if (deleteSuccess) {
//            System.out.println("Xóa thông tin người dùng thành công.");
//        } else {
//            System.out.println("Không thể xóa thông tin người dùng.");
//        }
	}
}
