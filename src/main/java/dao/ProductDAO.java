package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import context.DBContext;
import model.Product;


public class ProductDAO {
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
	
	public static void main(String[] args) {
		ProductDAO a = new ProductDAO();
		List<Product> searchResults = a.searchProducts("%nike%");
//		System.out.println(searchResults);
//		List<Product> list = a.searchProducts("%jordan%");
//		System.out.println(list);
//		List<Product> list = a.getListByPage(a.getAll(), 0, 5);
//		System.out.println(list);
//		for (Product p : list) {
//            System.out.println(p);
//        }
//		 System.out.println("\nTesting getProductById() method:");
//		 Product b = a.getProductById(1);
//		 System.out.println(b);
//		
//		List<Product> list = a.getListByCategoryID(3);
//		System.out.println(list);
		
		 
	}

}
