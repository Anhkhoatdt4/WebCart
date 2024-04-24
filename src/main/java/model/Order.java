package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Date date;
    private double totalMoney;
    private int userId;
    private User user ;
    private String status;
    private List<OrderDetail> listOrder; 
    

    public Order() {
        listOrder = new ArrayList<>();
    }
    
    public Order(int orderId, Date date, double totalMoney, String status, int userId) {
        this.orderId = orderId;
        this.date = date;
        this.totalMoney = totalMoney;
        this.status = status;
        this.userId = userId;
    }
    
    public Order(int orderId, Date date, double totalMoney, int userId, User user, String status, List<OrderDetail> listOrder) {
        this.orderId = orderId;
        this.date = date;
        this.totalMoney = totalMoney;
        this.userId = userId;
        this.user = user;
        this.status = status;
        this.listOrder = listOrder;
    }

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetail> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<OrderDetail> listOrder) {
		this.listOrder = listOrder;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", totalMoney=" + totalMoney + ", userId=" + userId
				+ ", user=" + user + ", status=" + status + ", listOrder=" + listOrder + "]";
	}
    
}
