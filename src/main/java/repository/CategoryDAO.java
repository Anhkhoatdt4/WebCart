package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Category;

public class CategoryDAO {
	public List<Category> getAll()
	{
		List<Category> list = new ArrayList<>();
		String sql = "SELECT * FROM category";
		Connection connection = DBContext.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Category p = new Category(rs.getInt("cid"),
						rs.getString("cname")
						);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("trong khoi catch");
		}
		
		return list;
	}
	
	public int[] getTotalCategoryByMonth(String s)
	{
		int[] tam=new int[5];
		String sql="select cid,cname,SUM(quantity) as total from "
				+"(select product.pid,cid ,category.cname from product join category on product.category_id=cid   )  AS TAM "
				+"join "
				+"( select product_id, SUM(quantity) as quantity from order_detail join pbl3.order on order_detail.order_id= pbl3.order.orderId "
				+"where date like ? "
				+"group by product_id)  as TAM2 "
				+"on TAM.pid=TAM2.product_id "
				+"group by cid,category.cname "
				+"order by cid ";
		System.out.println("Ok");
		try {
			Connection connection=DBContext.getConnection();
			PreparedStatement st=connection.prepareStatement(sql);
			st.setString(1, "%" + s +"%");
			int i=1;
			ResultSet rs=st.executeQuery();

			while (rs.next())
			{		

				tam[i]=rs.getInt("total");
				System.out.println("OK1"+tam[i]);
				i++;	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tam;
	}
	public static void main(String[] args) {
		CategoryDAO categoryDAO = new CategoryDAO();
	    int[] result = categoryDAO.getTotalCategoryByMonth("04");

	    // In ra mảng kết quả
	    for (int i = 1; i < result.length; i++) {
	        System.out.println("Category " + (i ) + ": " + result[i]);
	    }
	}
}
