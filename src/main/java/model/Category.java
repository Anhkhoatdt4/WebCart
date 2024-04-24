package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;

public class Category {
	private int cid;
	private String cname;
	public Category() {
	
	}
	public Category(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
	
	public static List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (

            Connection connection = DBContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category");
            ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                int cid = resultSet.getInt("cid");
                String cname = resultSet.getString("cname");
                Category category = new Category(cid, cname);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
	

}
