package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import context.DBContext;
import model.User;

public class UserDAO {
	
	public List<User> getAllAccount()
	{
		List<User> list = new ArrayList<>();
		String sql = "select * from user";
		Connection connection = DBContext.getConnection();
	    try (PreparedStatement st = connection.prepareStatement(sql)) {	       
	        ResultSet rs = st.executeQuery();
	            while (rs.next())
	            {
	            	if (rs.getInt("role")==0)
	            	{
	               User a =  new User(rs.getInt("userid"),
	            		   rs.getString("username"),
	            		   rs.getString("password"),
	            		   rs.getString("address"),
	            		   rs.getString("uPhone"),
	            		   rs.getInt("role"));
	               list.add(a);}
	            } 
	           
	     }catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
		return list;
	}
	
	public void changePass(int userId, String newPassword) {
	    String sql = "UPDATE user SET password = ? WHERE user.userid = ?";
	    try (Connection connection = DBContext.getConnection();
	         PreparedStatement st = connection.prepareStatement(sql)) {
	        st.setString(1, newPassword);
	        st.setInt(2, userId);
	        int rowsAffected = st.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Cập nhật mật khẩu thành công.");
	        } else {
	            System.out.println("Không thể cập nhật mật khẩu.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
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
	 
	 public void deleteUser(int userId) {
	        String sql = "DELETE FROM user WHERE userid=?";
	        Connection connection = DBContext.getConnection();
	        try (PreparedStatement st = connection.prepareStatement(sql)) {
	        	 System.out.println("Trong phần deleteUser");
	            st.setInt(1, userId);
	            int rowsAffected = st.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	
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
	 
	 public List<Integer> getIdByUser()
	 {
		 List<Integer>list = new ArrayList<>();
		 String sql = "Select userid from user";
		 try {
		        Connection conn = DBContext.getConnection();
		        PreparedStatement st = conn.prepareStatement(sql);

		        ResultSet rs = st.executeQuery();
		        while (rs.next()) {
		            list.add(rs.getInt("userid"));
		        }
		    } catch (Exception e) {
		        // Handle exception
		        e.printStackTrace();
		    }
		 return list;
	 }
	 
	 public User getUserById(int id) {
		    String sql = "SELECT * FROM user WHERE userid=?";
		    Connection connection = DBContext.getConnection();
		    try (PreparedStatement st = connection.prepareStatement(sql)) {
		        st.setInt(1, id);
		        try (ResultSet rs = st.executeQuery()) {
		            if (rs.next()) {
		                return new User(
		                        rs.getInt("userid"),
		                        rs.getString("username"),
		                        rs.getString("password"),
		                        rs.getString("address"),
		                        rs.getString("uPhone"),
		                        rs.getInt("role")
		                       
		                );
		            } else {
		                return null;
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
	 public Map<Double, User> getUserAndTotalByMonth(String month)
		{
			UserDAO a = new UserDAO();
		    Map<Double, User> map = new TreeMap<>(Collections.reverseOrder());
			String sql="SELECT user_id,SUM(tableorder.totalmoney) AS total FROM user JOIN tableorder on user.userid=tableorder.user_id"
					+ " WHERE date LIKE ?"
					+ " GROUP BY userid"
					+ " ORDER BY total DESC";
			try {
				Connection concection=DBContext.getConnection();
				PreparedStatement st=concection.prepareStatement(sql);
				st.setString(1, "2024-"+month+"%");
				ResultSet rs=st.executeQuery();
				while (rs.next())
				{
					int uid=rs.getInt("user_id");
					double total=rs.getDouble("total");
					
					map.put( total,a.getUserById(uid));
					System.out.println(map+"\n");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		}

	 public List<User> sapXep(String s)
		{
		 UserDAO dao=new UserDAO();
			List<User>   list= dao.getAllAccount();
			 Comparator<User> comparator = new Comparator<User>() {
		            @Override
		            public int compare(User p1, User p2) {
		                // Thực hiện so sánh các trường tương ứng với chuỗi s
		                /*if (s.equals("id")) {
		                    if (p1.getOrderId()<p2.getOrderId()) return -1;
		                    else return 1;
		                } else if (s.equals("date")) {
		                    return p1.getDate().compareTo(p2.getDate());
		                }
		                else if (s.equals("total")) {
		                    if (p1.getTotalMoney()<p2.getTotalMoney()) return -1;
		                    else if (p1.getTotalMoney()==p2.getTotalMoney()) return 0;
		                    else return 1;
		                }else if (s.equals("nameUser"))  return p1.getUser().getUsername().compareTo(p2.getUser().getUsername());
			                    
		                else if (s.equals("status")) {
		                    return p1.getStatus().compareTo(p2.getStatus());
		                }*/
		                return 0;
		            }
		        };

		        
		        Collections.sort(list, comparator);
		        return list;
		}
	 
	 public void docTuFile(String path)
	 {
		 try (FileInputStream fis = new FileInputStream(path);
	             Workbook workbook = WorkbookFactory.create(fis)) {

	            Sheet sheet = workbook.getSheetAt(0);
	            DataFormatter dataFormatter = new DataFormatter();

	            boolean firstRow = true; // Biến để kiểm tra dòng đầu tiên

	            for (org.apache.poi.ss.usermodel.Row row : sheet) {
	                if (firstRow) {
	                    firstRow = false; // Đánh dấu dòng đầu tiên đã qua
	                    continue; // Bỏ qua xử lý dữ liệu cho dòng đầu tiên
	                }
	                String column1 = dataFormatter.formatCellValue(row.getCell(0));
	                String column2 = dataFormatter.formatCellValue(row.getCell(1));
	                String column3 = dataFormatter.formatCellValue(row.getCell(2));
	                String column4 = dataFormatter.formatCellValue(row.getCell(3));
	                String column5 = dataFormatter.formatCellValue(row.getCell(4));
	                UserDAO dao=new UserDAO();
	                User user=new User(Integer.parseInt(column1), column2, column3, column4, column5, 0);
	                System.out.println(user);
	                dao.addUser(user);
	           
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }

	 

	 
	public static void main(String[] args) {
		UserDAO a = new UserDAO();
		System.out.println(a.getIdByUser());
//		System.out.println(a.getAllAccount());
		// a.addUser(new User(8, "eqw", "123456", "ee", "01234", 0));
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
