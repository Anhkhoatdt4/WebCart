package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import context.DBContext;
import model.Product;


public class ProductDAO {
	
	public boolean updateProduct(int pid, String newName, int newQuantity, double newPrice) {
	    String sql = "UPDATE product SET pname=?, pquantity=?, pprice=? WHERE pid=?";
	    try (Connection connection = DBContext.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setString(1, newName);
	        statement.setInt(2, newQuantity);
	        statement.setDouble(3, newPrice);
	        statement.setInt(4, pid);

	        int rowsUpdated = statement.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	
	public int getMaxProductId(int cid) {
	    String sql = "SELECT MAX(pid) AS maxId FROM product where  category_id=?";
	    try {Connection connection = DBContext.getConnection();
	    		PreparedStatement st = connection.prepareStatement(sql);
		    	st.setInt(1, cid);

	    	ResultSet resultSet = st.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getInt("maxId");
	        } else {
	          
	            return 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	
	public List<Product>getAll()
	{
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM PRODUCT";
		Connection connection = DBContext.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Product p = new Product(rs.getInt("pid"),
						rs.getString("pname"),
						rs.getString("pdesc"),
						rs.getString("pimage"),
						rs.getInt("psize"),
						rs.getInt("pquantity"),
						rs.getDouble("pprice"),
						rs.getInt("category_id")
						);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("trong khoi catch");
		}
		
		return list;
	}
	
	public Product getProductById(int id) {
	    String sql = "SELECT * FROM product WHERE pid=?";
	    Connection connection = DBContext.getConnection();
	    try (PreparedStatement st = connection.prepareStatement(sql)) {
	        st.setInt(1, id);
	        try (ResultSet rs = st.executeQuery()) {
	            if (rs.next()) {
	                return new Product(
	                        rs.getInt("pid"),
	                        rs.getString("pname"),
	                        rs.getString("pdesc"),
	                        rs.getString("pimage"),
	                        rs.getInt("psize"),
	                        rs.getInt("pquantity"),
	                        rs.getDouble("pprice"),
	                        rs.getInt("category_id")
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
	
	public List<Product> getListByPage(List<Product>list, int start , int end )
    {
    	List<Product>arr = new ArrayList<>();
    	for (int i = start ; i < end ; i ++ )
    	{
    		arr.add(list.get(i));
    	}
    	
    	return arr;
    	
    }
	
	public boolean addProduct(Product product) {
	    String sql = "INSERT INTO product (pid, pname, pdesc,pimage ,psize, pquantity, pprice, category_id) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
	    try (Connection connection = DBContext.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, product.getpId());
	        statement.setString(2, product.getPname());
	        statement.setString(3, product.getPdesc());
	        statement.setString(4, product.getPimage());
	        statement.setInt(5, product.getPsize());
	        statement.setInt(6, product.getPquantity());
	        statement.setDouble(7, product.getPprice());
	        statement.setInt(8, product.getCategory_id());
	        
	        int rowsInserted = statement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public List<Product> getListByCategoryID(int id)
	{
		List<Product> list = new ArrayList<>();
		String sql = "select * from product where category_id =?";
		Connection connection = DBContext.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Product p = new Product(rs.getInt("pid"),
						rs.getString("pname"),
						rs.getString("pdesc"),
						rs.getString("pimage"),
						rs.getInt("psize"),
						rs.getInt("pquantity"),
						rs.getDouble("pprice"),
						rs.getInt("category_id")
						);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("List get by category id");
		}
		return list;
	}
	
	public List<Product> searchProducts (String keyword)
    {
    	   List<Product> searchResults = new ArrayList<>();
    	   String sql = "SELECT * FROM product WHERE pname LIKE ?";
    	   Connection connection = DBContext.getConnection();
    	   try (PreparedStatement st = connection.prepareStatement(sql)) {
    	        st.setString(1, "%" + keyword + "%");
    	        try (ResultSet rs = st.executeQuery()) {    	     
    	            while (rs.next()) {
    	            	Product p = new Product(rs.getInt("pid"),
    							rs.getString("pname"),
    							rs.getString("pdesc"),
    							rs.getString("pimage"),
    							rs.getInt("psize"),
    							rs.getInt("pquantity"),
    							rs.getDouble("pprice"),
    							rs.getInt("category_id")
    							);
    	                searchResults.add(p);
    	            }
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	   return searchResults;
    }
	
	public Product getProductByName(String name) {
	    String sql = "SELECT * FROM product WHERE pname=?";
	    try (Connection connection = DBContext.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, name);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                return new Product(
	                        resultSet.getInt("pid"),
	                        resultSet.getString("pname"),
	                        resultSet.getString("pdesc"),
	                        resultSet.getString("pimage"),
	                        resultSet.getInt("psize"),
	                        resultSet.getInt("pquantity"),
	                        resultSet.getDouble("pprice"),
	                        resultSet.getInt("category_id")
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

	public List<Product> getTop5Product(String date) 
	{
		List<Product> list=new ArrayList<Product>();
		String sql="SELECT product.pid, product.pname,product.pdesc,product.pimage,product.psize,product.pquantity,product.pprice,product.category_id, SUM(order_detail.quantity) AS totalquantity "
	            + "FROM product "
	            + "JOIN order_detail ON product.pid = order_detail.product_id "
	            + "JOIN "
	            + "(SELECT pbl3.order.orderId "
	            + "FROM pbl3.order "
	            + "WHERE pbl3.order.date = ?) AS OD "
	            + "ON OD.orderId = order_detail.order_id "
	            + "GROUP BY product.pid, product.pname,product.pdesc,product.pimage,product.psize,product.pquantity,product.pprice,product.category_id "
	            + "ORDER BY totalquantity DESC "
	            + "LIMIT 5;";
	    Connection connection = DBContext.getConnection();
	    try {
	    	PreparedStatement st = connection.prepareStatement(sql);
	    	st.setString(1, date);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Product p = new Product(rs.getInt("pid"),
						rs.getString("pname"),
						rs.getString("pdesc"),
						rs.getString("pimage"),
						rs.getInt("psize"),
						rs.getInt("totalquantity"),
						rs.getDouble("pprice"),
						rs.getInt("category_id")
						);
				
				list.add(p);
			}
	    	
	    }
	    catch (SQLException e) {
			e.printStackTrace();
            System.out.println("trong khoi catch");
		}
		return list;
	}
	
	public Map< Product,Integer> getProductAndQuantity(String month) 
	{
		
		Map< Product,Integer> list=new HashMap<Product,Integer>();
		String sql=" SELECT product_id,SUM(quantity) AS Total FROM pbl3.order_detail JOIN pbl3.order ON pbl3.order_detail.order_id= pbl3.order.orderId"
				+ " WHERE pbl3.order.date LIKE ?"
				+ " GROUP BY product_id"
				+" ORDER BY Total DESC";
	    Connection connection = DBContext.getConnection();
	    ProductDAO a = new ProductDAO();
	    try {
	    	PreparedStatement st = connection.prepareStatement(sql);
	    	st.setString(1, "2024-"+month+"%");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				int pid=rs.getInt("product_id");
				int total=rs.getInt("Total");
				Product product = a.getProductById(pid);
				list.put(product, total);
			}
	    	
	    }
	    catch (SQLException e) {
			e.printStackTrace();
            System.out.println("trong khoi catch");
		}
		return list;
	}
	
	public boolean updateOrder(int PID) {
		String sql = "UPDATE product SET psize=0 WHERE pid = ?";
		try (Connection connection = DBContext.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1,PID);
			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Product> sapXep(String s)
	{
		ProductDAO dao=new ProductDAO();
		List<Product>   list= dao.getAll();
		 Comparator<Product> comparator = new Comparator<Product>() {
	            @Override
	            public int compare(Product p1, Product p2) {
	                // Thực hiện so sánh các trường tương ứng với chuỗi s
	                if (s.equals("id")) {
	                    if (p1.getpId()<p2.getpId()) return -1;
	                    else return 1;
	                } else if (s.equals("name")) {
	                    return p1.getPname().compareTo(p2.getPname());
	                }
	                else if (s.equals("price")) {
	                    if (p1.getPprice()<p2.getPprice()) return -1;
	                    else if (p1.getPprice()==p2.getPprice()) return 0;
	                    else return 1;
	                }else if (s.equals("quantity")) {
		                    if (p1.getPquantity()<p2.getPquantity()) return -1;
		                    else if (p1.getPquantity()==p2.getPquantity()) return 0;
		                    else return 1;}
	                return 0;
	            }
	        };

	        
	        Collections.sort(list, comparator);
	        return list;
	}
	
	
	
	
	public static void main(String[] args) {
		ProductDAO a = new ProductDAO();
		/* System.out.println(a.getAll()); */
		
		/*
		 * List<Product> top5Products = a.getTop5Product("2024-04-14");
		 * System.out.println("Top 5 products:" + top5Products);
		 * 
		 * 
		 * Map<Product, Integer> productAndQuantity = a.getProductAndQuantity("04");
		 * 
		 * for (Map.Entry<Product, Integer> entry : productAndQuantity.entrySet()) {
		 * System.out.println("Product: " + entry.getKey() + ", quantity : " +
		 * entry.getValue()); }
		 */
			 
	    
	}

}
