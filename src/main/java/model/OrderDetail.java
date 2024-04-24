package model;

public class OrderDetail {
    private int orderDetailId;
    private int productID;
    private int quantity;
    private double price;
    private int orderId; 
    
    public OrderDetail()
    {
    	
    }

	public OrderDetail(int orderDetailId, int productID, int quantity, double price, int orderId) {
		this.orderDetailId = orderDetailId;
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
		this.orderId = orderId;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", productID=" + productID + ", quantity=" + quantity
				+ ", price=" + price + ", orderId=" + orderId + "]";
	}

	
    
}
