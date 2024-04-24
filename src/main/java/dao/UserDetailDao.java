package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.User;
import model.UserDetail;

public class UserDetailDao {
	public List<UserDetail> getUserDetailList()
	{
		List<UserDetail> list = new ArrayList<>();
		String sql = "select * from user_detail";
		Connection conn = DBContext.getConnection();
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{
				UserDetail u = new UserDetail(rs.getInt("id"), rs.getString("fullname"), rs.getInt("user_Id"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public int IndexOfUser()
	 {
		 String sql = "select max(id) from user_detail";
		 try {
			Connection connection = DBContext.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				return rs.getInt("max(id)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return -1;
	 }
	
	public boolean addUserDetail(UserDetail userD)
	{
		String sql = "insert into user_detail (id, fullname,user_Id,deleted) values(? , ? ,?, ?)";
		try (	Connection connection = DBContext.getConnection();
	             PreparedStatement st = connection.prepareStatement(sql)) {

	            st.setInt(1, userD.getUDId());
	            st.setString(2, userD.getFullname());
	            st.setInt(3, userD.getUserId());
	            st.setInt(4, 0);
	            System.out.println("Trong phần add UserDetail");

	            int rowsInserted = st.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            System.out.println("Lỗi: " + e.getMessage());
	            return false;
	        }
	    }
	
	
	public void updateFullName(int id, String newFullName) {
	    String sql = "UPDATE user_detail SET fullname = ? WHERE user_Id = ?";
	    Connection conn = null;
	    PreparedStatement st = null;
	    try {
	        conn = DBContext.getConnection();
	        st = conn.prepareStatement(sql);
	        st.setString(1, newFullName);
	        st.setInt(2, id);
	        st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}
	
	public void deleteUserDetail(int id)
	 {
		 String sql = "delete from pbl3.user_detail where user_Id=?";
		 Connection con = DBContext.getConnection();
		 try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			 int rowsAffected = st.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		 
	 }
	
	public void updateDeleted(int id)
	{
		String sql = "update pbl3.user_detail set deleted = 1 where user_Id = ?";
		Connection con = DBContext.getConnection();
		 try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, id);
				 int rowsAffected = st.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			 
	}
	
	public List<Integer> getIdByUserDetail()
	 {
		 List<Integer>list = new ArrayList<>();
		 String sql = "Select user_Id from user_detail where deleted = 0";
		 try {
		        Connection conn = DBContext.getConnection();
		        PreparedStatement st = conn.prepareStatement(sql);

		        ResultSet rs = st.executeQuery();
		        while (rs.next()) {
		            list.add(rs.getInt("user_Id"));
		        }
		    } catch (Exception e) {
		        // Handle exception
		        e.printStackTrace();
		    }
		 return list;
	 }
	
	
	public static void main(String[] args) {
		UserDetailDao a = new UserDetailDao();
		System.out.println(a.getIdByUserDetail());
		System.out.println(a.getUserDetailList());
	}
}
