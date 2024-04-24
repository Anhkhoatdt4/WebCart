package dao;

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
	public static void main(String[] args) {
		CategoryDAO a = new CategoryDAO();
		System.out.println(a.getAll());
	}
}
