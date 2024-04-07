package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Date date;
    private double totalMoney;
    private String description;
    private int userId;
    private List<Product> productList;

    public Order() {
        this.productList = new ArrayList<>();
    }

    public Order(int orderId, Date date, double totalMoney, String description, int userId, List<Product> productList) {
        this.orderId = orderId;
        this.date = date;
        this.totalMoney = totalMoney;
        this.description = description;
        this.userId = userId;
        this.productList = productList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", totalMoney=" + totalMoney +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", productList=" + productList +
                '}';
    }
}
